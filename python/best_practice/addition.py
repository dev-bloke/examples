import logging


def add(first, second):
    logging.debug("Trying to add {} and {}".format(first, second))
    result = None
    if isinstance(first, str) and first.isdigit():
        logging.warning("First parameter {} is a numeric string.".format(first))
    if isinstance(second, str) and second.isdigit():
        logging.warning("Second parameter {} is a numeric string".format(second))
    try:
        result = float(first) + float(second)
        logging.info("Successful addition, result={}".format(result))
    except Exception as e:
        logging.error("Addition failed: {}".format(e))
    return result
