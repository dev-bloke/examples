import unittest


def add_one(number):
    return number + 1


class TestAddOne(unittest.TestCase):
    """Test cases for add_one..."""

    def test_add_one_with_integer(self):
        """Test that add_one works with an integer"""
        self.assertEqual(add_one(3), 4)

    def test_add_one_fails_with_string(self):
        """Test that add_one fails predictably with a string"""
        self.assertRaises(TypeError, add_one, "wibble")

    def test_add_one_with_string(self):
        """This one is set up to fail!"""
        self.assertEqual(add_one("wibble"), "wobble")

