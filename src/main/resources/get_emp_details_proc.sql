DELIMITER $$

CREATE     PROCEDURE get_emp_details()
    BEGIN
		select * from emp;
    END$$

DELIMITER ;



-- procedure with parameter
DELIMITER $$
DROP PROCEDURE IF EXISTS get_emp_by_no $$

CREATE PROCEDURE get_emp_by_no(IN emp_n bigint, OUT e_name varchar(20), OUT date_dob varchar(20), OUT salary double)
    BEGIN
		select emp_name, dob,sal into e_name,date_dob,salary from emp where emp_no = emp_n;
    END$$

DELIMITER ;


CALL get_emp_by_no(3)


-- procedure to insert into db
DELIMITER $$
DROP PROCEDURE IF EXISTS insert_emp $$
CREATE PROCEDURE insert_emp(emp_no BIGINT, emp_name VARCHAR(20), sal DOUBLE, dob VARCHAR(20))
    BEGIN
		INSERT INTO emp (emp_no, emp_name, sal, dob) VALUES(emp_no,emp_name,sal,dob);
    END$$

DELIMITER ;

CALL insert_emp(12,'Rajesh-K', 50000,'20-12-1993')



DELIMITER $$

CREATE
    FUNCTION `insert-student`(s_id VARCHAR(10),s_name VARCHAR(20),s_dob VARCHAR(20),s_cource VARCHAR(5),s_addr VARCHAR(40)) RETURNS VARCHAR(10)
    BEGIN
	 DECLARE ss_id VARCHAR(10);
        SELECT stud_id INTO ss_id FROM student;
	RETURN ss_id;
    END$$

DELIMITER ;