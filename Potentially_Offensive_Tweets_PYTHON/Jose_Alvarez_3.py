""" Jose C Alvarez, Peoplesoft ID: 1587271
 Program #3: Detecting Trends and Foul Language in Twitter
 COSC 1306, Fall 2017
 This program compares different text files for foul language and returns tweets with
 potentially offensive language; and also returns hashtags and the number of times they were used in text file of tweets.
 This could be potentially useful for mass data storage and detecting certain keywords related to bullying, abuse, or other kinds of mistreat.
 Upon tweaking of this algorithm, it could also be relevant to mass data search for a simple search engine. """

x = open("swear_words.txt", encoding="latin-1") #Opens the file "swear_words.txt" with a fixed encoding

lines = [eachword for eachline in x for eachword in eachline.split()] #splits each line in the "swear_words.txt" file and adds it to a list

y = open('twitter_data.txt', encoding="latin-1") #Opens file "twitter_data.txt" with a fixed encoding

tweets = [a for line in y for a in line.splitlines()] #splits each line in the "twitter_data.txt" file and adds it to a list
matches=[] #create empty list
for e in lines:
    for i in tweets:
        if e in i:
            matches.append(i) #searches for mutual words found in "twitter_data.txt" (list called tweets) filtered by the words in
                              #"swear_words.txt" (in list called lines) and appends each value from a list to a new list called "matches"

output = open('potentially_offensive_tweets.txt', 'w', encoding='utf8') #create new file called "potentially_offensive_tweets.txt"
output.write('\n'.join(matches)) #to every new line into text file, add value from list "matches" containing potentially offensive tweets


hashtags=[] #create empty list
g=0
tostring = ''.join(tweets) #convert list "tweets" into one string separated by a blank space: ' '
for letter in tostring.split(): #read every value in "tostring" one by one by using split()
    if letter.startswith('#'):
        hashtags.append(letter) #if value starts with '#' append that value to the list "hashtags"
        g+=1
dict = {tags:hashtags.count(tags) for tags in hashtags} #counts the number of times each hastags is repeated and assings the tag
                                                        #to a dictionary as a key, and the # of times it appears in "hastags" as a value

def filter(myfile,dictionary):
    with open(myfile, 'w', encoding='utf8') as f:
        for key, value in dictionary.items():  #function writes each value from dictionary "dict" into a new file,
            f.write('%s: %s\n' % (key,value))  #key and value separeted by ": ",each entry separated by a new line
filter("top_hashtags.txt", dict) #calls funciton filter to print "dict" to a new file





