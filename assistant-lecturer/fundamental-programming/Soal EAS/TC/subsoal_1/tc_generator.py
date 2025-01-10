import random
# Testcases will be 1 <= a , b <= 10^23
fIn = None
fOut = None
for m in range(0,1):
    for rT in range(0,6):
        T = random.randrange(10**rT,10**(rT+1) - 1)
        for i in range(0,4):
            if(m<10):
                s = f"0{m}{rT}{i}"
            else:
                s = f"{m}{rT}{i}"
            fIn = open(f"input/input{s}.txt", "a")
            fOut = open(f"output/output{s}.txt", "a")
            fIn.write(f"{T}\n")
            for _ in range(T):
                N,r = random.randrange(10**i,10**(i+1) - 1) , 1
                fIn.write(f"{N} {r}\n")
                fOut.write(f"{N}\n")

        fIn.close()
        fOut.close()

