import sys

counts={}  # dictionary of words 

# As the size of dictionary increases the processing speed decreses
# Once we start using virtual memory 


# reading the file from std in 
for line in sys.stdin:
    words = line.split( )   # getting word
    for word in words:
        counts[word]=counts.get(word, 0)+1  # get value and add 1 to it


print counts
        
