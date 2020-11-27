# -*- coding: utf-8 -*-
"""
Created on Thu Nov 26 09:16:41 2020

@author: ADMIN
"""
from random import randrange

def paintTop(size):
    print(u'\u250C', end='')
    for i in range(size):
        if i < size-1:
            print(u'\u2500', end='')
            print(u'\u252C', end='')
        else:
            print(u'\u2500', end='')
            print(u'\u2510', end='')
           
def paintMid(size,row):
    for i in range(size):
        print(u'\u2502', end='')
        #print(u'\u2593', end='')
        print(row[i], end='')
        
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
            
def paintBoard(board):
    size = len(board)
    paintTop(size)
    
    print()
    for i in range(size):
        if i < size -1:
            paintMid(size,board[i])
            print()
            paintBottom(size)
            print()
        else:
            paintMid(size,board[i])
            print()
            paintBottomBoard(size)


def initBoardList(size):
    board = []
    for i in range(size):
        row = []
        for j in range(size):
            row.append(0)
        board.append(row)
    return board

def addMines(board,num_mines):
    numrows = len(board)
    numcols = len(board[0])
    
    for i in range(num_mines):
        board[randrange(numcols)][randrange(numrows)] = "x"

def validPos(board,row,col):
    numrows = len(board) 
    numcols = len(board[0])
    
    if row>=numrows or col>=numcols or board[row][col] == "x":
        return False;
    return True;

def addNumbersBoard(board):
    numrows = len(board)
    numcols = len(board[0])
    
    for i in range(numrows):
        for j in range(numcols):
            if board[i][j] == "x":
                #sum 1 to surroundings
                if validPos(board,i-1,j-1):
                    board[i-1][j-1] = board[i-1][j-1] +1
                    
                if validPos(board,i-1,j):
                    board[i-1][j] = board[i-1][j] +1
                    
                if validPos(board,i-1,j+1):
                    board[i-1][j+1] = board[i-1][j+1] +1
                    
                if validPos(board,i,j+1):
                    board[i][j+1] = board[i][j+1] +1
                    
                if validPos(board,i+1,j+1):
                    board[i+1][j+1] = board[i+1][j+1] +1
                
                if validPos(board,i+1,j):
                   board[i+1][j] = board[i+1][j] +1
               
                if validPos(board,i+1,j-1):
                   board[i+1][j-1] = board[i+1][j-1] +1
                
                if validPos(board,i,j-1):
                   board[i][j-1] = board[i][j-1] +1
    return board

#def showSurroundings(board,row,col):
    

board = initBoardList(5)
print(validPos(board,4,4))
print(len(board))
addMines(board,5)
print(board)
addNumbersBoard(board)
print(paintBoard(board))
    
