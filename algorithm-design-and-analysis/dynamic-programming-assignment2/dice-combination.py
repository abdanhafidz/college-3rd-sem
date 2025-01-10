MOD = 10**9 + 7
N = int(input())
ret = [0 for _ in range(N+1)]
ret[0] = 1
ret[1] = 1
for x in range(2, N+1):
    for i in range(1,7):
        if(x - i >= 0):
            ret[x] += ret[x - i] % MOD
print(ret[N]%MOD)
