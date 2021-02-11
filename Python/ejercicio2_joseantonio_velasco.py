# -*- coding: utf-8 -*-
"""
Created on Thu Feb 11 09:07:18 2021

@author: JoseAntonioVelasco
"""
import csv
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
            row_number = row_number + 1
        else:
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

#muestro los datos por pantalla    
print("- - - INFORMACION SOBRE EL NUMERO DE ALUMNOS - - -")
print("Informacion del ciclo DAM: ")
print("\t Curso 1 -> {} alumnos".format(al_dam1))
print("\t Curso 2 -> {} alumnos".format(al_dam2))
print("Informacion del ciclo EDI: ")
print("\t Curso 1 -> {} alumnos".format(al_edi1))
print("\t Curso 2 -> {} alumnos".format(al_edi2))
print("Informacion del ciclo PRO: ")
print("\t Curso 1 -> {} alumnos".format(al_pro1))
print("\t Curso 2 -> {} alumnos".format(al_pro2))
print("Informacion del ciclo MED: ")
print("\t Curso 1 -> {} alumnos".format(al_med1))
print("\t Curso 2 -> {} alumnos".format(al_med2))
 

print("- - - INFORMACION SOBRE NOTAS MEDIAS - - -")
print("Informacion del ciclo DAM: ")
print("\t Curso 1({} alumnos) -> Nota media = {}".format(al_dam1,(sum_dam1/al_dam1)/5))
print("\t Curso 2({} alumnos) -> Nota media = {}".format(al_dam2,(sum_dam2/al_dam2)/5))
print("Informacion del ciclo EDI: ")
print("\t Curso 1({} alumnos) -> Nota media = {}".format(al_edi1,(sum_edi1/al_edi1)/5))
print("\t Curso 2({} alumnos) -> Nota media = {}".format(al_edi2,(sum_edi2/al_edi2)/5))
print("Informacion del ciclo PRO: ")
print("\t Curso 1({} alumnos) -> Nota media = {}".format(al_pro1,(sum_pro1/al_pro1)/5))
print("\t Curso 2({} alumnos) -> Nota media = {}".format(al_pro2,(sum_pro2/al_pro2)/5))
print("Informacion del ciclo MED: ")
print("\t Curso 1({} alumnos) -> Nota media = {}".format(al_med1,(sum_med1/al_med1)/5))
print("\t Curso 2({} alumnos) -> Nota media = {}".format(al_med2,(sum_med2/al_med2)/5))


print("- - - INFORMACION SOBRE ALUMNOS DE 2º QUE PUEDEN REALIZAR PROYECTO Y FCT - - -")
print("Informacion del ciclo DAM: ")
print("\t Curso 1 -> {} alumnos tienen todo aprobado.".format(ap_dam1))
print("\t Curso 2 -> {} alumnos tienen todo aprobado".format(ap_dam2))
print("Informacion del ciclo EDI: ")
print("\t Curso 1 -> {} alumnos tienen todo aprobado.".format(ap_edi1))
print("\t Curso 2 -> {} alumnos tienen todo aprobado".format(ap_edi2))
print("Informacion del ciclo PRO: ")
print("\t Curso 1 -> {} alumnos tienen todo aprobado.".format(ap_pro1))
print("\t Curso 2 -> {} alumnos tienen todo aprobado".format(ap_pro2))
print("Informacion del ciclo MED: ")
print("\t Curso 1 -> {} alumnos tienen todo aprobado.".format(ap_med1))
print("\t Curso 2 -> {} alumnos tienen todo aprobado".format(ap_med2))
