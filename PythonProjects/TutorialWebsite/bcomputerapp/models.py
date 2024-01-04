# Create your models here.
from django.db import models


class Basic_computer_data(models.Model):
    main_heading = models.CharField(max_length=50, blank=True, null=True)

    heading1 = models.CharField(max_length=50, blank=True, null=True)
    para1 = models.TextField(max_length=1000, blank=True, null=True)

    heading2 = models.CharField(max_length=50, blank=True, null=True)
    para2 = models.TextField(max_length=1000, blank=True, null=True)

    heading3 = models.CharField(max_length=50, blank=True, null=True)
    para3 = models.TextField(max_length=1000, blank=True, null=True)

    heading4 = models.CharField(max_length=50, blank=True, null=True)
    para4 = models.TextField(max_length=1000, blank=True, null=True)

    heading5 = models.CharField(max_length=50, blank=True, null=True)
    para5 = models.TextField(max_length=1000, blank=True, null=True)

    heading6 = models.CharField(max_length=50, blank=True, null=True)
    para6 = models.TextField(max_length=1000, blank=True, null=True)

    heading7 = models.CharField(max_length=50, blank=True, null=True)
    para7 = models.TextField(max_length=1000, blank=True, null=True)

    heading8 = models.CharField(max_length=50, blank=True, null=True)
    para8 = models.TextField(max_length=1000, blank=True, null=True)

    heading9 = models.CharField(max_length=50, blank=True, null=True)
    para9 = models.TextField(max_length=1000, blank=True, null=True)

    heading10 = models.CharField(max_length=50, blank=True, null=True)
    para10 = models.TextField(max_length=1000, blank=True, null=True)

    heading11 = models.CharField(max_length=50, blank=True, null=True)
    para11 = models.TextField(max_length=1000, blank=True, null=True)

    heading12 = models.CharField(max_length=50, blank=True, null=True)
    para12 = models.TextField(max_length=1000, blank=True, null=True)

    heading13 = models.CharField(max_length=50, blank=True, null=True)
    para13 = models.TextField(max_length=1000, blank=True, null=True)

    heading14 = models.CharField(max_length=50, blank=True, null=True)
    para14 = models.TextField(max_length=1000, blank=True, null=True)

    heading15 = models.CharField(max_length=50, blank=True, null=True)
    para15 = models.TextField(max_length=1000, blank=True, null=True)

    footer = models.CharField(max_length=100, blank=True, null=True)

    def __str__(self):
        return str(self.id) + "__" + str(self.footer) + "___" + "Basic Computer"
