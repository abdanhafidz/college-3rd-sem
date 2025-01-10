N = int(input())
B = list(map(int,input().split()))
hasil_xor = 1
for i in range(0,N):
    for j in range(i+1,N):
        hasil_xor *= B[i] ^ B[j]
print(hasil_xor)

