print("Hello World")
if hasattr(__builtins__, 'raw_input'):
	input = raw_input
name = input("What's your name? ")
print("Hello {0}".format(name))
