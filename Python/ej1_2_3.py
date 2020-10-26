# -*- coding: utf-8 -*-
"""
Created on Thu Oct  1 09:02:40 2020

@author: ADMIN
"""


#EJERCICIOS IF ELSE

'''
#EJERCICIO 1
numero1=int (input("Dime un numero"))
numero2=int (input("Dime un numero"))
print("la suma es",str(numero1+numero2));
'''

'''
#EJERCICIO 2
numero1=int (input("Dime un numero"))
numero2=int (input("Dime un numero"))

print("Que operacion quieres realizar")
print("1.Suma")
print("2.Resta")
opcion=int (input("opcion: "))
if opcion==1:
    print("la suma es",str(numero1+numero2))
elif opcion==2:
    print("la resta es",str(numero1-numero2))
'''   

'''
#EJERCICIO 3
numero1=int (input("Dime un numero"))
numero2=int (input("Dime un numero"))

print("Que operacion quieres realizar")
print("1.Suma")
print("2.Resta")
opcion=int (input("opcion: "))
while opcion != 1 or opcion != 2: 
    if opcion==1:
        print("la suma es",str(numero1+numero2))
        break
    elif opcion==2:
        print("la resta es",str(numero1-numero2))
        break
    else:
        print("No es una opcion")
        opcion=int (input("opcion: "))
'''      

     
#EJERCICIOS WHILE

'''
#EJERCICIO1
num = int (input("Dime un numero: "))
i=0
sumatorio=0
while i<=num:
    if(i%2==0):
        sumatorio = sumatorio + i
    i=i+1
print(sumatorio)
'''

'''
#EJERCICIO2  
num = int (input("Dime un numero: "))
while num<50 or num>100:
    num = int (input("Dime un numero: "))
    
i=0
sumatorio=0
while i<=num:
    if(i%2==0):
        sumatorio = sumatorio + i
    i=i+1
print(sumatorio)
'''

'''
#EJERCICIO3 No se
num = int (input("Dime un numero: "))
while num in range(50) or num in range(100):
    num = int (input("Dime un numero: "))
    
i=0
sumatorio=0
while i<=num:
    if(i%2==0):
        sumatorio = sumatorio + i
    i=i+1
print(sumatorio)
'''

'''
#EJERCICIO4
numero1=int (input("Dime un numero"))
numero2=int (input("Dime un numero"))

print("Que operacion quieres realizar")
print("1.Suma")
print("2.Resta")
opcion=int (input("opcion: "))
while opcion != 1 or opcion != 2: 
    if opcion==1:
        print("la suma es",str(numero1+numero2))
        break
    elif opcion==2:
        print("la resta es",str(numero1-numero2))
        break
    else:
        print("No es una opcion")
        opcion=int (input("opcion: "))
'''

#EJERCICIOS FOR

'''
#EJERCICIO1
numero=int (input("Cuantos numeros quieres introducir: "))
lista =[]
i=0
for i in range(numero):
    num=int (input("Introduce numero"+str(i+1)+": "))
    lista.append(num)
print(lista)
'''

#EJERCICIO2
numero=int (input("Hasta donde quieres calcular la sucesion de fibonacci: "))
num=0
# 0 1 2 3 5 8
for i in range(numero):
    num 
 