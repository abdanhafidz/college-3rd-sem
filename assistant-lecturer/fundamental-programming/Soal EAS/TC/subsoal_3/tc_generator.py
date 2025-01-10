import random
# Testcases will be 1 <= a , b <= 10^23
fIn = None
fOut = None
#TestCase 0 (Sample):

import sys 
sys.setrecursionlimit(10 ** 9)
MOD = 10**9 + 7
def permutasi(memo:dict, n, r):
    if(memo.get((n,r)) != None):return memo[(n,r)]
    else:
        if(n == n - r or n == 1):return 1
        else:
            memo[(n,r)] = int((n%MOD * permutasi(memo, n - 1, r - 1)%MOD)%MOD)
            return memo[(n,r)]
for m in range(0,1):
    for rT in range(0,6):
        T = random.randrange(10**rT,10**(rT+1) - 1)
        for i in range(0,4):
            if(m<10):
                s = f"20{m}{rT}{i}"
            else:
                s = f"2{m}{rT}{i}"
            fIn = open(f"input/input{s}.txt", "a")
            fOut = open(f"output/output{s}.txt", "a")
            fIn.write(f"{T}\n")
            memo = dict()
            for _ in range(T):
                N = random.randrange(10**i,10**(i+1) - 1)
                r = random.randrange(1,N+1)
                res = permutasi(memo, N, r)
                fIn.write(f"{N} {r}\n")
                fOut.write(f"{res}\n")
        fIn.close()
        fOut.close()

