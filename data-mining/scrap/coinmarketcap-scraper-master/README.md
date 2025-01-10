coinmarketcap-scraper
===================

Python-based scraper for market cap, supply, exchange price, and exchange volume data from coinmarketcap.com

Installation
=============

Make sure required python packages are installed

```
pip install cssselect lxml psycopg2 requests
```

Usage
=====

Simply run `$ python scrape.py` to scrape all currencies on coinmarketcap.

Since the list grows longer everyday, the number of scraped currencies can be limited by specifying a minimum market cap, e.g.: `$ python scrape.py 1000 000`.
