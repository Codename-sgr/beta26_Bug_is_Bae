"""handling routes"""
from django.urls import path, re_path

from . import views

urlpatterns = [
    path('<str:coOrdinate>/<str:blood_group>', views.indexx, name='indexx'),
    path('add/<str:coOrdinate>/<int:id>/<str:blood_group>', views.add, name='add'),
]