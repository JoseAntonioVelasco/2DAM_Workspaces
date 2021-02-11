#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: JoseAntonioVelasco
"""
import csv
import random
# Ejercicio 1
# Código para los alumnos

listaNombres = ["Miguel","Marta","Isabel","Isaac","Pedro","Paula","Jose","Juan",
              "Alba","Alicia","Pablo","Lourdes","David","Hugo","Sara","Miriam"]

listaApellidos = ["Santos","Rojo","Ruiz","Cordero","Rivera","Zamora","Iglesias",
                  "Abascal","Casado","Contador","Teruel","Pinar","Posada"]
ciclos = ["DAM", "EDI", "PRO", "MED"]

cursos = [1,2]


#Clase para almacenar los datos de los alumnos
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
        
#funcion que genera datos aleatorios en los alumnos  
def genAlumno():
    index_nom = random.randint(0,len(listaNombres)-1)
    index_ape1 = random.randint(0,len(listaApellidos)-1)
    index_ape2 = random.randint(0,len(listaApellidos)-1)
    nota1 = random.randint(0,10) 
    nota2 = random.randint(0,10) 
    nota3 = random.randint(0,10) 
    nota4 = random.randint(0,10) 
    nota5 = random.randint(0,10) 
    nombre = listaNombres[index_nom]
    ape1 = listaApellidos[index_ape1]
    ape2 = listaApellidos[index_ape2]
    
    alumno = Alumno(0,0,nombre,ape1,ape2,nota1,nota2,nota3,nota4,nota5)
    return alumno

alumnos = []

#genero los alumnos y los meto en la lista alumnos
for ciclo in ciclos:
    for curso in cursos:
        num_alumnos = random.randint(15,20)
        for num in range(num_alumnos):
            alumno = genAlumno()
            alumno.ciclo = ciclo
            alumno.curso = curso
            alumnos.append(alumno)

#abro el csv para escribir en el
with open("ficheroSalidaEjercicio1.csv","w",newline='') as file:
    csv_writer = csv.writer(file,delimiter = ';')
    #la primera linea la cabecera
    csv_writer.writerow(["ciclo","curso","nombre","apellido1","apellido2","nota1","nota2","nota3","nota4","nota5"])
    for alumno in alumnos:
        #despues los datos de los alumnos
        csv_writer.writerow([alumno.ciclo,alumno.curso,alumno.nombre,alumno.ape1,alumno.ape2,alumno.nota1,alumno.nota2,alumno.nota3,alumno.nota4,alumno.nota5])
        