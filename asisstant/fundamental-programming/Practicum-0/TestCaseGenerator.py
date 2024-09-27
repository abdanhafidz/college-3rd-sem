import random
# Testcases will be 1 <= a , b <= 10^23

#TestCase 0 (Sample):
a,b = 1,15
TcIn = []
TcOut = []
for i in range(0,4200):
    a,b = random.randrange(10**i,10**(i+1) - 1) , random.randrange(10**i,10**(i+1) - 1)
    if(i<10):
        s = f"0{i}"
    else:
        s = f"{i}"
    fIn = open(f"input/input{s}.txt", "a")
    fIn.write(f"{a} {b}\n")
    fIn.close()

    fOut = open(f"output/output{s}.txt", "a")
    fOut.write(f"{a+b}\n")
    fOut.close()

