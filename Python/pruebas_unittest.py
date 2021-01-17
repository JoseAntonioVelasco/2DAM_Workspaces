# -*- coding: utf-8 -*-
"""
Created on Thu Jan 14 13:15:52 2021

@author: JoseAntonioVelasco
"""

def compruebaMayusculas(cadena):
    if cadena.isupper():
        return True
    return False

def compruebaMinusculas(cadena):
    if cadena.islower():
        return True
    return False

def tieneEspacios(cadena):
    if ' ' in cadena:
        return True
    return False

def cuentaLetras(cadena):
    return len(cadena)

def cuentaEspacios(cadena):
    espacios = 0
    for char in cadena:
        if char == ' ':
            espacios = espacios +1
    return espacios

#source "https://misfragmentosdecodigo.eu/palindromos-con-python/"
def esPalindromo(texto):
    igual, aux = 0, 0
    for ind in reversed(range(0, len(texto))):
      if texto[ind].lower() == texto[aux].lower():
        igual += 1
      aux += 1
    if len(texto) == igual:
      return True
    else:
      return False

def tieneLetra(palabra,letra):
    if letra in palabra:
        return True        

def invertirCadena(cadena):
    return cadena[::-1]

def alterarMayMin(cadena):
    cad_alter = ""
    for char in cadena:
        if char.isupper():
            cad_alter+=(char.lower())
        else:
            cad_alter+=(char.upper())
    return cad_alter

def eliminaCaracteres(cadena,caracter):
    cad_alter = ""
    for char in cadena:
        if char != caracter:
            cad_alter += char
        else:
            cad_alter +=""
    return cad_alter


        
#print(compruebaMayusculas("AASDASS"))
#print(compruebaMinusculas("asdasdads"))
#print(tieneEspacios("asdasd aasd"))
#print(cuentaLetras("asd "))
#print(cuentaEspacios("   asd  "))
#print(esPalindromo("abas"))
#print(tieneLetra("asd","a"))
#print(invertirCadena("hue"))
#print(alterarMayMin("HolaasdASAGSDFsdfs"))
#print(eliminaCaracteres("uahsda","a"))           