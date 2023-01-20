reader = open("EnglishToArabicDictionary.txt", "r")

firstRow = True
English = None
dict = {}

for row in reader:
    if firstRow:
        row = row[1:]
        firstRow = False

    if English == None:
        English = row.strip().lower()

    else:
        dict[English] = row.strip()
        English = None

while True:
    desiredWord = input("enter a word, enter q to quit: ").lower()
    if desiredWord == "q":
        break
    try:
        print(dict[desiredWord])
    except KeyError:
        print("word not in ")

