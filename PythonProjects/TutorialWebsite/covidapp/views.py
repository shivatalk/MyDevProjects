from django.shortcuts import render
import requests
import json
url = "https://covid19india.p.rapidapi.com/getIndiaStateData"

headers = {
    'x-rapidapi-host': "covid19india.p.rapidapi.com",
    'x-rapidapi-key': "b2a44959a2msh6b3fd1d442a6b5ap1d9038jsn922c24b1a806"
    }
# Create your views here.



def States(request):
    response = requests.request("GET", url, headers=headers)
    jsondata = response.json()
    j_array = jsondata['response']
    stateNames=[]
    for state in j_array:
        stateNames.append(state['name'])
    return  render(request,'covidapp/basecovid.html', {'stateNames':j_array})


def SpecialState(request,sid):
    response = requests.request("GET", url, headers=headers)
    jsondata = response.json()
    j_array = jsondata['response']
    passed_array=j_array[sid-1]
    return render(request, 'covidapp/stateDetail.html', {'stateData':passed_array})
