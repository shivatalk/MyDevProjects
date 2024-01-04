from django.urls import path
from microapp import views

urlpatterns = [
    path('micro/<int:sid>', views.micro),

]
