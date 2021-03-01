string1 = "{0} is the {1} of our {2}".format("Now", "winter", "discontent")
print(string1)

string2 = "{item1}, {item2} and {item3}.".format(item1="Sunshine", item3="rainbows", item2="lollipops")
print(string2)

string3 = "{item[0]} in the {item[1]}".format(item=["Eye", "Sky"])
print(string3)

string4 = "%s have %i lives, or maybe %f." % ("Cats", 9, 9.61)
print(string4)

map1 = {"key1": "Dark", "key2": "Moon"}
string5 = "The {key1} Side of the {key2}".format(**map1)
print(string5)