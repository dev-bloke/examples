# Simple list and indexing

first_list = [1, 2, 3]
print(first_list[0])

# Working from the end of the list and appending.

second_list = [1, "b", 3, "Hello"]
print(second_list[3])
print(second_list[-2])
second_list[1] = "B"
second_list.append("world")
second_list.append(first_list)
print(second_list)

# Extending, inserting, deleting and removing

third_list = ["a", "b", "c"]
third_list.extend(first_list)
print(third_list)
third_list.insert(3, 4)
print(third_list)
third_list.insert(-1, 5)
print(third_list)
del third_list[3]
print(third_list)
third_list.remove("c")
print(third_list)

# Sorting, copying and reversing

fourth_list = ["Z", "A", "Q"]
fifth_list = fourth_list[:]
fifth_list.sort()
print(fourth_list)
print(fifth_list)

def compare_length(string1):
    return len(string1)

sixth_list = ["Parsons", "Alan", "The", "Project"]
sixth_list.sort(key=compare_length)
print(sixth_list)
seventh_list = sixth_list[:]
seventh_list.reverse()
print(seventh_list)

# Membership

if "Alan" in sixth_list:
    print("Alan is in the list.")
    print(sixth_list.index("Alan"))
if "Bob" not in sixth_list:
    print("Bob is not in the list.")

# Dictionaries (maps)

map = {"key1": "value1", "key2": "value2"}
value1 = map.get("key1")
print(value1)
map["key3"] = "value3"
del map["key2"]
eighth_list = map.keys()
print(eighth_list)
print("key3" in map)
print("key2" in map)
value2 = map.get("value2", "missing")
print(value2)

# Sets

ninth_list = [1, 2, 3, 1, 2, 4]
first_set = set(ninth_list)
print(first_set)
print(3 in first_set)

# Tuples

tenth_list = [1, 3, 5]
eleventh_list = ["one", "three", "five"]
tuple = zip(tenth_list, eleventh_list)
print(tuple)

# Comprehension

twelfth_list = [item * item for item in tenth_list]
print(twelfth_list)

second_map = {item: item * item for item in tenth_list}
print(second_map)

