M,N,T = map(int, input().split())
remTime = (T % 85)
if(remTime > 25):
    remGreen = remTime - 25
else:
    remGreen = 0
carsOut = ( (T // 85) * 12 + remGreen // 5)
rem = (M + N + 1) - carsOut
if(carsOut >= M + 1):
    print(f"YES! {rem}")
else:
    print(f"NO! {rem}")