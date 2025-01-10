MOD = 1e9 + 7
def faktorial(n):
    if(n == 1):return 1
    return (n%MOD * faktorial(n - 1)%MOD)%MOD
def permutasi(n, r):
    return ((faktorial(n)%MOD)//(faktorial(r)%MOD))%MOD

T = int(input())
for _ in range(T):
    n,r = map(int, input().split())
    print(permutasi(n,r))