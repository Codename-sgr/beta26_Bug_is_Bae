# Generated by Django 3.1.2 on 2020-10-31 09:11

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Location',
            fields=[
                ('id', models.IntegerField(primary_key=True, serialize=False)),
                ('x', models.FloatField()),
                ('y', models.FloatField()),
            ],
        ),
    ]
