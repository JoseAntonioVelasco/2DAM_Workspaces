# -*- coding: utf-8 -*-
"""
Created on Wed Dec 16 09:57:36 2020

@author: JoseAntonioVelasco
"""
import psycopg2


def connectToDB(host,dbname,user):
    """
    Conecta a la base de datos especificada

    Parameters
    ----------
    host : String
        host ip a la que queremos conectar.
    dbname : String
        nombre de la base de datos a la que queremos acceder.
    user : String
        nombre de usuario para entrar a la base de datos.

    Returns
    -------
    None.

    """
    global conn
    conn = psycopg2.connect("host={} dbname={} user={}".format(host,dbname,user))

def getSomeData(name):
    """
    Obtiene algo de informacion de una oportunidad

    Parameters
    ----------
    name : String
        nombre de la oportunidad de la que queremos sacar algo de informacion.

    Returns
    -------
    records : List
        retorna la informacion en una lista.

    """
    cur = conn.cursor()
    cur.execute("SELECT name, contact_name, email_normalized FROM crm_lead WHERE name='{}'".format(name))
    
    records = cur.fetchall()
    
    return records

def editSomeData(name,toName,contact_name,email_normalized):
    """
    Edita informacion de la oportunidad

    Parameters
    ----------
    name : String
        nombre de la oportunidad de la que queremos cambiar.
    toName : String
        cambia el nombre de la oportunidad a la que especifiques.
    contact_name : String
        cambia el nombre del contacto al que se especifique.
    email_normalized : String
        cambia el email al que se especifique.

    Returns
    -------
    None.

    """
    cur = conn.cursor()
    cur.execute("UPDATE {} SET name='{}',contact_name='{}',email_normalized='{}' WHERE name='{}'".format("crm_lead",toName,contact_name,email_normalized,name))
    conn.commit()

def deleteOportunity(name):
    """
    Borra una oportunidad

    Parameters
    ----------
    name : String
        nombre de la oportunidad que quieres borrar.

    Returns
    -------
    None.

    """
    cur = conn.cursor()
    cur.execute("DELETE FROM {} WHERE name='{}'".format("crm_lead",name))
    conn.commit()
    

