from bs4 import BeautifulSoup
import requests

def searchTopic(topic):
    url = "https://en.wikipedia.org" + topic

    r = requests.get(url)
    parser = BeautifulSoup(r.content, "html.parser")

    section = parser.find("div", {"id": "bodyContent"})

    links = []

    for p in section.find_all("p"):

        for a in p.find_all("a"):

            if a["href"][:6] == "/wiki/":
                links.append(a)

    print("\n\nLinks:")
    for i in range(len(links)):
        print(str(i) + ": " + links[i].text)

    nextTopic = int(input("\nchoose a link number to follow: "))

    global numPages
    numPages += 1

    if goalTopic.lower() in links[nextTopic].text.lower():
        print("\n\nCongratulations! Number of links needed: " + str(numPages))

    else:
        searchTopic(links[nextTopic]["href"])



startingTopic = "/wiki/" + input("enter a starting topic: ")
goalTopic = input("enter a goal topic: ")
numPages = 0
searchTopic(startingTopic)