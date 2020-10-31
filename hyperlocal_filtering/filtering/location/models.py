from django.db import models

# Create your models here.
class Location(models.Model):
    id = models.IntegerField(primary_key = True)
    x = models.FloatField()
    y = models.FloatField()
    group = models.CharField(max_length=5, default = 'a')


class People(models.Model):
    num = models.IntegerField(primary_key = True)
    hash_id = models.CharField(max_length = 100)
    

    
