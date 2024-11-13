memo = dict()
gold = []
def f(i, j):
    if(memo.get((i,j)) != None): # Base case
        return memo[(i,j)]
    else:
        if i - 1 < 0 or j - 1 < 0:
            return 0  # Ubah `return False` ke 0 agar hasil komputasi tetap numerik.
        else:
            memo[(i, j)] = max(f(i - 1, j), f(i, j - 1)) + gold[i - 1 ][j - 1]
            return memo[(i, j)]

# Input
N,M,a,b,x,y = map(int,input().split())
for _ in range(N):
    gold.append(list(map(int,input().split())))
# Menampilkan hasil
print(f(x,y) - f(a,b) + gold[a - 1][b - 1])
# 
