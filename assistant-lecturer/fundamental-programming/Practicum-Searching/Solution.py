M, N = map(int,input().split())
concat = []
arr = ""
for _ in range(M):
    arr += input()
    arr +=" "

arr = list(map(int, input().split()))
sets = set(arr)
arr.sort()
# ans[n] = how many occurences that < n
# ans[5] = ans[4]
arr.reverse()
counts = dict()
counts[max(arr)] = len(arr) - 1
sets.remove(max(arr))

for x in sets:
    if(counts.get(x) == None):
        counts[x] = counts[] - 1

