# Dikasih matriks berukuran N x M
# Baris = N, Kolom = M
N = int(input())
petak = []
for _ in range(N):
    masuk = list(map(int,input().split()))
    petak.append(masuk)
print(petak)

