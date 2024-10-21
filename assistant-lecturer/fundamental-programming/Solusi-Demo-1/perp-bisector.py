x1,y1 = map(float,input("Masukkan koordinat pertama x1 y1 dipisahkan oleh spasi => ").split())
x2,y2 = map(float,input("Masukkan koordinat kedua x2 y2 dipisahkan oleh spasi => ").split())
if(x1 == x2 or y1 == y2):
    print("Invalid Input")
else: 
    m1 = (y2 - y1) / (x2 - x1)
    m2 = float(-1/m1)
    c = float((y1 + y2)/2 - (m2 * (x1 + x2)/2))
    m2 = "{:.2f}".format(m2)
    c = "{:.2f}".format(c)
    print(f"Perp Bisector y = {m2}x + {c}")