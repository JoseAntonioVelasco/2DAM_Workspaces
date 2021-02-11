#!/usr/bin/env python3
# -*- coding: utf-8 -*-


# Ejercicio 3
# Código para alumnos
"""
@author: JoseAntonioVelasco
"""

import matplotlib.pyplot as plt 
import csv

# Instrucciones de ayuda para generar gráficas

# plt.plot(x, y, label="")
# plt.bar(xS, yS, label = "", width = ..., color = ...)
# plt.xlabel()
# plt.ylabel()
# plt.title()
# plt.legend()
# plt.show()




# Instrucciones para alumnos que opten por realizar la versión simplificada.
# Las siguientes listas contienen los datos para generar las gráficas 
# sin tener que obtenerlos del fichero CSV

# Listas para la gráfica "a" del enunciado
listaNotasMediasPrimero = [7.493333333333333, 7.225, 6.3375, 6.43]
listaNotasMediasSegundo = [5.76, 6.175, 5.8133333333333335, 6.211111111111111]



# Listas para la gráfica "b" del enunciado
xS = ["M1", "M2","M3","M4","M5"] # --> ESTA LISTA SE PUEDE USAR SIEMPRE PARA QUE LA SALIDA SEA LA QUE SE PIDE
yS =  [4, 4, 1, 8, 8]




#PARTE A

#funcion que suma todas las notas del alumno
def sumNotasAl(al):
    suma = int(al.nota1)+int(al.nota2)+int(al.nota3)+int(al.nota4)+int(al.nota5)
    return suma
#funcion que devuelve true si todas las notas son mayores o igual a 5
def todoApro(al):
    if int(al.nota1) >= 5 and int(al.nota2) >= 5 and int(al.nota3) >= 5 and int(al.nota4) >= 5 and int(al.nota5) >= 5:
        return True
    else:
        return False
    
#clase alumno para almacenar datos
class Alumno:
    def __init__(self,ciclo,curso,nombre,ape1,ape2,nota1,nota2,nota3,nota4,nota5):
        self.ciclo = ciclo
        self.curso = curso
        self.nombre = nombre
        self.ape1 = ape1
        self.ape2 = ape2
        self.nota1 = nota1
        self.nota2 = nota2
        self.nota3 = nota3
        self.nota4 = nota4
        self.nota5 = nota5


alumnos = []
#abro el csv y leo de el
with open("informacionCiclosFormativos.csv","r") as file:
    csv_reader = csv.reader(file,delimiter = ';')
    row_number = 0
    for row in csv_reader:
        if(row_number == 0):
            #la primera linea es la cabecera asi que la salto
            row_number = row_number + 1
        else:
            #el resto son los datos de los alumnos asi que los leo y los guardo en la lista de alumnos
            alumno = Alumno(row[0],row[1],row[2],row[3],row[4],row[5],row[6],row[7],row[8],row[9])
            alumnos.append(alumno)

#variables que contienen el numero de alumnos
al_dam1 = 0
al_dam2 = 0
al_edi1 = 0
al_edi2 = 0
al_pro1 = 0
al_pro2 = 0
al_med1 = 0
al_med2 = 0
#variables que contiene el sumatario de las notas
sum_dam1 = 0
sum_dam2 = 0
sum_edi1 = 0
sum_edi2 = 0
sum_pro1 = 0
sum_pro2 = 0
sum_med1 = 0
sum_med2 = 0
#variables que contiene el sumatorio de aprobados
ap_dam1 = 0
ap_dam2 = 0
ap_edi1 = 0
ap_edi2 = 0
ap_pro1 = 0
ap_pro2 = 0
ap_med1 = 0
ap_med2 = 0

