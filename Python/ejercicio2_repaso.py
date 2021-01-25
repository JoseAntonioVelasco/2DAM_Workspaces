# -*- coding: utf-8 -*-
"""
Created on Sun Jan 24 17:57:07 2021

@author: JoseAntonioVelasco
"""
import csv
import random

class Jugador:
    def __init__(self,nombre = 0,apellido1 = 0,apellido2 = 0, nombreCompletoEquipo = 0,
                 PJ = 0, PT = 0, puntos = 0, asis = 0, reb = 0, tap = 0, vN = []):
        self.nombre = nombre
        self.apellido1 = apellido1
        self.apellido2 = apellido2
        self.nombreCompletoEquipo = nombreCompletoEquipo
        self.PJ = PJ
        self.PT = PT
        self.puntos = puntos
        self.asis = asis
        self.reb = reb
        self.tap = tap
        self.vN = vN
    
class Equipo:
    def __init__(self,nombre=0,presupuesto=0,n_jugadores=0,pg=0,pe=0,pp=0,pf=0,pc=0,jugadores = []):
        self.nombre = nombre
        self.presupuesto = presupuesto
        self.n_jugadores = n_jugadores
        self.pg = pg
        self.pe = pe
        self.pp = pp
        self.pf = pf
        self.pc = pc
        self.jugadores = jugadores
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

listaNombres = ["Diego","Juan","Sancho","Pablo","Gonzalo","Merlin","Paula","Carla","Maria","Elisa","Marco","Miguel","Gustavo","Adolfo","Luis"]
listaApellidos = ["Velasco","Veganzones","Perez","Garcia","Mediavilla","Vaquerizo","Blanca","Rojo","Crespo","Diez","Diaz","Ojeda","Monje","Justo","Marques"]

def genDataJug(jugador):
    jugador.nombre = listaNombres[random.randint(0,len(listaNombres)-1)]
    jugador.apellido1 = listaApellidos[random.randint(0,len(listaApellidos)-1)]
    jugador.apellido2 = listaApellidos[random.randint(0,len(listaApellidos)-1)]
    jugador.PJ = random.randint(0,38)
    jugador.PT = random.randint(0,jugador.PJ)

#saco los equipos
listaEquipos = []    
with open('equipos.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=';')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            line_count += 1
        else:
            equipo = Equipo(row[0],row[1],row[2],row[3],row[4],row[5],row[6],row[7])
            listaEquipos.append(equipo)
            line_count += 1

#meto jugadores al equipo
for equipo in listaEquipos:
    listaJugadoresEquipo = []
    for i in range(int(equipo.n_jugadores)):
        jugador = Jugador()
        genDataJug(jugador)
        jugador.nombreCompletoEquipo=equipo.nombre
        listaJugadoresEquipo.append(jugador)
    print(id(equipo.jugadores))
    print(id(listaJugadoresEquipo))
    equipo.jugadores = listaJugadoresEquipo

def indiceRepetido(listaIndices,indice):
    for index in listaIndices:
        if index==indice:
            return True
    return False


def genIndice():
    indice = random.randint(0,int(equipo.n_jugadores)-1)
    if(indiceRepetido(listaIndices,indice)):
        indice = genIndice()
    return indice

#los equipos
for equipo in listaEquipos:
    #juegan 38 partidos
    for i in range(38):
        #num de jugadores que jugaran en ese partido seleccionados aleatoriamente
        njugadores_juegan = random.randint(7,10)
        listaIndices = []
        for j in range(njugadores_juegan):
            indice = genIndice()
            listaIndices.append(indice)
            
        for indice in listaIndices:
            equipo.jugadores[indice].puntos = equipo.jugadores[indice].puntos + random.randint(0,30)
            equipo.jugadores[indice].asis = equipo.jugadores[indice].asis + random.randint(0,15)
            equipo.jugadores[indice].reb = equipo.jugadores[indice].reb + random.randint(0,15)
            equipo.jugadores[indice].tap = equipo.jugadores[indice].tap + random.randint(0,5)
            equipo.jugadores[indice].vN.append(random.randint(-30,40)) 
        #jugadores que no han jugado el partido
        for j in range(int(equipo.n_jugadores)):
            if j not in listaIndices:
                equipo.jugadores[indice].vN.append(0)

#relleno la lista jugadores para crear el csv con todos los jugadores de todos
#los equipos
listaJugadores = []
for equipo in listaEquipos:
    jugadores = equipo.jugadores
    for jugador in jugadores:
        listaJugadores.append(jugador)

with open('jugadores.csv','w',newline='') as file:
    writer = csv.writer(file,delimiter=';')
    listaNombresColumna = ["nombre", "apellido1", "apellido2", "nombreCompletoEquipo",
                     "PJ","PT","puntos","asis", "reb", "tap"]
    for i in range(38):
        listaNombresColumna.append("v"+str((i+1)))
    writer.writerow(listaNombresColumna)
    
    for jugador in listaJugadores:
        listaFila = [jugador.nombre,jugador.apellido1,jugador.apellido2,
                         jugador.nombreCompletoEquipo,jugador.PJ,jugador.PT,
                         jugador.puntos,jugador.asis,jugador.reb,jugador.tap]
        for n in jugador.vN:
            listaFila.append(n)
        writer.writerow(listaFila)
        
        
        
        