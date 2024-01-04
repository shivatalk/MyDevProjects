from .models import Electrician
from django import forms

class ElectricianForm(forms.ModelForm):
    class Meta:
        model=Electrician
        fields=('aadhar_num','fullname')