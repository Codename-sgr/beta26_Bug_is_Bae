# Generated by Django 3.1.2 on 2020-10-31 10:01

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('location', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='location',
            name='group',
            field=models.CharField(default='a', max_length=5),
        ),
    ]
