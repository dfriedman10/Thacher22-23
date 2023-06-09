from bs4 import BeautifulSoup
import requests

url = "https://en.wikipedia.org/wiki/Boston"
r = requests.get(url)
parser = BeautifulSoup(r.content, 'html.parser')

mainSection = parser.find("div", {"id":"bodyContent"})

para = mainSection.find_all("p")[1]

print(para.text)