#recorro la lista de alumnos y obtengo los datos pedidos
for alumno in alumnos:
    if alumno.ciclo == "DAM" and alumno.curso == "1":
        al_dam1 = al_dam1 +1
        sum_dam1 = sum_dam1 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_dam1 = ap_dam1 + 1
    elif alumno.ciclo == "DAM" and alumno.curso == "2":
        al_dam2 = al_dam2 + 1
        sum_dam2 = sum_dam2 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_dam2 = ap_dam2 + 1
    elif alumno.ciclo == "EDI" and alumno.curso == "1":
        al_edi1 = al_edi1 + 1
        sum_edi1 = sum_edi1 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_edi1 = ap_edi1 + 1
    elif alumno.ciclo == "EDI" and alumno.curso == "2":
        al_edi2 = al_edi2 + 1
        sum_edi2 = sum_edi2 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_edi2 = ap_edi2 + 1
    elif alumno.ciclo == "PRO" and alumno.curso == "1":
        al_pro1 = al_pro1 + 1
        sum_pro1 = sum_pro1 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_pro1 = ap_pro1 + 1
    elif alumno.ciclo == "PRO" and alumno.curso == "2":
        al_pro2 = al_pro2 + 1
        sum_pro2 = sum_pro2 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_pro2 = ap_pro2 + 1
    elif alumno.ciclo == "MED" and alumno.curso == "1":
        al_med1 = al_med1 + 1
        sum_med1 = sum_med1 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_med1 = ap_med1 + 1
    elif alumno.ciclo == "MED" and alumno.curso == "2":
        al_med2 = al_med2 + 1
        sum_med2 = sum_med2 + sumNotasAl(alumno)
        if todoApro(alumno):
            ap_med2 = ap_med2 + 1


#listas que contienen los datos necesarios para las graficas
miListaNotasMediasPrimero = []
miListaNotasMediasSegundo = []


#se insertan los datos en las listas
miListaNotasMediasPrimero.append((sum_dam1/al_dam1)/5)
miListaNotasMediasPrimero.append((sum_edi1/al_edi1)/5)
miListaNotasMediasPrimero.append((sum_pro1/al_pro1)/5)
miListaNotasMediasPrimero.append((sum_med1/al_med1)/5)


miListaNotasMediasSegundo.append((sum_dam2/al_dam2)/5)
miListaNotasMediasSegundo.append((sum_edi2/al_edi2)/5)
miListaNotasMediasSegundo.append((sum_pro2/al_pro2)/5)
miListaNotasMediasSegundo.append((sum_med2/al_med2)/5)



#se muestran las graficas
plt.plot(["DAM","EDI","PRO","MED"],miListaNotasMediasPrimero,label = "Primer curso")
plt.plot(["DAM","EDI","PRO","MED"],miListaNotasMediasSegundo,label = "Segundo curso")
plt.legend()
plt.show()




#PARTE B

#variables que guardan los datos necesarios para la grafica
sus_mod1 = 0
sus_mod2 = 0
sus_mod3 = 0
sus_mod4 = 0
sus_mod5 = 0

miYs = []

#obtengo los suspensos por modulo en el ciclo dam curso 2 
for alumno in alumnos:
    if alumno.ciclo == "DAM" and alumno.curso == "2":
        if int(alumno.nota1) < 5:
            sus_mod1 = sus_mod1 +1
        if int(alumno.nota2) < 5:
            sus_mod2 = sus_mod2 +1
        if int(alumno.nota3) < 5:
            sus_mod3 = sus_mod3 +1
        if int(alumno.nota4) < 5:
            sus_mod4 = sus_mod4 +1
        if int(alumno.nota5) < 5:
            sus_mod5 = sus_mod5 +1

#los guardo en la lista
miYs.append(sus_mod1)
miYs.append(sus_mod2)
miYs.append(sus_mod3)
miYs.append(sus_mod4)
miYs.append(sus_mod5)


#ordeno la lista para obtener el maximo y el minimo
sorte = sorted(miYs)    
minVal = sorte[0]
maxVal = sorte[len(sorte)-1]


#en funcion del maximo y minimo pinto dinamicamente el grafico de barras
cont = 0
for y in miYs:
    if y == maxVal:
        plt.bar(xS[cont], y, label = "", width = 0.75, color = "tomato")
    elif y == minVal:
        plt.bar(xS[cont], y, label = "", width = 0.75, color = "yellowgreen")
    else:
        plt.bar(xS[cont], y, label = "", width = 0.75, color = "lightblue")
    cont = cont + 1

