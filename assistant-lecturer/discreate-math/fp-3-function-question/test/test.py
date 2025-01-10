import unittest
from unittest.mock import patch
from src import game as m

class TestGameFunctions(unittest.TestCase):
    
    def setUp(self):
        """Inisialisasi PlayerList sebelum setiap test."""
        m.initPlayers()
    
    def test_initPlayers(self):
        """Test fungsi initPlayers untuk memastikan PlayerList di-reset."""
        self.assertEqual(len(m.PlayerList), 0)

    def test_createNewPlayer(self):
        """Test fungsi createNewPlayer untuk membuat pemain baru."""
        player = m.createNewPlayer(name="TestPlayer", damage=30, defensePower=15)
        self.assertEqual(player['name'], "TestPlayer")
        self.assertEqual(player['damage'], 30)
        self.assertEqual(player['defensePower'], 15)
        self.assertEqual(player['health'], 100)
        self.assertFalse(player['defense'])
        self.assertEqual(player['score'], 0)

    def test_addPlayer(self):
        """Test fungsi addPlayer untuk menambahkan pemain ke PlayerList."""
        player = m.createNewPlayer(name="Player1", damage=10, defensePower=5)
        m.addPlayer(player)
        self.assertIn(player, m.PlayerList)

    def test_setPlayer(self):
        """Test fungsi setPlayer untuk memperbarui atribut pemain."""
        player = m.createNewPlayer(name="Player1", damage=10, defensePower=5)
        m.setPlayer(player, "health", 80)
        self.assertEqual(player['health'], 80)

    def test_attackPlayer(self):
        """Test fungsi attackPlayer untuk menyerang pemain lain.""" 
        attacker = m.createNewPlayer(name="Attacker", damage=20, defensePower=10)
        target = m.createNewPlayer(name="Target", damage=10, defensePower=5)

        # Case: Target tidak dalam mode defense
        m.attackPlayer(attacker, target)
        self.assertEqual(attacker.get("score"), 1)
        self.assertEqual(target.get("health"), 80)  # 100 - 20

        # Case: Target dalam mode defense dengan perhitungan terbaru
        m.setPlayer(target, "defense", True)
        m.attackPlayer(attacker, target)

        # Perhitungan perbaruan score dan health dengan defense aktif
        
        self.assertAlmostEqual(attacker.get("score"), 1.8)  # Memastikan score dihitung dengan benar
        self.assertEqual(target.get("health"), 65)  # Memastikan health dihitung dengan benar
        self.assertFalse(target.get("defense"))  # Mode defense harus off setelah diserang

    @patch("builtins.print")
    def test_displayMatchResult(self, mock_print):
        """Test fungsi displayMatchResult untuk mengurutkan dan menampilkan hasil."""
        player1 = m.createNewPlayer(name="Player1", damage=10, defensePower=5)
        player2 = m.createNewPlayer(name="Player2", damage=20, defensePower=10)
        player3 = m.createNewPlayer(name="Player3", damage=15, defensePower=8)

        m.addPlayer(player1)
        m.addPlayer(player2)
        m.addPlayer(player3)

        # Update score dan health untuk peringkat
        m.setPlayer(player1, "score", 50)
        m.setPlayer(player2, "score", 70)
        m.setPlayer(player3, "score", 70)
        m.setPlayer(player3, "health", 90)  # Player3 harus di atas Player2 dalam hasil

        # Panggil fungsi untuk menampilkan hasil
        m.displayMatchResult()

        # Periksa output yang dihasilkan oleh print
        expected_output = [
            "Rank 1: Player2 | Score: 70 | Health: 100",
            "Rank 2: Player3 | Score: 70 | Health: 90",
            "Rank 3: Player1 | Score: 50 | Health: 100",
        ]
        # Flatten hasil print
        printed_output = [call.args[0] for call in mock_print.call_args_list]
        
        self.assertEqual(printed_output, expected_output)
    
    def test_removePlayer(self):
        """Test fungsi removePlayer untuk menghapus pemain dari PlayerList."""
        player1 = m.createNewPlayer(name="Player1", damage=10, defensePower=5)
        player2 = m.createNewPlayer(name="Player2", damage=20, defensePower=10)

        m.addPlayer(player1)
        m.addPlayer(player2)

        # Pastikan player2 ada sebelum dihapus
        self.assertIn(player2, m.PlayerList)

        m.removePlayer("Player2")

        # Pastikan player2 telah dihapus
        self.assertNotIn(player2, m.PlayerList)

        # Coba menghapus pemain yang tidak ada
        with patch("builtins.print") as mock_print:
            m.removePlayer("NonExistentPlayer")
            mock_print.assert_called_with("There is no player with that name!")

    def test_attackPlayer_using_setPlayer_for_modification(self):
        """Test bahwa attackPlayer menggunakan setPlayer untuk mengubah status pemain.""" 
        attacker = m.createNewPlayer(name="Attacker", damage=20, defensePower=10)
        target = m.createNewPlayer(name="Target", damage=10, defensePower=5)
        m.attackPlayer(attacker, target)
        # Case: Target tidak dalam mode defense
        with patch('src.game.setPlayer') as mock_setPlayer:
            m.attackPlayer(attacker, target)
            mock_setPlayer.assert_called()  # Pastikan setPlayer dipanggil di dalam attackPlayer
            self.assertEqual(attacker.get("score"), 1)
            self.assertEqual(target.get("defense"), False)
            self.assertEqual(target.get("health"), 80)  # 100 - 20
        # Case: Target dalam mode defense dengan perhitungan terbaru
        m.setPlayer(target, "defense", True)
        m.attackPlayer(attacker, target)
        with patch('src.game.setPlayer') as mock_setPlayer:
            m.attackPlayer(attacker, target)
            mock_setPlayer.assert_called()  # Pastikan setPlayer dipanggil di dalam attackPlayer
            self.assertEqual(attacker.get("score"), 1.8)  # Bertambah dengan perhitungan score
            self.assertEqual(target.get("health"), 65)  # 80 - (20 - 5)
            self.assertFalse(target.get("defense"))  # Mode defense harus off setelah diserang

if __name__ == "__main__":
    unittest.main()
