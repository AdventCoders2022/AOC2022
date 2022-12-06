
with open("day1\day6\input.txt", "r") as file:
    data = file.read()

print(len(data))
values = range(0,len(data)-3)
print(values)

PUZZLE1=4
PUZZLE2=14
NO_OF_CHARS=PUZZLE1

sum=0
for s in values:
    end=s+NO_OF_CHARS
    partData1=data[s: end]
    print(partData1)
    sum=0
    for j in range(NO_OF_CHARS):
        counter=partData1.count(partData1[j])
        # print(counter)
        sum+=counter
        # print(sum)
        
    if(sum==NO_OF_CHARS):
        break
print(partData1)  
print("Characters processed before start index ::", end)          

