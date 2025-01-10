MOD = 10**9 + 7
memo = dict()
def faktorial(n):
    if(memo.get(n)!=None):return memo[n]
    else:
        if(n == 1):return 1
        memo[n] = (n%MOD * faktorial(n - 1)%MOD)%MOD
        return memo[n]
    
T = int(input())
for _ in range(T):
    n,r = map(int, input().split())
    print(faktorial(n))