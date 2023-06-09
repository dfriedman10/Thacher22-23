from bs4 import BeautifulSoup
import requests

choice = input("choose a wide receiver: ").strip()

url = "https://www.nfl.com/stats/player-stats/category/receiving/2022/reg/all/receivingreceptions/desc"

r = requests.get(url)
parser = BeautifulSoup(r.content, "html.parser")


table = parser.find("tbody")

rows = table.find_all("tr")

for r in rows:

    name = r.find("td").text.strip()

    if choice.lower() in name.lower():
        stats = r.find_all("td")[2].text
        print(name + "'s receiving yards: " + stats)





