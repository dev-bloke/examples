import logging

logging.basicConfig()


def decorated(func, *args, **kwargs):
    logger = logging.getLogger()

    def new_func(*args, **kwargs):
        logger.debug("calling {} with args {} and kwargs {}".format(
            func.__name__, args, kwargs))
        return func(*args, **kwargs)

    return new_func


@decorated
def my_func():
    print("Inside my_func.")

