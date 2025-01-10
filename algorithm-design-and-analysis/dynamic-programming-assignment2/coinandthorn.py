def Solve():
    N = int(input())
    inItem = input()
    item = []
    memo = dict()
    for r in inItem:
        if(r == '.'):
            item.append(0)
        if(r == "@"):
            item.append(1)
        if(r == '*'):
            item.append(-1)
    def dp(i):
        if(i > N or item[i - 1] == -1):
            return 0
        else:
            if(memo.get(i) != None):
                return memo[i]
            else:
                memo[i] = max(dp(i + 1),dp(i + 2)) + item[i - 1]
                return memo[i]
    print(dp(1))

T = int(input())
for _ in range(T):
    Solve()