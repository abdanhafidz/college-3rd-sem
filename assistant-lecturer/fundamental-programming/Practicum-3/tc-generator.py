import random
# Testcases will be 1 <= a , b <= 10^23

#TestCase 0 (Sample):
import sys
sys.setrecursionlimit(10 ** 9)

memo = dict()
MOD = 10**9 + 7
def f(n):
    if(memo.get(n) != None): # Base case
        return memo[n]
    else:
        if(n <= 0):
            return 0
        elif(n == 1):
            return 0
        elif(n == 2):
            return 1
        elif(n == 3):
            return 1
        elif(n == 4):
            return 2
        else:
            memo[n] = ((f(n - 2)%MOD) + (f(n - 3)%MOD) + (f(n - 4)%MOD))%MOD
            return memo[n]

for j in range(1,11):
    s = 1
    for i in range(0,7):
        n = random.randrange(10**i,10**(i+1) - 1)
        fIn = open(f"input/secret_{j}_{s}.in", "a")
        fIn.write(f"{n}\n")
        fIn.close()

        fOut = open(f"output/secret_{j}_{s}.ans", "a")
        fOut.write(f"{f(n)}\n")
        fOut.close()
        s+=1

