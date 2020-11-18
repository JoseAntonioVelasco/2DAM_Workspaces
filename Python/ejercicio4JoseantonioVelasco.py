# -*- coding: utf-8 -*-
"""
Created on Wed Nov 18 08:51:08 2020

@author: ADMIN
"""

def conversion(segundos):
    minutos=0
    horas=0
    dias=0
    while(segundos>=60):
        minutos = minutos + 1
        segundos = segundos - 60
    while(minutos>=60):
        horas = horas + 1
        minutos = minutos - 60
    while(horas>=24):
        dias = dias + 1
        horas = horas -24
    print("Han trascurrido ",dias," dias, ",horas," horas, ",minutos, " minutos, ",segundos, " segundos")
    
conversion(100000)