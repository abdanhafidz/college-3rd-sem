import math
def GenerateInput():
    f = open("ans.in", "w")
    for i in range(-100000,100001):
        f.write(f"{i}\n")
def GenerateOutput():
    f = open("ans.out", "w")
    for number in range(-100000,100001):
        if "4" in str(number):
            f.write(f"SEVER\n")
        else:
            f.write(f"UNITE\n")
def Solution():
    number = input()
    ...
def Check():
    for _ in range(1000):
        Solution()
Check()
