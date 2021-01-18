# -*- coding: utf-8 -*-
"""
Created on Mon Jan 18 08:51:55 2021

@author: JoseAntonioVelasco
"""
    
import odooconexionbbdd as o

#Conectamos a la base de datos
o.connectToDB("172.16.0.57","odoo_db","postgres")


#hacemos una consulta en la oportunidad "Pruebas"
print("===PRIMERA CONSULTA====")
records = o.getSomeData("Pruebas")
for resultados in records:
    print(resultados)

#Editamos los datos de esa oportunidad
o.editSomeData("Pruebas","Pruebas2","difContac","asdgf@gmail.com")

#volvemos a hacer una consulta pero esta vez a "Pruebas2" para ver si se han
#editado los datos
print("===SEGUNDA CONSULTA====")
records = o.getSomeData("Pruebas2")
for resultados in records:
    print(resultados)

#borramos la oportunidad Pruebas2
o.deleteOportunity("Pruebas2")