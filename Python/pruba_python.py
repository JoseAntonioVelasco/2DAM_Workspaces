# -*- coding: utf-8 -*-
"""
Created on Mon Jan 11 08:57:12 2021

@author: ADMIN
"""

def suma(n1,n2):
    """
    

    Parameters
    ----------
    n1 : TYPE
        DESCRIPTION.
    n2 : TYPE
        DESCRIPTION.

    Returns
    -------
    TYPE
        DESCRIPTION.
    
    ================PRUEBAS FUNCION================
    
    SUMA SIMPLE
    >>> suma(7,8)
    15
    
    SUMA DE LISTAS
    >>> suma([1, 2, 3],[4, 4, 4])
    [1, 2, 3, 4, 4, 4]
    
    SUMA DE CADENAS
    >>> suma('hola','adios')
    'holaadios'
    
    SUMA DE LISTAS CON VARIABLES
    >>> lista1=[1, 2, 3]
    >>> lista2=[4, 4, 4]
    >>> suma(lista1,lista2)
    [1, 2, 3, 4, 4, 4]
    
    SUMA LISTAS BUCLE
    >>> lista3 = []
    >>> for i in range(5):
    ...     lista3.append(i)
    >>> suma(lista3,lista1)
    [0, 1, 2, 3, 4, 1, 2, 3]
    
    ================PRUEBAS FUNCION================
    """
    
    return n1+n2

import doctest
doctest.testmod()

"""
abrir cmd donde este guardado este fichero
y ejecutar el siguiente comando:
    
python pruba_python.py -v

"""