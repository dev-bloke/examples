# Strings are tuples of characters.

string1 = "Hello"
print(string1[2])
for char in string1:
    print(char)
print(string1[2:4])
print(string1[:-1])
print(len(string1))

# Concatenation

string2 = "Hello " + "world"
print(string2)
string3 = "Hello " * 4
print(string3)

# Joining, splitting and stripping

space = " "
string4 = space.join(["A", "list", "of", "words"])
print(string4)
first_list = string2.split(" ")
print(first_list)
string5 ="   Hello World    "
string6 = string5.strip()
print(string6)
string7 = string5.strip(" Hd")
print(string7)

# Searching, counting and replacing

string8 = "Martin Ingram"
index1 = string8.find("in")
print(index1)
index2 = string8.rfind("a")
print(index2)
count = string8.count("r")
print(count)
string9 = string8.replace("r", "x")
print(string9)
string10 = "mr flibble"
string11 = string10.title()
print(string11)

# Useful checks

string12 = "123"
print(string12.isdigit())
print(string12.isalpha())
string13 = "MRI"
print(string13.isupper())
print(string13.islower())

# Conversion

num1 = int("1234") + 1
print(num1)
num2 = float("123.456") + 1
print(num2)
second_list = [1, 2, 3, 4]
string14 = repr(second_list)
print(string14)
print(len(string14))
string15 = repr(len)
print(string15)
