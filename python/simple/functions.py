def power(x, y):
    result = 1
    while (y > 0):
        result = result * x
        y = y - 1
    return result

print(power(2, 3))
print(power(y=4, x=3))

# Default values

def repeat(word="Hello", times=3):
    while (times > 0):
        print(word)
        times = times - 1

repeat()
repeat("Mr Flibble")
repeat("Five times",5)
repeat(times=4)

# Indefinite number of parameters

def maximum(*numbers):
    if len(numbers) == 0:
        return None
    else:
        maximum = numbers[0]
        for number in numbers[1:]:
            if number > maximum:
                maximum = number
        return maximum

print(maximum())
print(maximum(3, 7, 6))

def say(first, second, **others):
    print("first={0},".format(first))
    print("second={0}".format(second))
    for key in others.keys():
        print("{0}={1}".format(key, others[key]))

say(first="One", second="Two", third="Three", fourth="Four")

# Using global variables

global_var = 10

def add_to_global(x):
    global global_var
    global_var = global_var + x

add_to_global(2)
print(global_var)
