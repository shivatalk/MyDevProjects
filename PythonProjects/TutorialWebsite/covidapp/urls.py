from django.urls import path
from covidapp import views

urlpatterns = [
    path('', views.States),
    path('<int:sid>', views.SpecialState),

]
