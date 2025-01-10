memo = {
    0:1,
    1:0,
    2:3,
    3:0
}
def dp(n):
    if(n<0):return 0
    # print(n)
    if(memo.get(n) != None):
        return memo[n]
    else:
        memo[n] = 4*dp(n - 2) - dp(n-4)
        return memo[n]

while(1):
    N = int(input())
    if(N == -1):
        break
    print(dp(N))
    
