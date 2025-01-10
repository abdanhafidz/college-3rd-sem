
class MemberList:
    def __init__(self):
        self.data = []
    def AddData(self,
                name,
                nickname,
                birth,
                generation,
                jiggle,
                member_from,
                previous_group,
                sub_unit,
                fanbase_name,
                social_media):
        self.data.append({
            "Nama Lengkap" : name,
            "Nama Panggilan": nickname,
            "Kelahiran" : birth,
            "Generasi" : generation,
            "Salam Pembuka" : jiggle,
            "Member Sejak" : member_from,
            "Formasi Sebelumnya": previous_group,
            "Sub Unit" : sub_unit,
            "Nama Fanbase" : fanbase_name,
            "Media Sosial":social_media
        })
    def GetData(self):
        return self.data