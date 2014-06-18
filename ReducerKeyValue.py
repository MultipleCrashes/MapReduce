import sys 

# Take the output of the mapper as input for the reducer.
# python ReducerKeyValue.py < mapperOutput


previous_key=None
total=0

def output(previous_key,total):
    if previous_key!=None:
        print previous_key+"was found"+str(total)+"times"



for line in sys.stdin:
    key,value =line.split("\t",1)
    # to keep track of changing word
    if key!=previous_key:
        output(previous_key,total)
        previous_key=key 
        total=0
    total +=int(value)
   

output(previous_key,total)
