# -*- coding: utf-8 -*-
"""
Created on Thu Jan 28 09:09:18 2021

@author: JoseAntonioVelasco
"""

import matplotlib.pyplot as plt

mins_cpu = []
avgs_cpu = []
maxs_cpu = []
sums_cpu = []
times_cpu = []
events_cpu = []
p95s_cpu = []


avgs_mem = []

def parseLineToFloat(line,info):
    line = line.replace(info,"")
    return float(line)

def parseLineToInt(line,info):
    line = line.replace(info,"")
    return int(line)

with open("prueba_cpu.txt") as fh:
    for line in fh:
        if line.startswith("    total number of events:"):
            events_cpu.append(parseLineToInt(line,"    total number of events:"))
        elif line.startswith("         min:"):
            mins_cpu.append(parseLineToFloat(line,"         min:"))
        elif line.startswith("         avg:"):
            avgs_cpu.append(parseLineToFloat(line,"         avg:"))
        elif line.startswith("         max:"):
            maxs_cpu.append(parseLineToFloat(line,"         max:"))
        elif line.startswith("         sum:"):
            sums_cpu.append(parseLineToFloat(line,"         sum:"))
        
plt.plot([1,2,3,4],events_cpu) 

with open("prueba_memoria.txt") as fh:
    for line in fh:
        if line.startswith("         avg:"):
            avgs_mem.append(parseLineToFloat(line,"         avg:"))
 

#plt.plot([1,2,3],avgs_mem) 