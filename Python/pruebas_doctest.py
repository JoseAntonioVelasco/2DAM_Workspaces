# -*- coding: utf-8 -*-
"""
Created on Thu Jan 14 12:36:45 2021

@author: JoseAntonioVelasco
"""

def busquedaElemento(lista,elemento):
    """
    Informa sobre si existe un elemento en la lista

    Parameters
    ----------
    lista : TYPE
        DESCRIPTION.
    elemento : TYPE
        DESCRIPTION.

    Returns
    -------
    bool
        DESCRIPTION.
     
        
    >>> lista = [1, 2, 3] 
    >>> busquedaElemento(lista,1)
    True
    
    >>> busquedaElemento(lista,5)
    False
    
    >>> busquedaElemento(lista,'a')
    False

    """
    if(elemento in lista):
        return True
    else:
        return False
    
def sumarListas(lista1,lista2):
    """
    Suma de listas y tipos simples

    Parameters
    ----------
    lista1 : TYPE
        DESCRIPTION.
    lista2 : TYPE
        DESCRIPTION.

    Returns
    -------
    TYPE
        DESCRIPTION.

    >>> sumarListas([1, 2, 3],[4, 4, 4])
    [1, 2, 3, 4, 4, 4]
    >>> sumarListas([1, 2, 3],[4, 4, 5])
    [1, 2, 3, 4, 4, 5]
    >>> sumarListas([1, 3, 3],[4, 4, 4])
    [1, 3, 3, 4, 4, 4]
    """
    return lista1+lista2

def ordenarLista(lista1):
    """
    ordena listas

    Parameters
    ----------
    lista1 : TYPE
        DESCRIPTION.

    Returns
    -------
    TYPE
        DESCRIPTION.

    >>> ordenarLista([1, 2, 3])
    [1, 2, 3]
    >>> ordenarLista([3, 2, 3])
    [2, 3, 3]
    >>> ordenarLista([1, 3, 3])
    [1, 3, 3]
    """
    return sorted(lista1)

def invertirLista(lista1):
    """
    invierte listas

    Parameters
    ----------
    lista1 : TYPE
        DESCRIPTION.

    Returns
    -------
    TYPE
        DESCRIPTION.

    >>> invertirLista([1, 2, 3])
    [3, 2, 1]
    >>> invertirLista([3, 2, 3])
    [3, 2, 3]
    >>> invertirLista([1, 3, 3])
    [3, 3, 1]
    """
    lista1.reverse()
    return lista1
        

def acortarLista(lista1,n):
    """
    acorta una lista por el indice indicado

    Parameters
    ----------
    lista1 : TYPE
        DESCRIPTION.
    n : TYPE
        DESCRIPTION.

    Returns
    -------
    lista : TYPE
        DESCRIPTION.
    
    >>> acortarLista([1, 2, 3], 1)
    [1]
    >>> acortarLista([1, 2, 3], 0)
    []
    >>> acortarLista([1, 2, 3], 2)
    [1, 2]
    """
    lista = []
    for i in range(n):
        lista.append(lista1[i])
    return lista


import doctest
doctest.testmod()
"""
abrir cmd donde este guardado este fichero
y ejecutar el siguiente comando:
    
python <nombre del fichero>.py -v

"""