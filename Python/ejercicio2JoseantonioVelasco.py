#!/usr/bin/env python3
# -*- coding: utf-8 -*-

listaConsonantes = ['b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z']
listaVocales = ['a','e','i','o','u']

def esConsonante(letra):
    if letra in listaConsonantes:
        return True
    else:
        return False

def esVocal(letra):
    if letra in listaVocales:
        return True
    else:
        return False
    
def esEspacio(letra):
    if letra == " ":
        return True
    else:
        return False
        
cadena = input("Introduce una cadena para analizar: ")

posicionVocales = []
contadorVocales = 0
contadorConsonantes = 0
contadorEspacios = 0

for i in range(len(cadena)):
    if esEspacio(cadena[i]):
        contadorEspacios = contadorEspacios +1
    if(esVocal(cadena[i].lower())):
        contadorVocales = contadorVocales + 1
        posicionVocales.append(i)
    if(esConsonante(cadena[i])):
        contadorConsonantes = contadorConsonantes + 1
print("La cadena introducida tiene ",contadorVocales, " vocales" )
print("Esas vocales estan en las posiciones: ",posicionVocales)
print("Tiene tambien ",contadorConsonantes," consonantes escritas en letras minusculas")
print("Ademas, la cadena tiene ",contadorEspacios, "espacios")
        




#PAra transformar una letra en minúscula se utiliza el método lower()