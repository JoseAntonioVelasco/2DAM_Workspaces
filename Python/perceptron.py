# -*- coding: utf-8 -*-
"""
Created on Thu Dec  3 08:21:51 2020

@author: ADMIN
"""

import numpy as np

def sigmoid(x):
    return 1/(1+np.exp(-x))
def dx_sigmoid(x):
    return x * (1 - x)



training_inputs = np.array([[0,0,1],
                            [1,1,1],
                            [1,0,1],
                            [0,1,1]])

training_outputs = np.array([[0,1,1,0]]).T
np.random.seed(1)

#floating point numbers between -1 and 1
synaptic_weights = 2 * np.random.random((3,1)) - 1

print("randon starting synaptic weights: ")
print(synaptic_weights)

for iteration in range(20000):
    
    input_layer = training_inputs
    outputs = sigmoid(np.dot(input_layer, synaptic_weights))
    
    error = training_outputs - outputs
    adjustments = error + dx_sigmoid(outputs)
    
    synaptic_weights += np.dot(input_layer.T,adjustments)
    
print("synaptic weights after training: ")
print(synaptic_weights)
    
print("outputs after training: ")
print(outputs)