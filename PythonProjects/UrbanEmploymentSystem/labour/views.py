from django.shortcuts import render
from .forms import MaindataForm,LabourForm
from .models import Maindata,Labour
from agriculture.models import Agriculture
from agriculture.forms import AgricultureForm
from carpenter.models import Carpenter
from carpenter.forms import CarpenterForm
from constructor.models import Constructor
from constructor.forms import ConstructorForm
from electrician.models import Electrician
from electrician.forms import ElectricianForm
from plumber.models import Plumber
from plumber.forms import PlumberForm
from django.db.models import Subquery
from django.http import HttpResponseRedirect
import pymysql

class DbConnect:

    def connect(self):
        mydb = pymysql.connect(
            host="localhost",
            user="root",
            passwd="root",
            database="minorproject"
        )
        return mydb


def home(request):
    return render(request, 'labour/home.html')

def about(request):
    return render(request, 'labour/about.html')

def services(request):
    return render(request, 'labour/services.html')

def contact(request):
    return render(request, 'labour/contact.html')

def register(request):
    return render(request, 'labour/registration.html')


def page1(request):
    mydb = DbConnect().connect()
    mycursor = mydb.cursor()
    sql = """select aadhar_num from labour_labour"""
    mycursor.execute(sql)
    record = mycursor.fetchall()
    li=[]
    main=[]

    for i in record:
        sql = """select * from labour_maindata where aadhar_num=%s"""
        mycursor.execute(sql, i)
        data= mycursor.fetchall()
        li.append(data)

    for i in range(len(li)):
        for j in range(len(li[0])):
            main.append(li[i][j])
            print(li[i][j])
    dict={'main':main}
    return render(request, 'labour/labour_list.html',{'dict':dict})


def ShowForm(request):

    if request.method=="POST":
        form=MaindataForm(request.POST)

        if form.is_valid():
            some_var = request.POST.getlist('checks[]')
            print(some_var)
            if 'Labour' in some_var:
                var=LabourForm(request.POST)
                var.save()
            if 'Agriculture Worker' in some_var:
                var = AgricultureForm(request.POST)
                var.save()
            if 'Carpenter' in some_var:
                var = CarpenterForm(request.POST)
                var.save()
            if 'Constructor' in some_var:
                var = ConstructorForm(request.POST)
                var.save()
            if 'Electrician' in some_var:
                var = ElectricianForm(request.POST)
                var.save()
            if 'Plumber' in some_var:
                var = PlumberForm(request.POST)
                var.save()

            form.save()
            return HttpResponseRedirect('/contact')
    else:
        form = MaindataForm()
        print(request.POST.get('fullname'))
    return render(request, 'labour/home.html', {'form': form})

