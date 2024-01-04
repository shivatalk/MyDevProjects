"""myminor URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path,include
from labour import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('',views.home),
    path('about/',views.about),
    path('services/',views.services),
    path('contact/',views.contact),
    path('register/',views.register),
    path('register/fillform/',views.ShowForm),
    path('labour/',include('labour.urls')),
    path('carpenter/',include('carpenter.urls')),
    path('plumber/',include('plumber.urls')),
    path('electrician/',include('electrician.urls')),
    path('agriculture/',include('agriculture.urls')),
    path('constructor/',include('constructor.urls'))
]
