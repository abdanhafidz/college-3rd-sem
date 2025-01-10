import sys
sys.setrecursionlimit(10 ** 9)

memo = dict()

def dp(n):
    if(memo.get(n) != None):
        return memo[n]
    else:
        if(n <= 0): return 0
        if(n%10 == n and n > 0):
            memo[n] = 1
            ret = 1
        else:
            def solve(n,i):
                if(i != '0'):
                    return dp(int(n) - int(i))
                else:
                    return float('inf')
            ret = min([solve(n,i) for i in set(str(n))]) + 1
            memo[n] = ret
        return memo[n]
N = int(input())
print(dp(N))
            
        