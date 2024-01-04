from django.db import models


# Create your models here.
class Textcontent(models.Model):
    msg1 = models.TextField(max_length=10000, blank=True, null=True)
    msg2 = models.TextField(max_length=10000, blank=True, null=True)
    msg3 = models.TextField(max_length=10000, blank=True, null=True)
    msg4 = models.TextField(max_length=10000, blank=True, null=True)

    def __str__(self):
        return str(self.id) + "___" + "Control_System"
