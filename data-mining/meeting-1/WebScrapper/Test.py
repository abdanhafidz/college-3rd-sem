from bs4 import BeautifulSoup
html = ''' 
<div class="parent">
    <div class="child">
    Data 11
    </div>
    <div class="child">
    Data 12
    </div>
    <div class="child">
    Data 13
    </div>
    <div class="child">
    Data 14
    </div>
</div>
<div class="parent">
    <div class="child">
    Data 21
    </div>
    <div class="child">
    Data 22
    </div>
    <div class="child">
    Data 23
    </div>
    <div class="child">
    Data 24
    </div>
</div>
'''
soup = BeautifulSoup(html, 'html.parser')

data_1 =  soup.find_all('div', class_= "parent")
for r in data_1:
    for child in r.find_all('div',class_="child"):
        print(child.text)
data_2 = soup.select('div',class_="parent")
# print(data_2)