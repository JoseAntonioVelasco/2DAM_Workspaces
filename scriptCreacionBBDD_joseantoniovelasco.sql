CREATE DATABASE empresa;
USE empresa;

CREATE TABLE proyecto(
	id_proy INTEGER PRIMARY KEY,
	f_inicio DATE NOT NULL,
	f_fin DATE NOT NULL,
	nom_proy VARCHAR(20) NOT NULL
);
CREATE TABLE sede(
	id_sede INTEGER PRIMARY KEY,
	nom_sede VARCHAR(20) not null
);
CREATE TABLE departamento(
	id_depto INTEGER PRIMARY KEY,
	nom_depto VARCHAR(20) not null,
	id_sede INTEGER not null,
	FOREIGN KEY (id_sede) REFERENCES sede(id_sede)
);
CREATE TABLE empleado(
	dni VARCHAR(9) PRIMARY KEY,
	nom_emp VARCHAR(40) NOT NULL,
	id_depto INTEGER NOT NULL,
	FOREIGN KEY (id_depto) REFERENCES departamento(id_depto)
);
CREATE TABLE empleado_datos_prof(
	dni VARCHAR(9) PRIMARY KEY,
	categoria VARCHAR(2) NOT NULL,
	sueldo_bruto_anual DECIMAL(8,2) NOT NULL,
	FOREIGN KEY (dni) REFERENCES empleado(dni)
);

CREATE TABLE proyecto_sede(
	id_proy INTEGER not null,
	id_sede INTEGER not null,
	f_inicio DATE not null,
	f_fin DATE not null,
	FOREIGN KEY (id_proy) REFERENCES proyecto(id_proy),
	FOREIGN KEY (id_sede) REFERENCES sede(id_sede)
);


