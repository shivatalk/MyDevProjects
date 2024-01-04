from django.shortcuts import render
from controlapp.models import Textcontent


def controldata(request, mid):
    text = Textcontent.objects.filter(id=mid)
    if (mid == 1):
        return render(request, 'controlapp/control_page1.html', {'text': text})
    elif (mid == 2):
        return render(request, 'controlapp/control_page1.html', {'text': text})
    else:
        return render(request, 'microapp/invalid_micro.html', {'text': text})
