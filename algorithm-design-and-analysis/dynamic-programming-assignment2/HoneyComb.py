memo = dict()
def dp(n):
    if(memo.get(n) != None):
        return memo[n]
    else:
        if(n == 1 or n == 2):
            return 1
        else:
            memo[n] = dp(n - 1) + dp(n - 2)
            return memo[n]
N = int(input())
print(dp(N))