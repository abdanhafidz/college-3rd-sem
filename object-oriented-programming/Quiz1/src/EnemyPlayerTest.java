public class EnemyPlayerTest {
    public static void main(String[] args) {
        // Create a Player object
        Player player = new Player("Hero", 100, 20, 10);

        // Create an Enemy object
        Enemy enemy = new Enemy("Villain", 80, 15, 5);

        // Testing attack and takeDamage interactions
        player.attack(enemy); // Player attacks Enemy
        enemy.attack(player); // Enemy attacks Player
        player.attack(enemy); // Player attacks Enemy again
    }
}
