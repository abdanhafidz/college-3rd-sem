HH, MM, SS = map(int, input().split(":"))
CH, CM, CS = map(int, input().split(":"))
HH -= 2
CH -= 7
diffH, diffM, diffS= abs(HH - CH), abs(MM - CM), abs(SS - CS)
if(diffH < 10):
    diffH= f"0{diffH}"
if(diffM < 10):
    diffM= f"0{diffM}"
if(diffS < 10):
    diffS= f"0{diffS}"
if(CH > HH or ( CH == HH and CM > MM) or (CH == HH and CM == MM and CS > MM)  ):
    print("See you on the next Pear Event!")
else:
    print(f"{diffH}:{diffM}:{diffS}")
