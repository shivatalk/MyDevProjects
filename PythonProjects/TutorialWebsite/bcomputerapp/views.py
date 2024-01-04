from django.shortcuts import render
from bcomputerapp.models import Basic_computer_data


# Create your views here.


def basiccomputer(request, mid):
    text = Basic_computer_data.objects.filter(id=mid)
    if (mid == 1):
        return render(request, 'bcomputerapp/bcomputerpage1.html', {'text': text})
    elif (mid == 2):
        return render(request, 'bcomputerapp/bcomputerpage2.html', {'text': text})
    else:
        return render(request, 'microapp/invalid_micro.html', {'text': text})
