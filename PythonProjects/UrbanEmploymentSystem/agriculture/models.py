from django.db import models

# Create your models here.
class Agriculture(models.Model):
    aadhar_num = models.BigIntegerField(primary_key=True)
    fullname = models.CharField(max_length=50)
    #rfid_num = models.BigIntegerField(default=0)

    def __str__(self):
        return self.fullname