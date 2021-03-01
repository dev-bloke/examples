num = 0
while num < 10:
    num += 1
    print(num)

my_list = ["a", "b", "c"]
for letter in my_list:
    print(letter)

for i in range(len(my_list)):
    print(my_list[i])

for i in range(2, len(my_list)):
    print(my_list[i])

for i in range(len(my_list) - 1, -1 , -1):
    print(my_list[i])

list_of_tuples = [(1, 2), (3, 4), (5, 6)]
for x, y in list_of_tuples:
    sum = x + y
    print(sum)

for i, value in enumerate(my_list):
    print("my_list[{0}] = {1}".format(i, value))
