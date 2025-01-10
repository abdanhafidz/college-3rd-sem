memo = dict()
gold = []
def f(i, j): # f(i,j) = Berapa paling banyak emas kamu dapat dari (1,1) ke (i,j)
    # Bottom Up : f(i,j) = Kira - kira paling banyak aku gerak ke kanan (i, j + 1) atau ke bawah (i + 1, j)
    # Top Down : [Finish -> Start] = gerak ke kiri atau ke kiri (i, j - 1) ke atas (i - 1, j)
    # Bottom Up : f(i,j) = max(f(i + 1,j) , f(i, j +1)) + gold[i][j]
    # Top Down : f(i,j) = max(f(i - 1,j), f(i, j -1)) + gold[i][j]
    if(memo.get((i,j)) != None): # Base case
        return memo[(i,j)]
    else:
        if i - 1 < 0 or j - 1 < 0:
            return 0  # Ubah `return False` ke 0 agar hasil komputasi tetap numerik.
        else:
            return max(f(i - 1, j), f(i, j - 1)) + gold[i - 1 ][j - 1]
            
# Input
N,M,a,b,x,y = map(int,input().split())
for _ in range(N):
    gold.append(list(map(int,input().split())))
# Menampilkan hasil
print(f(x,y) - f(a,b) + gold[a - 1][b - 1])
# 
