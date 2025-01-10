def dp(n):
    print(n)
    if(n <= 0): return 0
    elif(n%10 == n and n > 0):
        return 1
    else:
        ret = float('inf')
        for i in str(n):
            if(int(i) != 0):
                ret = min(ret, dp(n - int(i)))
        ret += 1
        return ret

N = int(input())
print(dp(N))
            
        