/*evaluatePos functions*/
function checkWin(position,player,tablero){
	//Retorna true si en esa posicion ese jugador gana
	var vectores = [[1,1],[0,1],[-1,1],[1,0]]; //[diagonal izquierda],[horizontal],[diagonal derecha],[vertical]
	for(var b=0; b<vectores.length; b++){

		var origen = getPosicionLim(vectores[b],position);
		var contador_victoria = 0;

		for(var i=origen[0], j=origen[1]; esLegal(i,j) && (j<(position[1]+4)); i+=vectores[b][0], j+=vectores[b][1]){

			if(getCasilla(i,j,tablero)==player){
				contador_victoria++;
			}else{
				contador_victoria=0;
			}
			if(contador_victoria==4){
				return true; //win
			}
		}
		
	}
	
	return false;
}
function checkLose(position,player,tablero){
	return checkWin(position,rotarPlayer(player),tablero)
}
function checkThreeInRow(position,player,tablero){
	//Comprueba si hace 3 en raya, comprobando las distintas maneras de conseguirlos
	//y por cada 3 en raya que consigue da puntos
	var vectores = [[1,1],[0,1],[-1,1],[1,0]]; //[diagonal izquierda],[horizontal],[diagonal derecha],[vertical]
	var puntuacion = 0;

	for(var b=0; b<vectores.length; b++){

		var origen = getPosicionLim(vectores[b],position);
		var contador = 0;
		var contador_espacio = 0;
		var combo = 0;

		for(var i=origen[0], j=origen[1]; esLegal(i,j) && (j<(position[1]+4)); i+=vectores[b][0], j+=vectores[b][1]){

			if(getCasilla(i,j,tablero)==player){
				contador++;
				combo++;
			}
			else if(i==position[0] && j==position[1]){
				contador++;
				combo++;
			}else{
				if(getCasilla(i,j,tablero)==""){
					contador_espacio++;
					combo = 0;
				}else{
					contador=0;
					combo = 0;
				}
			}
			if(contador==3 && contador_espacio==1){
				if(combo==3){
					//comprobar la casilla de la derecha y si es espacio +1 3 en raya doble
					i+=vectores[b][0]; j+=vectores[b][1];
					if(esLegal(i,j) && (j<(position[1]+4))){
						if(getCasilla(i,j,tablero)==""){
							puntuacion = puntuacion + 20; //3 en raya x2 lados
						}
					}
				}
				puntuacion = puntuacion + 10; // 3 en raya x1 lado
			}
		}
		
	}
	return puntuacion;
}
function block_threeInRow(player,tablero){
	//hace el inverso a comprobar si hace 3 en raya,
	//da puntos por bloquear los 3 en raya del oponente.
	return (checkThreeInRow(rotarPlayer(player),tablero))/2;
}
function proxCenter(player,tablero){
	//da puntos por poner fichas proximas al centro
	var puntuacion = 0;
	for(var i=0;i<6;i++){
		if(tablero[i][1]==player ||tablero[i][5]==player){
			puntuacion += 1;
		}
		if(tablero[i][2]==player ||tablero[i][4]==player){
			puntuacion += 2;
		}
		if(tablero[i][3]==player){
			puntuacion += 3;
		}
	}
	return puntuacion;
}
/*MINIMAX ALG*/

function max(num1,num2){
	//Retorna el num mayor
	if(num1>num2){
		return num1;
	}
	return num2;
}
function min(num1,num2){
	//Retorna el num menor
	if(num1<num2){
		return num1;
	}
	return num2;
}
function simularTablero(casilla, player, tablero){
	//Retorna el tablero con la ficha del player puesta en la casilla indicada
	
	var tablero_simulado = [];
	tablero_simulado = inicializarTablero(tablero_simulado);
	
	for(var i=0; i<6; i++){//fil
		for(var j=0; j<7; j++){//col
			tablero_simulado[i][j]=tablero[i][j];
		}
	}
	
	tablero_simulado[casilla[0]][casilla[1]]=player;
	
	return tablero_simulado;
}
function rotarPlayer(player){
	//rotamos la ficha
	if(player=="X"){
		player="O";
	}else{
		player="X";
	}
	return player;
}
function evaluatePos(position,player,tablero){
	var evaluation = 0;
	//comprobar criterios y dar puntos
		//next win
		if(checkWin(position,player,tablero)){
			evaluation+=999
		}
		//next 3 in row
		evaluation+=checkThreeInRow(player,tablero);
		//next block 3 in row
		evaluation+=block_threeInRow(player,tablero);
		//+1 pt for placing near center
		evaluation+=proxCenter(player,tablero);
	return evaluation;
}
//source  de esta funcion : "https://www.youtube.com/watch?v=l-hh51ncgDI"
function minimax(position, depth, maximizingPlayer,player,tablero){
	
	if(depth == 0){
		return evaluatePos(position,player,tablero);
	}
	
	if(maximizingPlayer){
		var maxEval = -999; //-infinito
		var casillas_disp = getCasillasDisponibles(tablero);
		
		casillas_disp.forEach(function(casilla){
			var tablero_simulado=simularTablero(casilla,player,tablero);
			player = rotarPlayer(player);
			var eval = minimax(casilla,depth-1,false,player,tablero_simulado);
			player = rotarPlayer(player);
			maxEval = max(maxEval, eval);
		});
		
		return maxEval;	
	}else{
		var minEval=999; //+infinito
		var casillas_disp = getCasillasDisponibles(tablero);
		
		casillas_disp.forEach(function(casilla){
			var tablero_simulado=simularTablero(casilla,player,tablero);
			player = rotarPlayer(player);
			var eval = minimax(casilla,depth-1,true,player,tablero_simulado);
			player = rotarPlayer(player);
			minEval = min(minEval, eval);
		});
		
		return minEval;
	}
}
function getCol_seleccionada(player,profundidad,tablero){
	var casillas_disponibles=getCasillasDisponibles(tablero);
	var puntuaciones = [];
	var maximizingPlayer = false;
	
	
	//Por cada casilla disponible
	casillas_disponibles.forEach(function(casilla){
		var puntuacion = 0;
		var tablero_simulado=simularTablero(casilla,player,tablero);
		player = rotarPlayer(player);
		puntuacion = minimax(casilla,profundidad,maximizingPlayer,player,tablero_simulado);
		player = rotarPlayer(player);
		puntuaciones.push([puntuacion,casilla]);
	});
	
	//seleccionando el maximo
	var max_puntuacion = -9999; //-infinito
	var casilla_maxpts = -1; 
	for(var i=0; i<puntuaciones.length; i++){
		if(puntuaciones[i][0]>max_puntuacion){
			max_puntuacion = puntuaciones[i][0];
			casilla_maxpts = i;
		}
	}
	console.log(puntuaciones);
	return  puntuaciones[casilla_maxpts][1][1]; //columna de la casilla con maxima puntuacion
}
function minimaxAI(){
	//ficha puede ser "X" o "O" es una variable global que va cambiando segun se pasan turnos,
	//en el caso de que el minimax sea el jugador1 entonces siempre sera las "X"
	//en el caso de que el minimax sea el jugador2 entonces siempre sera las "O"
	var tablero = getTablero_HTML();
	var col=getCol_seleccionada(ficha,5,tablero); //el segundo arg es para ajustar la profundidad de las jugadas
	console.log("minimaxAI pone: "+ficha+" "+(col+1));
	poner_fichaHTML(col+1);
}