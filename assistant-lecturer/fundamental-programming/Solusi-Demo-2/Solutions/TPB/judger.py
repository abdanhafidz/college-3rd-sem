import math
def GenerateInput():
    f = open("ans.in", "w")
    for i in range(1,1001):
        f.write(f"{i}\n")
def GenerateOutput():
    f = open("ans.out", "w")
    for N in range(1,1001):
        status = True
        for i in range(2,math.floor(math.sqrt(N)) + 1):
            if(N%i == 0):
                status = False
                break
        if(status):
            f.write("IT IS A PRIME\n")
        else:
            f.write("IT IS NOT A PRIME\n")
def Solution():
    # Enter your program Here ...
def Check():
    for _ in range(1000):
        Solution()
Check()
