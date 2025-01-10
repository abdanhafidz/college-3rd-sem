import sys

sys.setrecursionlimit(10**9)



memo = dict()

def dp(n:int):
    if(n < 0): return float('inf')
    if(n == 0): return 0
    if(n in [1,5,10,20,100]):return 1
    else:
        if(memo.get(n) != None):
            return memo[n]
        else:
            if(n >= 100):
                memo[n] = dp(n%100) + n // 100
            elif(n >= 20):
                memo[n] = dp(n%20) + n // 20
            elif(n >= 10):
                memo[n] = dp(n%10) + n // 10
            elif(n >= 5):
                memo[n] = dp(n%5) + n // 5
            else:
                memo[n] = dp(n%1) + n // 1
            return memo[n]
    
N = int(input())
print(dp(N))
