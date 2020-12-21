# -*- coding: utf-8 -*-
"""
Created on Mon Dec 21 08:19:36 2020

@author: JoseAntonioVelasco
"""
def mostrarMediaMuertosPordia():
    fecha=['2020-03-31','2020-04-30','2020-05-31','2020-06-30','2020-07-31','2020-08-31','2020-09-30','2020-10-31','2020-11-30','2020-12-08']
    dias=[31,30,31,30,31,31,30,31,30,8]
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
        #calcular media
        for i in range(len(dif_y)):
            dif_y[i] = dif_y[i]/dias[i]
        plt.plot(x,dif_y,label=provincia) 
    
    plt.xlabel('Meses')
    plt.ylabel('Fallecidos')
    plt.title("Media de muertos por dia por provincia")
    
    plt.legend()
    plt.show()

