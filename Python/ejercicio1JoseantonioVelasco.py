# -*- coding: utf-8 -*-
"""
Created on Wed Nov 18 08:19:28 2020

@author: ADMIN
"""

cadena = input("Introduce una cadena: ")
print("La cadena introducida es: ",cadena)
print("La cadena inversa generada es: ")
i=len(cadena)-1
j=0
cadenaInversa = ""
while(i in range(len(cadena))):
    cadenaInversa = cadenaInversa+cadena[i]
    i = i-1
    j = j+1
print(cadenaInversa)