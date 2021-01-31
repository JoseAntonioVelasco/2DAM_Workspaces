function inicializarTablero(tablero){
	//Inicializa el tablero con 0
	for(var i=0; i<6; i++){
		tablero.push([0,0,0,0,0,0,0]);
	}
	return tablero
}

function getTablero_HTML(){
	//Retorna un array bidimensional que contiene el tablero
	var tablero_actual = [];
	tablero_actual = inicializarTablero(tablero_actual);

	for(var i=1; i<7; i++){ //filas
		for(var j=1; j<8; j++){ //columnas
			if($( "tr.fil"+i ).children("td.col"+j).text()=="X"){
				tablero_actual[i-1][j-1]="X";
			}
			else if($( "tr.fil"+i ).children("td.col"+j).text()=="O"){
				tablero_actual[i-1][j-1]="O";
			}
			else if($( "tr.fil"+i ).children("td.col"+j).text()==""){
				tablero_actual[i-1][j-1]="";
			}
		}
	}

	return tablero_actual;
}

function getRandomInt(min, max) {
	//Retorna un numero entero aleatorio entre min (incluido) y max (excluido)
	return Math.floor(Math.random() * (max - min) + min);
}

function estaLibre(i,j,tablero){
	//Retorna True si la casilla esta libre, False si esta ocupada
	if(esLegal(i,j)===false){
		return false;
	}
	if(tablero[i][j]=="X" || tablero[i][j]=="O"){
		return false;
	}
	if(tablero[i+1][j]=="X"|| i==6 || tablero[i+1][j]=="O"){
		return true;
	}
}
	
function esLegal(i,j){
	//Retorna False si la posicion esta fuera del tablero
	//True si la posicion esta dentro del tablero
	if(i<0 || i>5 || j<0 || j>6){
		return false;
	}
	return true;
}
	
function getCasilla(i,j,tablero){
	//Retorna lo que haya dentro de esa casilla en el tablero
	if(tablero[i][j]==""){
		return "";
	}
	if(tablero[i][j]=="X"){
		return "X";
	}
	if(tablero[i][j]=="O"){
		return "O"
	}
}

function isColfull(col_number,tablero){
	//Retorna True si la columna esta llena
	//False si la columna no esta llena
	if(getCasilla(0,col_number,tablero)=="X" || getCasilla(0,col_number,tablero)=="O" ){
		return true;
	}else{
		return false;
	}
}
	
function getCasillasDisponibles(tablero){
	//Retorna las casillas en las que un jugador puede poner ficha
	var array_casillas_disponibles = [];
	
	for(var j=0; j<7 ; j++){
		if(isColfull(j,tablero)===false){
			for(var i=5;i>=0;i--){
				if(getCasilla(i,j,tablero)===""){
					//mete casilla al array
					array_casillas_disponibles.push([i,j]);
					break;
				}
			}
		}
	}
	return array_casillas_disponibles;
}

function getPosicionLim(vector,casilla){ 
	/*
	Retorna la posicion limite de busqueda en el tablero
	var vector: es el vector de direccion sobre el que tiene que calcular la posicion limite
	ej: vector [i,j] => [0,1] es horizontal izquierda
	var casilla: es la casilla sobre la que se va a calcular la posicion limite.
	
	La funcion retorna la posicion limite en un radio de 4 casillas,
	si se ha topado con algun borde devuelve hasta donde haya llegado.
	
	ej de funcionamiento: vector = [0,1] casilla = [2,3] Retorna poslim = [2,0]
	*/
	
	//se cambia el sentido del vector
	var way_j=vector[1]*(-1); 
	var way_i=vector[0]*(-1);

	//posicion de la casilla disponible
	var pos_j=casilla[1];
	var pos_i=casilla[0];
	
	//calcula la posicion limite izquierda
	var pos_lim = null;
	for(var i=pos_i, j=pos_j,contador=0; esLegal(i,j) && contador<4; i=i+way_i, j=j+way_j, contador++){
		pos_lim = [i,j]; //se guarda la ultima iteracion
	}

	return pos_lim;
}
	

function siguienteGanar(player,tablero){
	//funcion que retorna la casilla que tiene que poner para ganar en el turno
	//Si no hay casilla con la pueda ganar retorna false
	var vectores = [[1,1],[0,1],[-1,1],[1,0]]; //[diagonal izquierda],[horizontal],[diagonal derecha],[vertical]
	var casillas_disponibles = getCasillasDisponibles(tablero);
	
	for(var a=0;a<casillas_disponibles.length; a++){
		for(var b=0; b<vectores.length; b++){
			var origen = getPosicionLim(vectores[b],casillas_disponibles[a]);
			var contador_victoria = 0;
			for(var i=origen[0], j=origen[1]; esLegal(i,j) && (j<(casillas_disponibles[a][1]+4)); i+=vectores[b][0], j+=vectores[b][1]){
				
				if(getCasilla(i,j,tablero)==player){
					contador_victoria++;
				}else{
					if(i==casillas_disponibles[a][0] && j==casillas_disponibles[a][1]){
						contador_victoria++;
					}else{
						contador_victoria=0;
					}
				}
				if(contador_victoria==4){
					//gana en esta posicion
					return casillas_disponibles[a][1]+1;
				}
			}
			
		}
	}
	return false;
}
	
function siguienteBloquear(tablero){
	//funcion para bloquear si el jugador va a ganar en el siguiente movimiento
	if(ficha=="X"){
		var col = siguienteGanar("O",tablero);
		if(col!==false){
			return col;
		}
		return false;
	}
	
	if(ficha=="O"){
		
		var col = siguienteGanar("X",tablero);
		if(col!==false){
			return col;
		}
		return false;
	}
}






/*SECCION DE LAS IAS*/

function jugadorAI1(){
	//jugadorAI1 pone solo en la columna 4
	poner_fichaHTML(4);				
}


function randomAI(){
	//randomAI pone en columnas aleatorias
	var num = getRandomInt(1,8);
	while(isColfull(num)){
		num = getRandomInt(1,8);
	}
	console.log("randomAI pone aleatorio: "+ficha+" "+num);
	poner_fichaHTML(num);
}

function randomPlusAI(){
	//randomPlusAI version mejorada con algoritmos pero sigue teniendo un componente aleatorio
	var tablero_actual=getTablero_HTML();
	var var1_col=siguienteGanar(ficha,tablero_actual);
	var var2_col=siguienteBloquear(tablero_actual);
	
	if(var1_col!==false){
		console.log("randomPlusAI pone alg_col_win: "+ficha +" "+var1_col);
		poner_fichaHTML(var1_col);
	}
	else if(var2_col!==false){
		console.log("randomPlusAI pone alg_col_block: "+ficha +" "+var2_col);
		poner_fichaHTML(var2_col);
	}
	
	else{
		var num = getRandomInt(1,8);
		while(isColfull(num-1,tablero_actual)){
			num = getRandomInt(1,8);
		}
		console.log("randomPlusAI pone aleatorio: "+ficha +" "+num);
		poner_fichaHTML(num);
	}
	
}