//CEMENTERIO DE FUNCIONES
function siguienteGanar(player){
	var contador=0;
		
	//comprobar horizontales
	for(var i=6;i>0;i--){//filas
		for(var j=1;j<8;j++){//columnas
		
			if($( "tr.fil"+i ).children("td.col"+j).text()==player){
				contador++;
	
					if(j<7 && contador==3 && estaLibre(i,j+1)){//derecha
						return j+1;
					}
					if(j>3 && contador==3 && estaLibre(i,j-3)){//izquierda
						return j-3;
					}
					
			}else{contador=0;}
		
		}
		contador=0;
	}
	
	//comprobar verticales
	for(var j=1;j<8;j++){//columnas
		for(var i=6;i>0;i--){//filas
		
			if($( "tr.fil"+i ).children("td.col"+j).text()==player){
				contador++;
	
				if(i>1 && contador==3 && estaLibre(i-1,j)){
					return j;
				}
			}else{contador=0;}
				
		}
		contador=0;
	}
	//comprobar diagonales
	
	//diagonales derechas ascendentes
	for(var dh=0; dh<6; dh++){//diagonales de altura
	
		for(var i=6-dh,j=1; i>0,j<8; i--,j++){
			if($( "tr.fil"+i ).children("td.col"+j).text()==player){
				contador++;
				
				if(i>1 && j<7 && contador==3 && estaLibre(i-1,j+1)){
					return j+1;
				}
				if(i<4 && j>3 && contador==3 && estaLibre(i+3,j-3)){
					return j+3;
				}
			}else{contador=0;}	
			
		}
		contador=0;
	}
	for(var dx=0; dx<6; dx++){//diagonales de horizontal
	
		for(var i=6,j=1+dx; i>0,j<8; i--,j++){
			if($( "tr.fil"+i ).children("td.col"+j).text()==player){
				contador++;
				
				if(i>1 && j<7 && contador==3 && estaLibre(i-1,j+1)){
					return j+1;
				}
				if(i<4 && j>3 && contador==3 && estaLibre(i+3,j-3)){
					return j+3;
				}
			}else{contador=0;}
			
		}
		contador=0;
	}
	//diagonales izquierdas ascendentes
	for(var dh=0; dh<6; dh++){//diagonales de altura
	
		for(var i=6-dh,j=7; i>0,j>0; i--,j--){
			if($( "tr.fil"+i ).children("td.col"+j).text()==player){
				contador++;
				
				if(i>1 && j>1 && contador==3 && estaLibre(i-1,j-1)){
					return j-1;
				}
				if(i<4 && j<5 && contador==3 && estaLibre(i+3,j+3)){
					return j+3;
				}
			}else{contador=0;}
			
		}
		contador=0;
	}
	for(var dx=0; dx<6; dx++){//diagonales de horizontal
	
		for(var i=6,j=7-dx; i>0,j>0; i--,j--){
			if($( "tr.fil"+i ).children("td.col"+j).text()==player){
				contador++;
			
				if(i>1 && j>1 && contador==3 && estaLibre(i-1,j-1)){
					return j-1;
				}
				if(i<4 && j<5 && contador==3 && estaLibre(i+3,j+3)){
					return j+3;
				}
			}else{contador=0;}
			
			
		}
		contador=0;
	}
	return false;
}