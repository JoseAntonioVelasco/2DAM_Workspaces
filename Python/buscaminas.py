# -*- coding: utf-8 -*-
"""
Created on Thu Nov 26 09:16:41 2020

@author: ADMIN
"""
    
def paintTop(size):
    print(u'\u250C', end='')
    for i in range(size):
        if i < size-1:
            print(u'\u2500', end='')
            print(u'\u252C', end='')
        else:
            print(u'\u2500', end='')
            print(u'\u2510', end='')
            
def paintMid(size):
    for i in range(size):
        print(u'\u2502', end='')
        print(u'\u2593', end='')
        
    print(u'\u2502', end='')
    
def paintBottom(size):
    print(u'\u251C', end='')
    for i in range(size):
        if i < size-1:
            print(u'\u2500', end='')
            print(u'\u253C', end='')
        else:
            print(u'\u2500', end='')
            print(u'\u2524', end='')
def paintBottomBoard(size):
    print(u'\u2514', end='')
    for i in range(size):
        if i < size-1:
            print(u'\u2500', end='')
            print(u'\u2534', end='')
        else:
            print(u'\u2500', end='')
            print(u'\u2518', end='')
            
def paintBoard(size):
    paintTop(size)
    print()
    for i in range(size):
        if i < size -1:
            paintMid(size)
            print()
            paintBottom(size)
            print()
        else:
            paintMid(size)
            print()
            paintBottomBoard(size)



paintBoard(10)

