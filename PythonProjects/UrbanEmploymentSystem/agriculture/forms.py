from .models import Agriculture
from django import forms

class AgricultureForm(forms.ModelForm):
    class Meta:
        model=Agriculture
        fields=('aadhar_num','fullname')