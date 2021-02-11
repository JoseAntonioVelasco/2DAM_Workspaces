#!/usr/bin/env python3
# -*- coding: utf-8 -*-


# Ejercicio 4
# Código para los alumnos
"""
    ejercicio 4 - Esta es la documentación del módulo ejercicio4, que contiene algunas operaciones y que se tendrá que comentar en el examen de
    python
"""

def tablaMultiplicar(n):
    """
    Imprime por pantalla la tabla de multiplicar del numero entero pasado como argumento

    Parameters
    ----------
    n : int
        Número entero del que se va a calcular la tabla de multiplicar.

    Returns
    -------
    Nada.

    """
    for i in range(11):
        print(n,"x",i,"=",n*i)
        

def maximoComunDivisor(n1,n2):
    """
    Imprime por pantalla y devuelve el máximo común divisor de dos enteros pasados como argumento.

    Parameters
    ----------
    n1 : int
        Primer argumento.
    n2 : int
        Segundo argumento.

    Returns
    -------
    menor : TYPE
        El valor del máximo común divisor de n1 y n2.

    """
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
    """
    Imprime por pantalla y devuelve el mínimo común múltiplo de dos enteros pasados como argumento

    Parameters
    ----------
    n1 : int
        Primer argumento.
    n2 : int
        Segundo argumento.

    Returns
    -------
    mcm : TYPE
        El valor del mínimo común múltiplo de n1 y n2.

    """
    menor = min(n1,n2)

    for i in range(1,menor):
        if (n1%i==0 and n2%i==0):
            mcd = i
            mcm = (n1*n2)/mcd
    print(mcm)
    return mcm

