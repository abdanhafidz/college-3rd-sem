import requests
import pandas as pd
from bs4 import BeautifulSoup

class Worker:
    def __init__(self, url):
        self.url = url
    def scrap(self, parameters = {})->BeautifulSoup:
        print(self.url)
        response = requests.get(self.url)
        if response.status_code == 200:
            print(response.status_code, "Succeed to scrap data")
            html = response.content
            soup = BeautifulSoup(html, 'html.parser')
            return soup
        else:
            print(response.status_code, "Failed to scrap data")
    def soup(self, data):
        soup = BeautifulSoup(data, 'html.parser')
        return soup




