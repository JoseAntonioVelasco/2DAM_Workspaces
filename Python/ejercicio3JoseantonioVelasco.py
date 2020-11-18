# -*- coding: utf-8 -*-
"""
Created on Wed Nov 18 09:17:10 2020

@author: ADMIN
"""
lista = []
secreta = "secreta"
for i in range(len(secreta)):
    lista.append("_")
print("La palabra que debes adivinar tiene ",len(secreta))


caracter = input("Introduce una letra: ")

aux = "".join(lista)

contadorRestantes = len(secreta)
while aux != secreta:
    for j in range(len(secreta)):
        if caracter == secreta[j]:
            lista[j] = caracter
            contadorRestantes = contadorRestantes - 1
    aux = "".join(lista)
    if aux == secreta:
        break
    print(lista)
    print("Te quedan por adivinar ",contadorRestantes," letras")
    caracter = input ("Introduce una letra: ")
print("¡¡¡enhorabuena, has ganado!!!")
print("La palabra secreta era: '",secreta,"'")
