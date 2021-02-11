#!/usr/bin/env python3
# -*- coding: utf-8 -*-


# Ejercicio 4
# Código para los alumnos


def tablaMultiplicar(n):
    for i in range(11):
        print(n,"x",i,"=",n*i)
        

def maximoComunDivisor(n1,n2):
    mayor = max(n1, n2)
    menor = min(n1, n2)
    if ((n1 and n2) == 0):
       menor = mayor
    else:
        r = mayor % menor
        while r != 0:
            mayor = r
            r = menor%r
            menor = mayor
    print(menor)
    return menor

def minimoComunMultiplo(n1,n2):
    menor = min(n1,n2)

    for i in range(1,menor):
        if (n1%i==0 and n2%i==0):
            mcd = i
            mcm = (n1*n2)/mcd
    print(mcm)
    return mcm

