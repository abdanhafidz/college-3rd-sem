
memo = dict()
def permutasi(n,r):
    if(memo.get((n,r)!= None)): return memo[(n,r)]
    else:
        temp_n = n
        res = n
        while(n != (temp_n - r)):
            res *= n - 1
            n -= 1
        memo[(n,r)] = res // (temp_n - r)
        return memo[(n,r)]

T = int(input())
for _ in range(T):
    n,r = map(int, input().split())
    print(permutasi(n,r))