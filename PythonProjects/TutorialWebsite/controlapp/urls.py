from django.urls import path
from controlapp import views

urlpatterns = [
    path('data/<int:mid>/', views.controldata),

]
