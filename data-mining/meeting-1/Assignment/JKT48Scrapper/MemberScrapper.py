from Worker import Worker
from Model import MemberList
from bs4 import BeautifulSoup
import pandas as pd
import json
class MemberScrap:
    def __init__(self):
        self.List = Worker("https://id.wikipedia.org/wiki/Daftar_anggota_JKT48")
        self.Scrap = self.List.scrap()
        self.MemberData = MemberList()

    def __Fetch(self):

        for data in self.Scrap.find_all('tbody')[1].find_all('tr')[1:]:
            clean_data  = [x.text.strip() for x in data.find_all('td')]
            self.MemberData.AddData(
                name=clean_data[0],
                nickname=clean_data[1],
                birth=clean_data[2],
                generation = clean_data[3],
                jiggle = clean_data[4],
                member_from = clean_data[5],
                previous_group =  clean_data[6],
                sub_unit = clean_data[7],
                fanbase_name = clean_data[8],
                social_media = clean_data[9]
            )
    def Store(self):
        self.__Fetch()
        out_file = open("data-member-jkt48.json", "w")
        json.dump(self.MemberData.GetData(), out_file, indent = 6)
        out_file.close()
    def Show(self):
        self.__Fetch()
        print(pd.DataFrame(self.MemberData.GetData()))

            
    
