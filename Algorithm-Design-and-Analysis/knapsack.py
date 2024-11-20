V = []
W = []
def dp(i,j):
    if(i <= 0 or j > size):
        return 0
    else:
        return max(V[j] + dp(i - W[j], j + 1), dp(i,j + 1))