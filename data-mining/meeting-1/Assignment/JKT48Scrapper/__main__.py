from MemberScrapper import MemberScrap


if __name__ == "__main__":
    MemberJKT48Scrapper = MemberScrap()
    print("Scrapping Data ...")
    MemberJKT48Scrapper.Store()
    print("Saving To DB ...")
    MemberJKT48Scrapper.Show()
    print("Saving To DB Succeed ...")

