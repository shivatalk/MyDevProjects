from .models import Constructor
from django import forms

class ConstructorForm(forms.ModelForm):
    class Meta:
        model=Constructor
        fields=('aadhar_num','fullname')