# 1. Explicit is better than implicit (Keep it simple stupid).
#
# 2. Sparse is better than dense.
#
# 3. Errors should never pass silently (unless it's helpful to do so.)
#
# 4. Function arguments should be intuitive.
#
# 5. If an implementation is hard to explain, it's a bad idea.
#
# 6. We are all responsible users.
#    Prefix "private" variables and functions with an underscore.
#
# 7. Return values from one place. (Yes, yes, yes!!!)
#

import threading

# CONVENTIONS
#
# 1. Alternatives to checking for equality.

attr = True
if attr:
    print('attr is true.')
other_attr = None
if other_attr is None:
    print('attr is none.')

# 2. Accessing dictionary elements.

my_dict = {'hello': 'world', 'goodbye': 'cruel world'}
print(my_dict.get('missing', 'pieces'))
if 'hello' in my_dict:
    print(my_dict['hello'])

# 3. Manipulating lists.

my_list = [3, 4, 5]
filtered_list = [value for value in my_list if value > 3]
# or (I think this is less clear)
other_list = filter(lambda value: value > 3, my_list)

# 4. Enumerate

my_list = ["first", "second", "third", "fourth"]
for index, value in enumerate(my_list):
    print("{index}: {value}".format(index=index, value=value))

# 5. Unpacking

file = "wibble.txt"
file_name, extension = file.rsplit('.', 1)

# 6. Ignoring a value
basename, __, ext = file.rpartition('.')

# 7. Creating an n length list of the same thing.

four_nones = [None] * 4

# 8. Use "with" to avoid exception handling.

some_lock = threading.Lock()
with some_lock:
    print("Hello there!")

with open('my_file.txt', 'w') as output:
    output.write("Some text to go in the file.\n")


# GOTCHAS

# Python DEFAULT argument values are created ONCE when the function is first called.
# (This seems like a design flaw to me, and it certainly hinders clean code,
# but hey, PEP8 warns you...)
def append_to(element, to=[]):
    to.append(element)
    return to


my_list = append_to(10)
my_other_list = append_to(12)
print(my_other_list)

# Python closures are late binding. (See above)
# Internal values are looked up at CALL time. (FFS)


def create_multipliers():
    return [lambda x: i * x for i in range(5)]


for multiplier in create_multipliers():
    print(multiplier(2), end="... ")
print()


