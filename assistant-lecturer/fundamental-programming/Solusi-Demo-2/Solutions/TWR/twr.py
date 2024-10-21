arr = list(map(int, input().split()))
x = int(input())
y = int(input())
for _ in range(y):
    temp = arr[:7-x]
    arr[:7-x] = arr[-x:]
    arr[-x:] = temp
    # print(arr)
d, e, f = map(int,input().split())
print(arr[d], arr[e], arr[f])