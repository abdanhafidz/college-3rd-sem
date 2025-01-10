memo = dict()
MOD = 10**9 + 7
def permutasi(n, r):
    if(memo.get((n,r)) != None):return memo[(n,r)]
    else:
        if(n == n - r or n == 1):return 1
        else:
            memo[(n,r)] = (n%MOD * permutasi(n - 1, r - 1)%MOD)%MOD
            return memo[(n,r)]

T = int(input())
for _ in range(T):
    n,r = map(int, input().split())
    print(permutasi(n,r))