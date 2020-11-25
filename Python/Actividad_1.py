# -*- coding: utf-8 -*-
"""
Created on Mon Nov 23 09:02:17 2020

@author: ADMIN
"""

#ACTIVIDAD 1 Ficheros
#ESCRITURA EN FICHERO

listaLetras = ['T','t','r','R','w','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E']

texto = "Hola buenas tardes, que tal? hola\n hola"
f1 = open("fichero_A1.txt","w")
f1.write(texto)
f1.close()
#lectura del fichero
f1 = open("fichero_A1.txt","r")
contenidoLeido = f1.read()

print(contenidoLeido)

count  = len(open("fichero_A1.txt").readlines( ))

print("El numero de lineas es:",count)
palabras = len(contenidoLeido.split(" "))
print("El numero de palabras es: ",palabras)

caracteres = len(contenidoLeido)

print("El texto tiene",caracteres,"caractere")




