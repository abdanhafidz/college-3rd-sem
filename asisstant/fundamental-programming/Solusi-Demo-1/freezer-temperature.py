hours, mins = map(int, input().split())
t = float(hours + mins/60)
T = float(((4 * t**2) / (t + 2)) - 20)
print("{:.2f}".format(T))