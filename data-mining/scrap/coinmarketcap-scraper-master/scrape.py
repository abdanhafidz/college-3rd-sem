""" Core scraper for coinmarketcap.com. """
import argparse
import db
import logging
import coinmarketcap
import sys
import time
import traceback

# Parse min market cap argument
parser = argparse.ArgumentParser(description='Scrape data from coinmarketcap into local database.')
parser.add_argument('min_market_cap', metavar='min_cap', type=int, nargs='?', default=0,
                   help='minimum market cap [usd] for currency to be scraped (default: scrape all)')

args = parser.parse_args()

# Configuration
timestamp_0 = 1367174841000
timestamp_1 = int(round(time.time() * 1000))
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s %(levelname)s: %(message)s',
    datefmt='%m/%d/%Y %I:%M:%S %p')

# Database
database = db.Database()


def scrapeCoinList():
    """Scrape coin list."""
    html = coinmarketcap.requestList('coins', 'all')
    data = coinmarketcap.parseList(html, 'currencies')
    return data


def scrapeTokenList():
    """Scrape token list."""
    html = coinmarketcap.requestList('tokens', 'all')
    data = coinmarketcap.parseList(html, 'assets')
    return data


def scrapeMarketCap(slug, name, type):
    """Scrape market cap for the specified coin or token slug."""
    jsonDump = coinmarketcap.requestMarketCap(slug)
    result = coinmarketcap.parseMarketCap(jsonDump, slug)
    database.batch_entry(result, name, type)
    return result[-1]['market_cap_by_available_supply'] < args.min_market_cap


logging.info("Attempting to scrape token list...")
tokens = scrapeTokenList()
logging.info("Finished scraping token list. Starting on tokens...")
for token in tokens:
    logging.info("> Starting scrape of token {0}...".format(token['slug']))
    try:
        if scrapeMarketCap(token['slug'], token['name'], 'token'):
            logging.info("Minimum market cap reached. Stopped scraping tokens.")
            break
    except Exception as e:
        print('-'*60)
        print("Could not scrape token {0}.".format(token['slug']))
        print(traceback.format_exc())
        print('-'*60)
        logging.info(">> Could not scrape {0}. Skipping.".format(token['slug']))
        continue
logging.info("Attempting to scrape coin list...")
coins = scrapeCoinList()
logging.info("Finished scraping coin list. Starting on coins...")
for coin in coins:
    logging.info("> Starting scrape of coin {0}...".format(coin['slug']))
    try:
        if scrapeMarketCap(coin['slug'], coin['name'], 'coin'):
            logging.info("Minimum market cap reached. Stopped scraping coins.")
            break
    except Exception as e:
        print('-'*60)
        print("Could not scrape coin {0}.".format(coin['slug']))
        print(traceback.format_exc())
        print('-'*60)
        logging.info(">> Could not scrape {0}. Skipping.".format(coin['slug']))
        continue
logging.info("Finished scraping tokens and coins. All done.")
logging.info("Made {0} requests in total.".format(coinmarketcap.countRequested))
