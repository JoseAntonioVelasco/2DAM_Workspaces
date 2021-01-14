CREATE DATABASE emp_software;

USE emp_software;

CREATE TABLE Empleado(
	DNI CHAR(9) NOT NULL PRIMARY KEY,
	nombre CHAR(20) NOT NULL,
	apellidos CHAR(30) NOT NULL,
	telefono CHAR(30) NOT NULL
);
CREATE TABLE Proyecto(
	nombre CHAR(20) NOT NULL PRIMARY KEY,
	duracion INTEGER NOT NULL,
	fech_in DATE NOT NULL,
	fech_fin DATE
);
CREATE TABLE empleado_proyecto(
	nombre_proyecto CHAR(20) NOT NULL,
	DNI_empleado CHAR(9) NOT NULL,
    
    PRIMARY KEY(nombre_proyecto,DNI_empleado),
	FOREIGN KEY (DNI_empleado) REFERENCES Empleado(DNI),
	FOREIGN KEY (nombre_proyecto) REFERENCES Proyecto(nombre)
	
);
CREATE TABLE Tarea(
	nombre CHAR(200) NOT NULL,
    nombre_proyecto CHAR(20) NOT NULL,
	estado VARCHAR(20) CHECK(estado='planificado' or estado='empezado' or estado='finalizado'),
	horas INTEGER NOT NULL,
    PRIMARY KEY(nombre_proyecto,nombre),
	FOREIGN KEY (nombre_proyecto) REFERENCES Proyecto(nombre)
    
);
CREATE TABLE empleado_tarea(
	DNI_empleado CHAR(9) NOT NULL,
	nombre_tarea CHAR(200) NOT NULL,
    nombre_proyecto_tarea CHAR(20) NOT NULL,
    
    PRIMARY KEY(DNI_empleado,nombre_tarea,nombre_proyecto_tarea),
	FOREIGN KEY (DNI_empleado) REFERENCES Empleado(DNI),
    FOREIGN KEY (nombre_proyecto_tarea, nombre_tarea) REFERENCES Tarea(nombre_proyecto, nombre)
);;
