# -- coding: utf-8 --
"""
Created on Thu Dec 17 20:32:12 2020

@author: JoseAntonioVelasco
"""



import matplotlib.pyplot as plt
import csv 
                  
def mostrarMuertosPorProvincia():
    fecha=['2020-03-31','2020-04-30','2020-05-31','2020-06-30','2020-07-31','2020-08-31','2020-09-30','2020-10-31','2020-11-30','2020-12-08']
    provincias =['Soria','Zamora','Valladolid','León','Palencia','Salamanca','Ávila','Segovia']                           
    datos = []
                     
    with open('covid.csv',newline="",encoding='utf-8') as ficheroCSV:
        c = csv.DictReader(ficheroCSV,delimiter=';') 
        for elemento in c:
            #selecciono solo el dato de fin de mes
            if elemento["fecha"] in fecha:  
                dato=(elemento["fecha"],elemento["provincia"],elemento["fallecimientos"])
                datos.append(dato)
                
    for provincia in provincias:
        x=[]
        y=[]
               
        for dato in datos:
            if dato[1] == provincia:
                x.append((dato[0])[5:7]) #num mes
                y.append(int(dato[2])) #muertos acumulados mes
        
        #hay que dar la vuelta a los datos para que tenga sentido la grafica
        x.reverse()
        y.reverse()
        
        #calcular diferencia    
        dif_y=[]    
        for i in range (len(y)):
          if i==0:
            dif_y.append(i)
          else:
            dif_y.append(y[i]-y[i-1])   
        plt.plot(x,dif_y,label=provincia) 
    
    plt.xlabel('Meses')
    plt.ylabel('Fallecidos')
    
    plt.legend()
    plt.show()

def mostrarMuertosTotalesPorProvincia():
    fecha=['2020-12-08']                       
    provincias = []
    fallecimientos = []
                     
    with open('covid.csv',newline="",encoding='utf-8') as ficheroCSV:
        c = csv.DictReader(ficheroCSV,delimiter=';') 
        for elemento in c:
            #selecciono solo el ultimo dato
            if elemento["fecha"] in fecha:  
                provincias.append(elemento["provincia"])
                fallecimientos.append(int(elemento["fallecimientos"]))
   
    top3=sorted(zip(fallecimientos, provincias), reverse=True)[:3]
    print(top3)
    for i in range(3):
        provincias.remove(top3[i][1])
        fallecimientos.remove(top3[i][0])
    
    for i in range(3):
        provincias.append(top3[i][1])
        fallecimientos.append(top3[i][0])
    
    plt.figure(figsize=(9, 7))
    barlist=plt.bar(provincias,fallecimientos)
    
    for i in range(6,9):
        barlist[i].set_color('r')
        
    plt.xlabel("Provincias")
    plt.ylabel("Fallecimientos")
    plt.show()
    
def mostrarPieChartMuertos():
    fecha=['2020-12-08']                       
    provincias = []
    fallecimientos = []
                     
    with open('covid.csv',newline="",encoding='utf-8') as ficheroCSV:
        c = csv.DictReader(ficheroCSV,delimiter=';') 
        for elemento in c:
            #selecciono solo el ultimo dato
            if elemento["fecha"] in fecha:  
                provincias.append(elemento["provincia"])
                fallecimientos.append(int(elemento["fallecimientos"]))
   
    
    plt.pie(fallecimientos,labels=provincias,autopct='%1.1f%%',shadow=True)       
    plt.title("Porcentaje fallecidos")
    plt.show()


#mostrarMuertosPorProvincia()
#mostrarMuertosTotalesPorProvincia()
mostrarPieChartMuertos()
