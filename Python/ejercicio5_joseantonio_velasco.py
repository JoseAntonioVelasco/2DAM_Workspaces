#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# Ejercicio 5
# Código para los alumnos
"""
@author JoseAntonioVelasco
"""
import ejercicio5 as ej 
import unittest
numeros = [1,2,3,4,5]
cadenas = ["hola","que","tal"]
letras = ["h","h","o","l","a"]
mezcla = [1,"hola",3.65,"z"]


class tests(unittest.TestCase):

    def test_a1(self):
        self.assertEqual(ej.suma([1],[2]),[1,2])
    
    def test_a2(self):
        self.assertNotEqual(ej.suma([1],[2]),[1,2,1,2])
        
    def test_a3(self):
        self.assertNotEqual(ej.suma(["hola"],["mundo"]),["holamundo"])
        
    def test_b1(self):
        self.assertEqual(ej.eliminaUltimoElemento(mezcla),[1,"hola",3.65])
        
    def test_b2(self):
        self.assertNotEqual(ej.eliminaUltimoElemento(numeros),[1,2,3,4,5])
    
    def test_b3(self):
        self.assertNotIn('a',ej.eliminaUltimoElemento(letras))
    
    def test_c1(self):
        self.assertEqual(ej.multiplica(2,letras),ej.suma(letras,letras))
    
    def test_c2(self):
        self.assertNotIn(ej.multiplica(3,letras),letras)
        
    def test_d1(self):
        self.assertFalse(ej.compruebaPertenencia(7,numeros))
        
    def test_d2(self):
        self.assertEqual(ej.compruebaPertenencia(7,numeros),ej.compruebaPertenencia(8,numeros))
        
if __name__ == '__main__':
    unittest.main()
