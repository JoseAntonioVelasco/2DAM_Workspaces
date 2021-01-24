# -*- coding: utf-8 -*-
"""
Created on Sat Jan 23 18:59:32 2021

@author: JoseAntonioVelasco
"""
import csv
import random

listaCiudades = ["Valladolid","Granada","Burgos","Almeria","Barcelona","Soria","Palencia","Avila","Madrid","Zamora"]
listaSufijos = ["SAD","CD"]

class Equipo:
    def __init__(self,nombre=0,presupuesto=0,n_jugadores=0,pg=0,pe=0,pp=0,pf=0,pc=0):
        self.nombre = nombre
        self.presupuesto = presupuesto
        self.n_jugadores = n_jugadores
        self.pg = pg
        self.pe = pe
        self.pp = pp
        self.pf = pf
        self.pc = pc
    def playMatch(self,equipoOponente):
        #Win prob 49.5%
        #Lose prob 49.5%
        #Tie prob 1%
        partido = random.randint(0,100)
        if partido <= 49:
            self.pg = self.pg+1
            equipoOponente.pp = equipoOponente.pp+1
        elif partido >=51:
            equipoOponente.pg = equipoOponente.pg+1
            self.pp = self.pp+1
        else:
            self.pe = self.pe+1
            equipoOponente.pe = equipoOponente.pe+1
            
        self.pf = random.randint(60,110) + self.pf
        self.pc = random.randint(60,110) + self.pc
        equipoOponente.pf = random.randint(60,110) + equipoOponente.pf
        equipoOponente.pc = random.randint(60,110) + equipoOponente.pc

def nombreRepetido(listaEquipos,nombre):
    for i in range(len(listaEquipos)):
        if listaEquipos[i].nombre == nombre:
            return True
    return False

def genNombre():
    nombre = listaCiudades[random.randint(0,len(listaCiudades)-1)]+listaSufijos[random.randint(0,len(listaSufijos)-1)]
    if(nombreRepetido(listaEquipos,nombre)):
        nombre = genNombre()
        
    return nombre
    
def genData(equipo):
    nombre = genNombre()
    equipo.nombre = nombre
    equipo.presupuesto = random.randint(5*10**6,2*10**7)
    equipo.n_jugadores = random.randint(10,12)
    
    
#gen 20 equipos    
listaEquipos = []
for i in range(20):
    equipo = Equipo()
    genData(equipo)
    listaEquipos.append(equipo)

#los equipos juegan
for i in range(0,20,2):
    for j in range(38):
        listaEquipos[i].playMatch(listaEquipos[i+1])
    


with open('equipos.csv','w',newline='') as file:
    writer = csv.writer(file,delimiter=';')
    writer.writerow(["nombreCompletoEquipo", "presupuesto", "n_jugadores","PG","PE","PP","pf","pc"])
    for i in range(len(listaEquipos)):
        equipo = listaEquipos[i]
        #print([equipo.nombre,equipo.presupuesto,equipo.n_jugadores,equipo.pg,equipo.pe,equipo.pp,equipo.pf,equipo.pc])
        writer.writerow([equipo.nombre,equipo.presupuesto,equipo.n_jugadores,equipo.pg,equipo.pe,equipo.pp,equipo.pf,equipo.pc])
        
        
        