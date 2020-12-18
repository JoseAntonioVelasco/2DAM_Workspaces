# -*- coding: utf-8 -*-
"""
Created on Thu Dec 17 09:36:46 2020

@author: JoseAntonioVelasco
"""
import csv
import matplotlib.pyplot as plt

def muertosPorMes():
    
    with open('covid.csv',newline='',encoding="utf8") as ficheroCSV:
        contenido = csv.reader(ficheroCSV,delimiter=';')
        listaMeses=["01","02","03","04","05","06","07","08","09","10","11","12"]
        
        itercontenido = iter(contenido)
        next(itercontenido)
        #datos[mes,muertos]
        datos = []
        for fila in contenido:
            dato = [fila[0],fila[5]]
            datos.append(dato)
        print(datos)
        #hacemos la diferencia de todos los dias
      
        
        
        
        
        muertosMes = []
        for mes in listaMeses:
            sumatorioMuertos = 0
            for dato in datos:
                if dato[0] == mes:
                    sumatorioMuertos = int(dato[1]) + sumatorioMuertos
            muertosMes.append(sumatorioMuertos)    
        
  
        muertosMesRestado = []
        for i in range(len(muertosMes)):
            if i==0:
                muertosMesRestado.append(muertosMes[i])
            else:
                muertosMesRestado.append(muertosMes[i] - muertosMes[i-1])
        
        plt.plot(listaMeses,muertosMesRestado)

def muertosPorProvincia():
    
    with open('covid.csv',newline='',encoding="utf8") as ficheroCSV:
        contenido = csv.reader(ficheroCSV,delimiter=';')
        listaMeses = ["01","02","03","04","05","06","07","08","09","10","11","12"]
        listaProvincias = ["Palencia","Soria","Zamora","Salamanca","León","Ávila","Burgos","Valladolid","Segovia"]
        
        itercontenido = iter(contenido)
        next(itercontenido)
        #datos[mes,provincia,muertos]
        datos = []
        for fila in contenido:
            fecha=fila[0].split("/")
            dato = [fecha[1],fila[1],fila[5]]
            datos.append(dato)
        
        
        muertosMesProvincia = []
        for provincia in listaProvincias:
            for mes in listaMeses:
                sumatorioMuertosProvincia = 0
                for dato in datos:
                    if dato[0] == mes and dato[1] == provincia:
                        sumatorioMuertosProvincia = int(dato[2]) + sumatorioMuertosProvincia
                muertosMesProvincia.append(sumatorioMuertosProvincia)
                
                muertosMesRestado = []
                for i in range(len(muertosMesProvincia)):
                    if i==0:
                        muertosMesRestado.append(muertosMesProvincia[i])
                    else:
                        muertosMesRestado.append(muertosMesProvincia[i] - muertosMesProvincia[i-1])
                        
            plt.plot(listaMeses,muertosMesRestado,label=provincia)
            muertosMesProvincia.clear()
        
        plt.ylabel("muertos")
        plt.xlabel("meses")
        plt.legend()
        

#muertosPorProvincia()
#muertosPorMes()

def muertosPorMes2():
    datos = []
    listaMeses=["01","02","03","04","05","06","07","08","09","10","11","12"]
    
    with open('covid.csv',newline='',encoding="utf8") as ficheroCSV:
        contenido = csv.DictReader(ficheroCSV,delimiter=';')
        itercontenido = iter(contenido)
        next(itercontenido)
        for elemento in contenido:
            fech = elemento["fecha"].split("/")
            dato = (fech[1],elemento["fallecimientos"])
            datos.append(dato)
        
        muertosMes = []
        for mes in listaMeses:
            sumatorioMuertos = 0
            for dato in datos:
                if dato[0] == mes:
                    sumatorioMuertos = int(dato[1]) + sumatorioMuertos
            muertosMes.append(sumatorioMuertos)   
        
        print(muertosMes)
        muertosMesRestado = []
        for i in range(len(muertosMes)):
            if i==0:
                muertosMesRestado.append(muertosMes[i])
            else:
                muertosMesRestado.append(muertosMes[i] - muertosMes[i-1])
        
        plt.plot(listaMeses,muertosMesRestado)
        
#muertosPorMes2()

def muertosPorProvincia2():
    listaMeses=["01","02","03","04","05","06","07","08","09","10","11","12"]
    listaProvincias = ["Palencia","Soria","Zamora","Salamanca","León","Ávila","Burgos","Valladolid","Segovia"]
    datos = []
    
    with open('covid.csv',newline='',encoding="utf8") as ficheroCSV:
        contenido = csv.DictReader(ficheroCSV,delimiter=';')
        itercontenido = iter(contenido)
        next(itercontenido)
        for elemento in contenido:
            dato = (elemento["fecha"],elemento["provincia"],elemento["fallecimientos"])
            datos.append(dato)

        for provincia in listaProvincias:
            x=[]
            y=[]
            
            for elemento in datos:
                if elemento[1] == provincia:
                    x.append((elemento[0])[5:7])
                    y.append(int(elemento[2]))
            print(y)
            x.reverse()
            y.reverse()
            print(y)
            datos2 = []
            for i in range(len(y)):
                if i == 0:
                    item = i
                    datos2.append(item)
                else:
                    item = y[i]-y[i-1]
                    datos2.append(item)
            print(datos2,provincia)
            plt.plot(listaMeses,datos2,label=provincia)
        
        plt.xlabel("Meses")
        plt.ylabel("Fallecidos")
        plt.legend()
        plt.show()

#muertosPorProvincia2()
muertosPorMes()
                
            
    

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               