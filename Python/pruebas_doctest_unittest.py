# -*- coding: utf-8 -*-
"""
Created on Thu Jan 14 12:36:45 2021

@author: JoseAntonioVelasco
"""

def busquedaElemento(lista,elemento):
    if(lista[0]==elemento):
        return True
    else:
        return False
    
def sumarListas(lista1,lista2):
    return lista1+lista2

def ordenarLista(lista1):
    return lista1.sorted()

def invertirLista(lista1):
    return lista1.sort(reverse=True)

def acortarLista(lista1,n):
    lista = []
    for i in range(n):
        lista[i] = lista1[i]
    return lista
