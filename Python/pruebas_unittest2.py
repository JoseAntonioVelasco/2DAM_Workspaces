# -*- coding: utf-8 -*-
"""
Created on Sat Jan 16 22:00:04 2021

@author: cagan
""" 
import pruebas_unittest as p

import unittest
            
class PruebaFunciones(unittest.TestCase):
    def test_compruebaMayusculas(self):
        self.assertTrue(p.compruebaMayusculas("ASDAGA"))
        
    def test_compruebaMinusculas(self):
        self.assertTrue(p.compruebaMinusculas("asdasd"))
    
    def test_tieneEspacios(self):
        self.assertTrue(p.tieneEspacios("asd ads"))
    
    def test_cuentaLetras(self):
        self.assertEqual(p.cuentaLetras("asd"),3)
        
    def test_cuentaEspacios(self):
        self.assertEqual(p.cuentaEspacios("a a"),1)
        
    def test_esPalindromo(self):
        self.assertTrue(p.esPalindromo("oro"))
        
    def test_tieneLetra(self):
        self.assertTrue(p.tieneLetra("asd","a"))
        
    def test_invertirCadena(self):
        self.assertEqual(p.invertirCadena("asd"),"dsa")
        
    def test_alterarMayMin(self):
        self.assertEqual(p.alterarMayMin("AyA"),"aYa")
        
    def test_eliminaCaracteres(self):
        self.assertEqual(p.eliminaCaracteres("aya","a"),"y")

if __name__ == '__main__':
    unittest.main()