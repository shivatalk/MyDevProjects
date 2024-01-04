from .models import Carpenter
from django import forms

class CarpenterForm(forms.ModelForm):
    class Meta:
        model=Carpenter
        fields=('aadhar_num','fullname')