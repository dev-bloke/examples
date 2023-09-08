import addition
import logging
from logging import config

config.fileConfig("../../../../local/python/test/logging.conf")


sum1 = addition.add(10,20)
sum2 = addition.add("10", 20)
sum3 = addition.add(10, "20")
sum4 = addition.add("fish", "bicycle")
