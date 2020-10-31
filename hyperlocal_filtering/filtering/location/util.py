
def format(coOrdinate):
    """ util function to get X and y cordinate from url """
    a, b = coOrdinate.split('&&')
    x = a.split('=')
    y = b.split('=')
    return float(x[1]), float(y[1])


