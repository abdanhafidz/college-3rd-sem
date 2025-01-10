
def IDCard(nama:str,umur:int,hobi:str):
    print("=== ID CARD === ")
    print(f"Nama :{nama}")
    print(f"Umur :{int(umur)}")
    print(f"Hobi :{hobi}")

try:
    IDCard("Abdan","Jeruk","Tidur")
except:
    print("Error")
