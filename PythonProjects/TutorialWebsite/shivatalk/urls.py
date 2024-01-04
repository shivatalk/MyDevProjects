"""shivatalk URL Configuration

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
from django.urls import path
from microapp import views
from django.urls import include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.home),
    path('about_us/', views.about),
    path('contact/feedback/', views.feedback),
    path('contact/', views.contact),
    path('services/', views.services),
    path('mp/', include('microapp.urls')),
    path('control/', include('controlapp.urls')),
    path('electronic_devices/', include('edcapp.urls')),
    path('basic_computer/', include('bcomputerapp.urls')),
    path('covid19/', include('covidapp.urls')),
]
