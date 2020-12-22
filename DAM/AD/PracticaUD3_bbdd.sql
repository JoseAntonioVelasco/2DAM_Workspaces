CREATE DATABASE emp_software;

USE emp_software;

CREATE TABLE Empleados(
	id INTEGER PRIMARY KEY,
	DNI CHAR(9) NOT NULL,
	nombre CHAR(20) NOT NULL,
	apellidos CHAR(30) NOT NULL,
	telefono INTEGER NOT NULL
);
CREATE TABLE Proyectos(
	id INTEGER PRIMARY KEY,
	nombre CHAR(20) NOT NULL,
	duracion INTEGER NOT NULL,
	fech_in DATE NOT NULL,
	fech_fin DATE
);
CREATE TABLE empleado_proyecto(
	id_empleado INTEGER NOT NULL,
	id_proyecto INTEGER NOT NULL,
	FOREIGN KEY (id_empleado) REFERENCES Empleados(id),
	FOREIGN KEY (id_proyecto) REFERENCES Proyectos(id)
);
CREATE TABLE Tareas(
	id INTEGER PRIMARY KEY,
	id_proyecto INTEGER NOT NULL,
	nombre CHAR(20) NOT NULL,
	estado VARCHAR(20) CHECK(estado='planificado' or estado='empezado' or estado='finalizado'),
	horas INTEGER NOT NULL,
	FOREIGN KEY (id_proyecto) REFERENCES Proyectos(id)
);
CREATE TABLE empleado_tarea(
	id_empleado INTEGER,
	id_tarea INTEGER NOT NULL,
	FOREIGN KEY (id_empleado) REFERENCES Empleados(id),
	FOREIGN KEY (id_tarea) REFERENCES Tareas(id)
);