
def initPlayers():
    global PlayerList
    PlayerList = list()

def createNewPlayer(name="",
              damage=0,
              defensePower=0):
    return dict(name=name,
              score=0,
              damage=int(damage),
              health=100,
              defensePower=int(defensePower),
              defense=False)

def addPlayer(player):
    PlayerList.append(player)
def removePlayer(name):
    for idx, player in enumerate(PlayerList):
        if(player.get("name") == name):
            del PlayerList[idx]
            break
        else:
            print("There is no player with that name!")
def setPlayer(player, key, value):
    player[key] = value
def attackPlayer(attacker:dict, target:dict):
    if(target.get("defense") == True):
        attackScore = round(attacker.get("score") + 1 - 1 / target["defensePower"],2)
        targetHealth = target.get("health") -  attacker.get("damage") + target.get("defensePower")
    else:
        attackScore = attacker.get("score") + 1
        targetHealth = target.get("health") -  attacker.get("damage")
    setPlayer(attacker,"score", attackScore)
    setPlayer(target,"health", targetHealth)
    setPlayer(target,"defense",False)
def displayMatchResult():
    PlayerListSorted = sorted(
        PlayerList,
        key=lambda player: (-player['score'], -player['health'])
    )
    result = PlayerListSorted
    for rank, player in enumerate(result, start=1):
        print(f"Rank {rank}: {player['name']} | Score: {player['score']} | Health: {player['health']}")
