from bs4 import BeautifulSoup
import requests

choice = input("choose an CA city: ")

url = "https://www.wunderground.com/forecast/us/ca/" + choice

r = requests.get(url)
soup = BeautifulSoup(r.content, "html.parser")


# Directly accesses the temperature from the top of the page
temp = soup.find("span", {"class":"wu-value wu-value-to"})

print("The temperature in " + choice + " is " + temp.text)



# Accesses the additional conditions section of the page
conditions = soup.find("div", {"class": "data-module additional-conditions"})

# fetches the row containing visibility information (the second row in the section)
visibilityRow = conditions.find_all("div", {"class": "row"})[1]

# gets the visibility data from it's row
vis = visibilityRow.find("div", {"class", "small-8 columns"})

print("Visibility is " + vis.text)




# Accesses the astronomy section of the page
astronomy = soup.find("div", {"class": "data-module city-astronomy"})

# fetches the sunrise/set information row
row = astronomy.find_all("div", {"class": "row collapse"})[1]

# fetches the sunrise time from the row
rise = row.find_all("div")[1]

# fetches the sunset time from the row
set = row.find_all("div")[2]

print("The sun will rise at " + rise.text + " and set at " + set.text)


