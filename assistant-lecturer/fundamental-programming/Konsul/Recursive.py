

def usia(tahun):
    if(tahun == 2006):
        return 1
    else:
        return usia(tahun - 1) + 1

print(usia(2024))
# 1 2 3 4 5 6
# 
def position(move,start):
    if(move == "left"):
        return start - 1
    elif(move == "right"):
        return start + 1

    
# Fibonacci = 1,1,2,3,5,8, ... 
# F(n) = F(n - 2) + F(n - 3)
# F(2) = 1, F(3) = 1

memo = dict()
# memo = {
#   key : value
#   6 : 8
# }
def fibo(n):
    if(memo.get(6) != None):
        return memo[n]
    else:
        if(n == 1 or n == 2):
            return 1
        else:
            print(f"f({n}) = f({n - 1}) + f({n - 2})")
            memo[n] = fibo(n - 1) + fibo(n - 2)
            return memo[n]

print(fibo(100))