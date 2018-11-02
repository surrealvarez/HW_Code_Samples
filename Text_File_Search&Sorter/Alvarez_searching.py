""""" Jose Alvarez COSC 1304 : peoplesoft: 1587271"""
#the purpose of this project is to improve sorting abilities and use of Dictionaries in python
def BuildDictionary(mydict, studentfile):
    with open(studentfile, encoding='utf8') as file:
        for line in file:
            (key, val) = line.split()
            mydict[str(key)] = float(val)
    return mydict
mydictionary = {}

builtdict = BuildDictionary(mydictionary, "studentfile.txt")

def FindStudentsinDictionary(mydict,mingpa,maxgpa):
    d =  {key: value for key, value in mydict.items() if value >= mingpa and value <= maxgpa}
    return d

def BuildLists(mylist, studentfile):
    with open(studentfile, encoding='utf8') as inputfile:
        for everyline in inputfile:
            mylist.append(everyline.strip().split())
    return mylist
results = []
builtlist = BuildLists(results, "studentfile.txt")

def SortListByName(mylist):
    from operator import itemgetter
    x = sorted(mylist, key=itemgetter(0))
    return x
print(SortListByName(builtlist))

def SortListByGPA(mylist):
    from operator import itemgetter
    x = sorted(mylist, key=itemgetter(1))
    return x
lst = [1,'', '4.1','str']
new = []
for x in lst:
    try:
        new.append((float(x)))
    except ValueError:
        new.append(x)
print(new)
def StudentsInListIterative(mylist,mingpa,maxgpa):
    y=0
    emptylist = []
    for i in mylist:
        try:
            i[1] = float(i[1])
        except ValueError:
            pass
        if i[1] >= mingpa and i[1] <= maxgpa:
            emptylist.append(i)
    return emptylist
print(StudentsInListIterative(builtlist,3.00,3.99))

def StudentsInListRecursive(mylist, mingpa, maxgpa):
    mylist=SortListByGPA(mylist)
    if mylist[0][1] < mingpa:
        mylist = mylist[1::]
    if mylist[-1][1]> maxgpa:
        mylist = mylist[::-1]
    if mylist[0][1] < mingpa or mylist [-1][1] > maxgpa:
        return(StudentsInListRecursive(mylist,mingpa,maxgpa))
    else:
        return len(mylist)



