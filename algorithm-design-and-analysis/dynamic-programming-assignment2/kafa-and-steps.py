
def solve(arr):
    n = len(arr)
    dp = [1] * n
    for i in range(1, n):
        if arr[i] >= arr[i - 1]: 
            dp[i] = dp[i - 1] + 1
        else:
            dp[i] = 1

    return max(dp) 
n = int(input())
arr = list(map(int,input().split()))
print(solve(arr))
