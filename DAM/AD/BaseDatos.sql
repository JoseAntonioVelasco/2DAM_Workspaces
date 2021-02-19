CREATE DATABASE universo;

USE universo;

CREATE TABLE planeta(
	nombre VARCHAR(20) PRIMARY KEY,
	masa REAL NOT NULL,
	volumen REAL NOT NULL,
	nombre_sistema VARCHAR(20),
	FOREIGN KEY (nombre_sistema) REFERENCES sistema(nombre)
);

CREATE TABLE sistema(
	nombre VARCHAR(20) PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
	masa REAL NOT NULL,
	nombre_galaxia VARCHAR(20),
	FOREIGN KEY (nombre_galaxia) REFERENCES galaxia(nombre)
);

CREATE TABLE galaxia(
	nombre VARCHAR(20) PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
	masa REAL NOT NULL,
	nombre_cumulo VARCHAR(20),
	FOREIGN KEY (nombre_cumulo) REFERENCES cumulo(nombre)
);

CREATE TABLE cumulo(
	nombre VARCHAR(20) PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
);


INSERT INTO planeta(nombre,masa,volumen,nombre_sistema) VALUES
('Mercurio','200','150','Sistema solar'),
('Venus','300','433','Sistema solar'),
('Tierra','500','500','Sistema solar'),
('Marte','400','423','Sistema solar');
INSERT INTO sistema(nombre,tipo,masa,nombre_galaxia) VALUES
('Sistema solar','estelar','1989.30','Via Lactea');
INSERT INTO galaxia(nombre,tipo,masa,nombre_cumulo) VALUES
('Via Lactea','espiral barrada','3000','Grupo Local');
INSERT INTO cumulo(nombre,tipo) VALUES
('Grupo Local','');