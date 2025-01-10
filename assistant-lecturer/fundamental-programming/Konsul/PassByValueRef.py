Monster = {
    "Health":100,
    "Score":0,
    "Damage":5
}
Knight = {
    "Health":100,
    "Score":0,
    "Damage":10
}
HealthMonster = 100
DamageKnight = 10
def attackbyValue(Health,Damage):
    Health -= Damage

attackbyValue(HealthMonster,DamageKnight)
print(HealthMonster)

def attack(attacker,target):
    attacker["Score"]+=1
    target["Health"] -= attacker["Damage"]

attack(Knight,Monster)
print(Knight["Score"])
print(Monster["Health"])