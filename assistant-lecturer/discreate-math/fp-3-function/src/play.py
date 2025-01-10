import game

game.initPlayers()
Zoro = game.createNewPlayer(
    name="Zoro",
    damage = "20",
    defensePower="10"
    )
Luffy = game.createNewPlayer(
    name="Luffy",
    damage = "50",
    defensePower="20"
    )
Pitty = game.createNewPlayer(
    name="Pitty",
    damage = "10",
    defensePower="5"
    )
game.addPlayer(Zoro)
game.addPlayer(Luffy)
game.addPlayer(Pitty)
print("Players that entered the game :", game.PlayerList)
print("Zoro attacking Luffy, without Luffy being Defensive")
game.attackPlayer(Zoro,Luffy)
print("Zoro's Score", Zoro.get("score"), " x Luffy' Health : ", Luffy.get("health"))

print("Luffy attacking Pitty, Pitty being Defensive")
game.setPlayer(Pitty, "defense", True)
game.attackPlayer(Luffy, Pitty)
print("Zoro's Score", Luffy.get("score"), " x Luffy' Health : ", Pitty.get("health"))
game.displayMatchResult()
print("Zoro Disqualified")
game.removePlayer("Zoro")
game.displayMatchResult()
