from django.urls import path
from edcapp import views

urlpatterns = [
    # path('',views.electronicdevices),
    path('electronic/<int:mid>', views.electronic),

]
