# -*- coding: utf-8 -*-
"""
Created on Thu Dec 17 09:36:46 2020

@author: JoseAntonioVelasco
"""
import csv
import matplotlib.pyplot as plt


def sumarMuertos(mes):
    itercontenido = iter(contenido)
    next(itercontenido)
    
    sumatorio = 0
    for fila in contenido:
        fecha = fila[0].split("-")
        if fecha[1] == mes:
            sumatorio = sumatorio + int(fila[5])
    return sumatorio
        
with open('covid.csv',newline='',encoding="utf8") as ficheroCSV:
    listaMeses=['01','02','03','04','05','06','07','08','09','10','11','12']
    contenido = csv.reader(ficheroCSV,delimiter=';')
# =============================================================================
#     itercontenido = iter(contenido)
#     next(itercontenido)
#     for fila in contenido:
#         print(fila)
#         fecha=fila[0].split("-")
#         muertos=sumarMuertos(fecha[1])
#         print(muertos)
# =============================================================================
    for mes in listaMeses:
        muertos = sumarMuertos(mes)
        print(muertos)
    
#total de muertos por meses
# =============================================================================
# plt.ylabel("muertos")
# plt.xlabel("meses")
# 
# x=[]
# y=[]
# 
# plt.plot(x,y)
# =============================================================================


#def sumMuertosMes(numMes):
    
#total de muertos por provincias
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          