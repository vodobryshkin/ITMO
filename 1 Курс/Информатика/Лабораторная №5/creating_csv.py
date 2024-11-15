import re

file1 = open("SPFB.RTS-12.18_180901_181231.csv", mode='r').readlines()
curr = 21
data = []
for m in ['09', '10', '11', '12']:
    s = 0
    while s == 0:
        for line in file1[1:]:
            if re.match(rf'{curr}/{m}/\d\d', line.split(',')[2]):
                p = line.split(',')
                np = [p[2]]
                for i in range(4, 8):
                    np.append(str(int(float(p[i]))))
                line = ",".join(np) + '\n'
                data.append(line)
                s += 1
        if s == 0:
            curr += 2
        if curr > 28:
            curr -= 27
    curr = 21

with open("my_day2.csv", mode='w') as file2:
    file2.write('<DATE>,<OPEN>,<HIGH>,<LOW>,<CLOSE>\n')
    file2.write("".join(data))
