from django.urls import path
from bcomputerapp import views

urlpatterns = [
    path('bcomputer/<int:mid>', views.basiccomputer),

]
