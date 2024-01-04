from django.shortcuts import render
from edcapp.models import Edcdata


# Create your views here.
def electronicdevices(request):
    text = Edcdata.objects.filter(id=1)
    return render(request, 'edcapp/edcpage1.html', {'text': text})


def electronic(request, mid):
    text = Edcdata.objects.filter(id=mid)
    if (mid == 1):
        return render(request, 'edcapp/edcpage1.html', {'text': text})
    elif (mid == 2):
        return render(request, 'edcapp/edcpage2.html', {'text': text})
    else:
        return render(request, 'microapp/invalid_micro.html', {'text': text})
