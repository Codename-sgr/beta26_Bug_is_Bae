from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from rtree import index
import json

from .util import format
from .models import Location, People

idx_a = index.Index()
idx_ab = index.Index()
idx_b = index.Index()
idx_o = index.Index()
locations = Location.objects.all()
pkk = 100

'''for location in locations:
    blood_group = location.group
    x, y = location.x, location.y
    dx, dy = 0.00001, 0.00001
    if (blood_group == 'a'):
        idx_a.insert(id, (x-dx, y - dy, x + dx, y + dy))
    elif (blood_group == 'b'):
        idx_b.insert(id, (x-dx, y - dy, x + dx, y + dy))
    elif (blood_group == 'ab'):
        idx_ab.insert(id, (x-dx, y - dy, x + dx, y + dy))
    else:
        idx_o.insert(id, (x-dx, y - dy, x + dx, y + dy))'''

'''left, bottom, right, top = (0.0, 0.0, 1.0, 1.0)
idx_a.insert(1, (left, bottom, right, top))'''

def indexx(request, coOrdinate, blood_group):
    """
    API endpoint to return k nearest donor using r-tree in log(n+k)
    """
    k = 2
    dx, dy = 0.00001, 0.00001
    x, y = format( coOrdinate )
    if (blood_group == 'a'):
        res = list(idx_a.nearest((x-dx, y - dy, x + dx, y + dy), k))
        res += list(idx_o.nearest((x-dx, y - dy, x + dx, y + dy), k))
    elif (blood_group == 'b'):
        res = list(idx_b.nearest((x-dx, y - dy, x + dx, y + dy), k))
        res += list(idx_o.nearest((x-dx, y - dy, x + dx, y + dy), k))
    elif (blood_group == 'ab'):
        res = list(idx_ab.nearest((x-dx, y - dy, x + dx, y + dy), k))
        res += list(idx_b.nearest((x-dx, y - dy, x + dx, y + dy), k))
        res += list(idx_a.nearest((x-dx, y - dy, x + dx, y + dy), k))
        res += list(idx_o.nearest((x-dx, y - dy, x + dx, y + dy), k))
    else:
        res = list(idx_o.nearest((x-dx, y - dy, x + dx, y + dy), k))

    resp = []
    for i in res:
        resp.append(People.objects.get(pk = i).hash_id)

    return JsonResponse( {
        'status' : 200,
        'response' : res,
        } )


def add(request, coOrdinate, id, blood_group):
    """ API endpoint to add new donor of a paricular blood group to r-tree """
    global pkk
    dx, dy = 0.00001, 0.00001
    x, y = format( coOrdinate )
    p = People(num = pkk, hash_id = id)
    p.save()
    id = pkk
    pkk+=1
    if (blood_group == 'a'):
        idx_a.insert(id, (x-dx, y - dy, x + dx, y + dy))
    elif (blood_group == 'b'):
        idx_b.insert(id, (x-dx, y - dy, x + dx, y + dy))
    elif (blood_group == 'ab'):
        idx_ab.insert(id, (x-dx, y - dy, x + dx, y + dy))
    else:
        idx_o.insert(id, (x-dx, y - dy, x + dx, y + dy))

    res = {
        'status' : 201,
        'id' : id,
    }
    return JsonResponse( res )



