#open the file
file = open('input.txt', 'r')

#read the file line by line
for line in file:
    #split the values based on space
    values = line.split()
    #store the values in a list
    data = []
    for value in values:
        data.append(value)
    print(data)

#close the file
file.close()