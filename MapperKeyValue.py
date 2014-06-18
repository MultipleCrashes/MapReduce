import sys

# Run the mapper to produce output to a file with the command 
# python MapperKeyValue.py < shakes.txt | sort > mapperOutput

for line in sys.stdin:
    words = line.split( )   # getting word
    for word in words:
        print word+"\t"+str(1)

        
