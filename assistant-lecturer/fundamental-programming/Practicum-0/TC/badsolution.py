
import math

a,b = map(int, input().split())
c = math.gcd(a,b)
d = math.lcm(a,b)
print(math.floor( (c*d) // a + (c*d) // b))
