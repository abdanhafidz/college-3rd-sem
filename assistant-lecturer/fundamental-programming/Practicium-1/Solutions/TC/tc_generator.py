import random
def GenerateInput():
    for k in range(0,5):
        f = open(f"secret_{k + 1}.in", "w")
        N = random.randrange(10**k, (10**(k+1)) - 1)
        B = [str(random.randrange(1, 6)) for _ in range(N)]
        if(len(B) > 1):
            B_arr = " ".join(B)
        else:
            B_arr = B
        f.write(f"{N}\n{B_arr}")
def GenerateOutputFromFile(filename,no):
    with open(filename, "r") as f:
        # Membaca N dari baris pertama
        N = int(f.readline().strip())
        
        # Membaca baris kedua dan memisahkan angkanya menjadi list B
        B = list(map(int, f.readline().split()))
        
        if N <= 5:
            hasil_xor = 1
            for i in range(0, N):
                for j in range(i + 1, N):
                    hasil_xor *= B[i] ^ B[j]
            g = open(f"secret_{no}.ans", "w")
            g.write(hasil_xor)

# Nama file-file input
filenames = ["secret_1.in", "secret_2.in", "secret_3.in", "secret_4.in", "secret_5.in"]

# Memproses setiap file
i = 1
for filename in filenames:
    GenerateOutputFromFile(filename,i)
    i+=1
# GenerateInput()