# -*- coding: utf-8 -*-
"""
Created on Wed Dec 16 09:57:36 2020

@author: JoseAntonioVelasco
"""
import psycopg2


def connectToDB(host,dbname,user):
    global conn
    conn = psycopg2.connect("host={} dbname={} user={}".format(host,dbname,user))

def getSomeData(name):
    cur = conn.cursor()
    cur.execute("SELECT name, contact_name, email_normalized FROM crm_lead WHERE name='{}'".format(name))
    
    records = cur.fetchall()
    
    return records

def editSomeData(name,toName,contact_name,email_normalized):
    cur = conn.cursor()
    cur.execute("UPDATE {} SET name='{}',contact_name='{}',email_normalized='{}' WHERE name='{}'".format("crm_lead",toName,contact_name,email_normalized,name))
    conn.commit()

def deleteOportunity(name):
    cur = conn.cursor()
    cur.execute("DELETE FROM {} WHERE name='{}'".format("crm_lead",name))
    conn.commit()
    
    
    
    
    
    
    
connectToDB("172.16.0.57","odoo_db","postgres")

print("===PRIMERA CONSULTA====")
records = getSomeData("Pruebas")
for resultados in records:
    print(resultados)

editSomeData("Pruebas","Pruebas2","difContac","asdgf@gmail.com")

print("===SEGUNDA CONSULTA====")
records = getSomeData("Pruebas2")
for resultados in records:
    print(resultados)
    
deleteOportunity("Pruebas2")
