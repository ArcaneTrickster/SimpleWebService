
1)create a maven spring boot project with following external libraries/dependencies:-
	i)spring data JPA
	ii)spring web
	iii)MYSQL connector/driver
you will be able to see all dependencies at pom.xml

2) database communication

sql command:-

    create database sampledb;
    use sampledb

    create user 'sampledbuser'@'%' identified by 'abc';
    grant all on sampledb.* to 'sampledbuser'@'%';
    drop user sampledbuser;                             -----if neccessary----
	-----the above sql command will create a user in mysql which you have to access from your project----------------

3) associate your project with the above user by adding these code in your 'application.properties' file
/*

	spring.jpa.hibernate.ddl-auto=update
	spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/sampledb
	spring.datasource.username=sampledbuser
	spring.datasource.password=abc
	server.port=8102


*/

sql command:-

    USE sampledb;

    CREATE TABLE employee (
        eid INT(50) NOT NULL AUTO_INCREMENT,
        ename VARCHAR(200) DEFAULT NULL,
        edesig VARCHAR(200) DEFAULT NULL,
        edept VARCHAR(100) DEFAULT NULL,
        esal INT(100) DEFAULT NULL,
        PRIMARY KEY (eid)
    );

    INSERT INTO employee (eid, ename, edesig, edept, esal) VALUES (1, 'John Lark', 'Lead', 'Technology', 30000);

    INSERT INTO employee (eid, ename, edesig, edept, esal) VALUES (2, 'Natalie Atlas', 'Associate', 'Human Resource', 24000);

    INSERT INTO employee (eid, ename, edesig, edept, esal) VALUES (3, 'Daniel Brown', 'Associate', 'Technology', 27000);

    INSERT INTO employee (eid, ename, edesig, edept, esal) VALUES (4, 'Tom Hunt', 'Manager', 'Technology', 42000);

    INSERT INTO employee (eid, ename, edesig, edept, esal) VALUES (5, 'Edward Clark', 'Senior Manager', 'Human Resource', 55000);

    INSERT INTO employee (eid, ename, edesig, edept, esal) VALUES (6, 'Jason Bourne', 'Lead', 'Administration', 24000);

    SELECT * FROM employee;



----- STORED PROCEDURE QUERY #1 -----
	DELIMITER $
		CREATE PROCEDURE SpEmployeefindAll ()
			BEGIN
				SELECT * FROM employee;
			END $
	DELIMITER ;


----- STORED PROCEDURE QUERY #2 -----
	DELIMITER $
		CREATE PROCEDURE SpEmployeefindByDepartment (IN emp_department VARCHAR(200))
			BEGIN
				SELECT * FROM employee emp WHERE emp.edept = emp_department;
			END $
	DELIMITER ;


----- STORED PROCEDURE QUERY #3 -----
	DELIMITER $
		CREATE PROCEDURE SpEmployeefindCountByDesignation (IN emp_designation VARCHAR(200), OUT designation_count INT(50))
			BEGIN
				SELECT COUNT(*) INTO designation_count FROM employee emp WHERE emp.edesig = emp_designation;
			END $
	DELIMITER ;


-------------end of mysql work....see project files---------------------