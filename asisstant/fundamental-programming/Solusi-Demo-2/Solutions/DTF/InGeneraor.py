def GenerateTestCase():
    f = open("ans.in", "w")
    for hh in range(0,24):
        if(int(hh) < 10):
            hh= f"0{hh}"
        for mm in range(0,60):
            if(int(mm) < 10):
                mm= f"0{mm}"
            for ss in range(0,60):
                if(int(ss) < 10):
                    ss= f"0{ss}"
                for hh2 in range(0,24):
                    if(int(hh2) < 10):
                        hh2= f"0{hh2}"
                    for mm2 in range(0,60):
                        if(int(mm2) < 10):
                            mm2= f"0{mm2}"
                        for ss2 in range(0,60):
                            if(int(ss2) < 10):
                                ss2= f"0{ss2}"                
                # print(f"{hh}:{mm}:{ss}")
                f.write(f"{hh}:{mm}:{ss}\n{hh2}:{mm2}:{ss2}\n")

GenerateTestCase()