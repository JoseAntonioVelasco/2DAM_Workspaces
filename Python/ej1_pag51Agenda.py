# -*- coding: utf-8 -*-
"""
Created on Mon Dec 14 08:34:04 2020

@author: JoseAntonioVelasco
"""


def obtenerCredenciales():
    file1  = open("usuariosAgenda.txt", "r")
    Lines = file1.readlines() 
  
    for line in Lines: 
        line=line.rstrip("\n")
        usu_pass=line.split(":")
        credentials[usu_pass[0]]=usu_pass[1]
    return credentials 

def comprobarCredenciales(credentials,name,passw):
    if name in credentials and credentials.get(name)==passw:
        return True
    else:
        return False
    
credentials = {}
credentials = obtenerCredenciales()

name = input("Introduce nombre: ")
passw = input("Introduce contraseña: ")

while comprobarCredenciales(credentials,name,passw)==False:
    print("Datos incorrectos")
    name = input("Introduce nombre: ")
    passw = input("Introduce contraseña: ")
else:
    print("Has entrado")
    print("1.Consultar agenda")
    print("2.Editar contacto")
    print("3.Insertar contacto")
    print("4.Borrar contacto")
    print("5.Salir")
    opcion = int(input("Introduce opcion: "))
    

