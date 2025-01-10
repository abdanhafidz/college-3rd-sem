m,n = map(int,input().split())
if(m > n):
    side1 = m**2 - n**2
    side2 = 2 * m * n
    hyp = m**2 + n**2
    print(side1, side2, hyp)
else:
    print("Invalid m and n value")