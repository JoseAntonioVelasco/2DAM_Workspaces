# -*- coding: utf-8 -*-
"""
Created on Mon Nov 23 10:03:19 2020

@author: ADMIN
"""

#actividad2


f1  = open("matriz2.txt","r")
f1.seek(0)
contenidoLeido = f1.read()
print("contenido leido: ")
print(contenidoLeido)


filas = contenidoLeido.split("\n")
f1.close()


matriz = []
for i in range(len(filas)):
    celdas = filas[i].split(" ")
    matriz.append(celdas)

print("lista bidimensional")
print(matriz)


print("leer lista bidimensional")
for row in matriz:
    for val in row:
        print(val,end='')
    print()


print("lineas: ",len(matriz))
print("cols: ",len(list(zip(*matriz))))


SimpleList = [el for sublist in matriz for el in sublist]
num=max( SimpleList, key= SimpleList.count)


print("elemento mas comun en la matriz: ",num)

