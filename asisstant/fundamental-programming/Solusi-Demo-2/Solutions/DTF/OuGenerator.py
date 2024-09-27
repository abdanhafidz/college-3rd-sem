
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
print(f"{diffH}:{diffM}:{diffS}")



def GenerateTestCase():
    f = open("ans.out", "w")
    for hh in range(0,24):
        if(int(hh) < 10):
            hh= f"0{hh}"
        for mm in range(0,60):
            if(int(mm) < 10):
                mm= f"0{mm}"
            for ss in range(0,60):
                if(int(ss) < 10):
                    ss= f"0{ss}"
                # print(f"{hh}:{mm}:{ss}")
                f.write(f"{hh}:{mm}:{ss} \n")

GenerateTestCase()