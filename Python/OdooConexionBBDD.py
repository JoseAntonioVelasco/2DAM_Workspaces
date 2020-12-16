# -*- coding: utf-8 -*-
"""
Created on Wed Dec 16 09:57:36 2020

@author: JoseAntonioVelasco
"""
import psycopg2

conn = psycopg2.connect("host=172.16.0.57 dbname=odoo_db user=postgres")

cur = conn.cursor()

cur.execute("SELECT * FROM crm_lead")

records = cur.fetchall()

for resultados in records:
    print(resultados)