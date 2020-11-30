# -*- coding: utf-8 -*-
"""
Created on Thu Nov 26 09:16:41 2020

@author: ADMIN
"""
from random import randrange
import sys

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


def initBoardList(size,char):
    board = []
    for i in range(size):
        row = []
        for j in range(size):
            row.append(char)
        board.append(row)
    return board

def addMines(board,num_mines):
    numrows = len(board)
    numcols = len(board[0])
    
    for i in range(num_mines):
        addMine(board,numrows,numcols)
        #print("pongo x: ",x," y: ",y)  
    return board

def addMine(board,numrows,numcols):
    x=randrange(numrows)
    y=randrange(numcols)
    if(board[x][y] == "x"):
        addMine(board,numrows,numcols)
    else:
        board[x][y] = "x"
    return board

def validPos(board,row,col):
    numrows = len(board) 
    numcols = len(board[0])
    
    if row>=numrows or col>=numcols or row<0 or col<0 or board[row][col] == "x":
        return False;
    return True;
def addNumbersBoard(board):
    numrows = len(board)
    numcols = len(board[0])
    
    for i in range(numrows):
        for j in range(numcols):
            if board[i][j] == "x":
                #sum 1 to surroundings
                for x in range(-1,2):
                    for y in range(-1,2):
                        if validPos(board,i+x,j+y):
                            board[i+x][j+y] = board[i+x][j+y] +1
    return board

def showSurroundings(hiddenBoard,visibleBoard,row,col):
    if hiddenBoard[row][col] == "x":
        print("BOOM!")
        sys.exit()
    elif hiddenBoard[row][col] > 0:
        #show number in table
        visibleBoard[row][col] = hiddenBoard[row][col]
    else:
        #show recursively  0 and numbers
        blankSurroundings(hiddenBoard,visibleBoard,row,col)
        
    return visibleBoard
def blankSurroundings(hiddenBoard,visibleBoard,row,col):
    for x in range(-1,2):
        for y in range(-1,2):

            if validPos(hiddenBoard,row+x,col+y):   
                #>0 show number
                if hiddenBoard[row+x][col+y] > 0:
                    visibleBoard[row+x][col+y] = hiddenBoard[row+x][col+y]
                #==0 show and recur
                if hiddenBoard[row+x][col+y] == 0 and visibleBoard[row+x][col+y] == u'\u2593':
                    visibleBoard[row+x][col+y] = hiddenBoard[row+x][col+y]
                    visibleBoard = blankSurroundings(hiddenBoard,visibleBoard,row+x,col+y)
    return visibleBoard
            
boardSize = 5
mines = 5      
hiddenBoard = initBoardList(boardSize,0)
hiddenBoard = addMines(hiddenBoard,mines)
hiddenBoard = addNumbersBoard(hiddenBoard)
visibleBoard = initBoardList(boardSize,u'\u2593')

while(True):
    paintBoard(hiddenBoard)
    paintBoard(visibleBoard)
    row = int(input("row: "))
    col = int(input("col: "))
    showSurroundings(hiddenBoard,visibleBoard,row,col)
    