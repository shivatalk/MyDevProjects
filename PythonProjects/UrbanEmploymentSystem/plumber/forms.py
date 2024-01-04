from .models import Plumber
from django import forms

class PlumberForm(forms.ModelForm):
    class Meta:
        model=Plumber
        fields=('aadhar_num','fullname')