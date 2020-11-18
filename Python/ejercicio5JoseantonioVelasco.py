# -*- coding: utf-8 -*-
"""
Created on Wed Nov 18 09:00:16 2020

@author: ADMIN
"""

#!/usr/bin/env python3
# -*- coding: utf-8 -*-
listaLetras = ['T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E']

class DNI:
    
    def __init__(self,numero,letra):
        self.numero = numero
        self.letra = letra

    def mostrarInformacion(self):
        print("El dni introducido es el siguiente: ",self.numero,"-",self.letra)
    
    def calcularLetra(self):
        resto = self.numero % 23
        letra = listaLetras[resto]
        return letra
        
    def comprobarValidez(self):
        if(self.letra==self.calcularLetra()):
            return True
        else:
            return False

numdni = int(input("Introduce el numero del DNI: "))
letra = input("Introduce la letra del DNI: ")

dni = DNI(numdni,letra)

print("--------RESULTADOS--------")
dni.mostrarInformacion()
print("El numero del DNI es: ",dni.numero)
print("La letra del DNI es: ",dni.letra)

if(dni.comprobarValidez()):
    print("El DNI introducido es correcto")
else:
    print("El DNI introducido NO es correcto. La letra correcta deberia ser la ",dni.calcularLetra())