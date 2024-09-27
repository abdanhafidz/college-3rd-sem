N, C = map(int, input().split())

if(C == 1):
    if(N%3 == 0):
        print("Lili")
    else:
        print("Lala")
else:
    if(N%3 == 0):
        print("Lala")
    else:
        print("Lili")