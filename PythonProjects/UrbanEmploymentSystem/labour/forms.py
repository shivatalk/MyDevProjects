from .models import Maindata,Labour
from django import forms

class MaindataForm(forms.ModelForm):
    class Meta:
        model=Maindata
        fields=('aadhar_num','fullname','f_name','rfid_num','dist','pincode','tehseel','janpad','village','gram_panchayt','f_contact','s_contact','experience')


class LabourForm(forms.ModelForm):
    class Meta:
        model=Labour
        fields=('aadhar_num','fullname')