from django import forms

from .models import Feedback


class Feedback_form(forms.ModelForm):
    name = forms.CharField(label='name', required=True, max_length=50)
    email = forms.EmailField(label='email', required=True, max_length=100)
    message = forms.CharField(label='message', required=True, max_length=500)

    class Meta:
        model = Feedback
        fields = ('name', 'email', 'message')
