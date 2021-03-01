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

map1 = {"key1": "value1", "key2": "value2"}
value1 = map1.get("key1")
print(value1)
