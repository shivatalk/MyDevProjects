from django.shortcuts import render
from microapp.models import Microdata


# Create your views here.
def home(request):
    return render(request, 'microapp/index.html')


def about(request):
    return render(request, 'microapp/about_us.html')


def contact(request):
    return render(request, 'microapp/contact_us.html')


def services(request):
    return render(request, 'microapp/services.html')


def micro(request, sid):
    text = Microdata.objects.filter(id=sid)
    if (sid == 1):
        return render(request, 'microapp/micro_page1.html', {'text': text})
    elif (sid == 2):
        return render(request, 'microapp/micro_page2.html', {'text': text})
    else:
        return render(request, 'microapp/invalid_micro.html', {'text': text})


from django.http import HttpResponseRedirect
from .forms import Feedback_form


def feedback(request):
    if request.method == 'POST':
        form = Feedback_form(request.POST)
        if form.is_valid():
            name = form.cleaned_data['name']
            email = form.cleaned_data['email']
            message = form.cleaned_data['message']
            print(name, email, message)
            r = form.save()
            return HttpResponseRedirect('/about_us')
    else:
        form = Feedback_form()
        print(request.POST.get('email'))
    return render(request, 'microapp/index.html', {'form': form})
