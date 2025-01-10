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
n = int(input())
print(f(n))