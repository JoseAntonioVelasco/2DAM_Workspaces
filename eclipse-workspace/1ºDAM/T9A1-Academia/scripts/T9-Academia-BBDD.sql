CREATE TABLE persona (
	DNI VARCHAR (9),
	nombre VARCHAR (45),
	apellido1 VARCHAR (45),
	apellido2 VARCHAR (45),
	CONSTRAINT pk_usuario PRIMARY KEY (DNI)
);

CREATE TABLE usuario (
	nombre VARCHAR (45),
	password VARCHAR (40),
	rol INT,
	persona_DNI VARCHAR (9),
	CONSTRAINT pk_usuario PRIMARY KEY (nombre),
	CONSTRAINT fk_persona_DNI FOREIGN KEY (persona_DNI)
		REFERENCES persona (DNI)
		ON DELETE RESTRICT ON UPDATE CASCADE 
);

CREATE TABLE profesor (
	DNI VARCHAR (9),
	telefono VARCHAR (11),
	NSS VARCHAR (12),
	entidad VARCHAR (4),
	oficina VARCHAR (4),
	control VARCHAR (2),
	cuenta VARCHAR (10),
	CONSTRAINT pk_profesor PRIMARY KEY (DNI),
	CONSTRAINT fk_profesor FOREIGN KEY (DNI)
		REFERENCES persona (DNI)
	ON DELETE RESTRICT ON UPDATE CASCADE 
);

CREATE TABLE contrato (
	num INT,
	FInicio DATE,
	FFin DATE,
	tipo VARCHAR (10),
	descripcion VARCHAR (100),
	profesor VARCHAR (9),
	CONSTRAINT pk_contrato PRIMARY KEY (num),
	CONSTRAINT fk_contrato FOREIGN KEY (profesor)
		REFERENCES profesor (DNI)
	ON DELETE RESTRICT ON UPDATE CASCADE 
);

CREATE TABLE curso (
	numero INT,
	titulo VARCHAR(45),
	horas INT,
	precio DECIMAL,
	profesor VARCHAR (9),
	CONSTRAINT pk_curso PRIMARY KEY (numero),
	CONSTRAINT fk_curso FOREIGN KEY (profesor)
		REFERENCES profesor (DNI)
	ON DELETE RESTRICT ON UPDATE CASCADE 
);

CREATE TABLE matricula (
	alumno VARCHAR (9),
	curso INT,
	nota DECIMAL,
	CONSTRAINT pk_matricula PRIMARY KEY (alumno, curso),
	CONSTRAINT fk_m_alumno FOREIGN KEY (alumno)
		REFERENCES persona (DNI),
	CONSTRAINT fk_m_curso FOREIGN KEY (curso)
		REFERENCES curso (numero)
	ON DELETE RESTRICT ON UPDATE CASCADE 
);
