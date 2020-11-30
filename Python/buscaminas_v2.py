"""
Created on Thu Nov 26 09:16:41 2020

@author: JoseAntonioVelasco
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

def paintBoard(board,rowLetter,score,combo,lifes,mines,minesFound):
    size = len(board)
    for i in range(size):
        print("",i, end="")
    print()
    
    paintTop(size)
    print()
    for i in range(size):
        if i < size -1:
            paintMid(size,board[i])
            print(rowLetter.get(i), end="")
            print()
            paintBottom(size)
            print()
        else:
            paintMid(size,board[i])
            print(rowLetter.get(i), end="")
            print()
            paintBottomBoard(size)
    print()
    print("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-")
    print("|  Puntuacion: ", score,"     Combo: ",combo, "     Vidas: ",lifes, "|")
    print("|  Bombas descubiertas: ",minesFound, "  Bombas ocultas: ",mines-minesFound, "|")
    print("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-")
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
    return board

def addMine(board,numrows,numcols):
    x=randrange(numrows)
    y=randrange(numcols)
    if(board[x][y] == "1"):
        addMine(board,numrows,numcols)
    else:
        board[x][y] = "1"
    return board

def showSurrounding(hiddenBoard,visibleBoard,row,col,combo,score,minesFound,mines,lifes):
    if hiddenBoard[row][col] == "1":
        hiddenBoard[row][col] = "3"
        visibleBoard[row][col] = "x"
        
        combo = combo + 1
        score = score + combo
        minesFound = minesFound + 1
        if minesFound == mines:
            scores = readScoreboard()
            sorted_scores = sorted(scores, key=lambda x: x[2])
      
            if len(sorted_scores)==0 or (int(sorted_scores[0][2]) > score)==False:
                #yes scoreboard
                name = "DESCONOCIDO"
                name = input("Introduce nombre: ")
                name.replace(",","")
                
                scoreboard = open("ficheroMaximasPuntuaciones.txt","r")
                if len(open("ficheroMaximasPuntuaciones.txt").readlines()) >= 10:
                    #find line with less score and delete it
                    minScore = int(sorted_scores[0][2])
                    lines = scoreboard.readlines()
                    scoreboard = open("ficheroMaximasPuntuaciones.txt","w")
                    for line in lines:
                       row = line.split(",")
                       if row[2].strip("\n") != str(minScore):
                           scoreboard.write(line)
                           
                scoreboard = open("ficheroMaximasPuntuaciones.txt","a")
                scoreboard.write(str(mines/2)+","+name+","+str(score)+"\n")
                scoreboard.close()
                
            else:
                #no scoreboard
                print("No has superado el record.")
                print("Tu puntuacion es: ",score)
            secondMenu()
        
    elif hiddenBoard[row][col] == "0":
        hiddenBoard[row][col] = "2"
        visibleBoard[row][col] = " "
        
        combo = 0
        score = score - 1
        lifes = lifes - 1
        if lifes == 0:
            print("Te has quedado sin vidas! ")
            secondMenu()
    return [combo,score,minesFound,mines,lifes]
letters = ["A","B","C","D","E","F","G","H","I","J"]
def newGame(hiddenBoard,difficulty,lifes,score,combo,mines,minesFound):
    #calculate rowLetter bi-direct dictionary outside while loop
    rowLetter = {}
    for i in range(difficulty):
        rowLetter[i] = letters[i]
        rowLetter[letters[i]] = i
    while(True):  
      paintBoard(hiddenBoard,rowLetter,score,combo,lifes,mines,minesFound)
      visibleBoard = calculateVisibleBoard(hiddenBoard)
      paintBoard(visibleBoard,rowLetter,score,combo,lifes,mines,minesFound)
      optionLetter = input("Elija una opcion: (C)oordenada, (G)uardar o (S)alir: ")
      if optionLetter == "C":
          coord = input("Introduce coordenada <Letra><Numero>: ")
          while (coord[0] in rowLetter and int(coord[1]) in rowLetter) == False:
              coord = input("Introduce coordenada <Letra><Numero>: ")
          arguments=showSurrounding(hiddenBoard,visibleBoard,rowLetter.get(coord[0]),int(coord[1]),combo,score,minesFound,mines,lifes)
          combo = arguments[0]
          score = arguments[1]
          minesFound = arguments[2]
          mines =  arguments[3]
          lifes = arguments[4]
      elif optionLetter == "G":
          name = input("Nombre de la partida: ")
          saveGame = open(name + ".txt", "a") 
          saveGame.write(str(difficulty)+";"+str(lifes)+";"+str(score)+";"+str(combo)+"\n")
          for i in range(difficulty):
              for j in range(difficulty):  
                if j == difficulty - 1:
                    saveGame.write(hiddenBoard[i][j])
                else:
                    saveGame.write(hiddenBoard[i][j]+",")
              saveGame.write("\n")
          saveGame.close()
          sys.exit()
          
      elif optionLetter == "S":
          sys.exit()

def calculateVisibleBoard(hiddenBoard):
    size = len(hiddenBoard)
    visibleBoard = initBoardList(size,u'\u2593')
    for i in range(size):
        for j in range(size):
            if hiddenBoard[i][j] == "2":
                visibleBoard[i][j] = " "
            elif hiddenBoard[i][j] == "3":
                visibleBoard[i][j] = "x"
    return visibleBoard            

def menu():
    print("**************************************************************")
    print("******************** BIENVENIDO AL JUEGO *********************")
    print("**************************************************************")
    print()
    print("Seleccione una opcion del siguiente menu:")
    print("\t1. Jugar nueva partida.")
    print("\t2. Carga partida desde fichero.")
    print("\t3. Ver tablas de maximas puntuaciones.")
    print("\t4. Salir del juego.")
    option = int(input())
    
    if option == 1:
        print("Selecciona dificultad (4,5,6,7,8,9,10): ")
        boardSize = int(input())
        lifes = boardSize
        mines = boardSize*2
        score = 0
        combo = 0
        hiddenBoard = initBoardList(boardSize,"0")
        hiddenBoard = addMines(hiddenBoard,mines)
        newGame(hiddenBoard,boardSize,lifes,score,combo,mines,0)
    
    elif option == 2:
         path = input("Introduce el nombre de la partida que quieres cargar: ")
         saveGame = open(path + ".txt", "r") 
         line = saveGame.readline()
         arguments=line.split(";")
         hiddenBoard = []
         minesFound = 0
         for line in saveGame:
             l=line.rstrip()
             row=l.split(",")
             for i in range(len(row)):
                 if row[i] == "3":
                     minesFound = minesFound + 1
             hiddenBoard.append(row)
         newGame(hiddenBoard,int(arguments[0]),int(arguments[1]),int(arguments[2]),int(arguments[3]),int(arguments[0])*2,minesFound)
    elif option == 3:
        scores = readScoreboard()
        print(scores)
        sorted_scores = sorted(scores, key=lambda x: x[2])
        print("NIVEL \t PUNTUACION \t JUGADOR")
        for i in range(len(sorted_scores)): 
            print("  "+sorted_scores[i][0],end="\t\t\t")
            print("  "+sorted_scores[i][2],end="\t\t")
            print("  "+sorted_scores[i][1])
        menu()
    else:
         sys.exit()
def readScoreboard():
    scoreboard = open("ficheroMaximasPuntuaciones.txt","r")
    scores = []
    for line in scoreboard:
        l=line.rstrip()
        row=l.split(",")
        scores.append(row)
    scoreboard.close()
    return scores
def writeScoreboard(scores):
    scoreboard = open("ficheroMaximasPuntuaciones.txt","a")
    for i in range(len(scores)):
        scoreboard.write(str(scores[i][0])+","+scores[i][1]+","+str(scores[i][2]))
    scoreboard.close()
def secondMenu():
    print("Elija una opcion: (M)enu o (S)alir: ")
    option = input()
    if option == "M":
        menu()
    else:
        sys.exit()

menu()
    