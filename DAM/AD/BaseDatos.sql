CREATE DATABASE universo;

USE universo;

CREATE TABLE planeta(
	nombre VARCHAR(20) PRIMARY KEY,
	masa REAL NOT NULL,
	volumen REAL NOT NULL,
	nombre_sistema VARCHAR(20),
	
);

CREATE TABLE sistema(
	nombre VARCHAR(20) PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
	masa REAL NOT NULL,
	nombre_galaxia VARCHAR(20),
);

CREATE TABLE galaxia(
	nombre VARCHAR(20) PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
	masa REAL NOT NULL,
	nombre_cumulo VARCHAR(20),
	
);

CREATE TABLE cumulo(
	nombre VARCHAR(20) PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
);
