from django.db import models

class Maindata(models.Model):
    aadhar_num=models.BigIntegerField(primary_key=True)
    rfid_num=models.BigIntegerField(default=0)
    fullname = models.CharField(max_length=50)

    f_name = models.CharField(max_length=50)
    dist=models.CharField(max_length=100,default='Jabalpur')
    tehseel=models.CharField(max_length=50)

    janpad=models.CharField(max_length=50)
    pincode = models.BigIntegerField()
    village = models.CharField(max_length=50)

    gram_panchayt = models.CharField(max_length=100)
    f_contact=models.BigIntegerField()
    s_contact=models.BigIntegerField()
    experience=models.PositiveSmallIntegerField()




    def __str__(self):
        return self.fullname

class Labour(models.Model):
    aadhar_num = models.BigIntegerField(primary_key=True)
    fullname = models.CharField(max_length=50)
    #rfid_num = models.BigIntegerField()

    def __str__(self):
        return self.fullname