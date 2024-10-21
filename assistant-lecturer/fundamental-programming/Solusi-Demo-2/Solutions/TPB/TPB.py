
N = int(input())
status = True
for i in range(2,N):
    if(N%i == 0):
        status = False
        break
if(status):
    print("IT IS A PRIME")
else:
    print("IT IS NOT A PRIME")
