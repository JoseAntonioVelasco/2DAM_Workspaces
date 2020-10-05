--crear funcion 
CREATE OR REPLACE FUNCTION mostrarFac(Integer) RETURNS VOID AS $$
DECLARE
	num1 integer:=1;
	num2 integer:=1; 
BEGIN
	WHILE num1<=10 LOOP
		RAISE NOTICE 'Tabla de multiplicar del %',num1;
		WHILE num2<=10 LOOP
			RAISE NOTICE '%x%= %',num1,num2,num1*num2;
			num2=num2+1;
		END LOOP;
		num1=num1+1;
		num2=1;
	END LOOP;
END;
$$LANGUAGE plpgsql
--llamar funcion
SELECT * FROM mostrarFac(44);