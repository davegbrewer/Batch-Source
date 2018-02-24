-----------------------------------------------------------------------


--TO RUN CODE, CLICK IN THE LINE WITH ';' AND PRESS CRTL+ENTER

 
-----------------------------------------------------------------------



--1. SETTING UP ORACLE CHINOOK 
--1.A) OPEN THE CHINOOK_ORACLE.SQL FILE AND EXECUTE SCRIPTS WITHIN
    --THEY BUILT A DATABASE WITH SEVERAL TABLES AND POPULATED THEM WITH DATA

--2. SQL QUERIES
--2.1 SELECT
--2.1.A) SELECT ALL RECORDS FROM EMPLOYEE TABLE.
SELECT * 
FROM EMPLOYEE;
--2.1.B) SELECT ALL RECORDS FROM THE EMPLOYEE TABLE WHERE LAST NAME IS KING.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';
--2.1.C) SELECT ALL RECORDS FROM THE EMPLOYEE TABLE WHERE FIRST NAME IS
    --ANDREW AND REPORTSTO IS NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--2.2.A) SELECT ALL ALBUMS IN ALBUM AND SORT RESULT SET IN DESCENDING
    --ORDER BY TITLE
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;
--2.2.B) SELECT FRIST NAME FROM CUSTOMER AND SORT RESULT SET IN ASCENDING
    --ORDER BY CITY
SELECT FIRSTNAME--, CITY    --REMOVE FIRST SET OF '--' IN THIS LINE TO SEE 
FROM CUSTOMER               --THAT IT DEFAULTS TO ASCENDING
ORDER BY CITY;
--2.3 INSERT INTO
--2.3.A) INSERT TWO NEW RECORDS INTO GENRE TABLE
INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'poop.genre');
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'my.genre');
--SELECT * FROM GENRE ORDER BY GENREID DESC;
--2.3.B) INSERT TWO NEW RECORDS INTO THE EMPLOYEE TABLE
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, 
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Po', 'Op', 'Janitor', 1, null, sysdate, '2 Porcelain Throne Ave S',
    'Turdsville', 'FL', 'USA', '80808', '+1 (123) 456-7890', '+1 (098) 765-4321', 'poo@smelly.pu');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, 
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Amployee', 'Mya', 'Heiress', null, null, sysdate, '1 Throne Ave S',
    'Richville', 'CA', 'USA', '90210', '+1 (111) 111-1111', null, 'daddyBuysMeStuff@spoil.me');
--SELECT * FROM EMPLOYEE ORDER BY EMPLOYEEID DESC;
-- 2.3.C) INSERT TWO NEW RECORDS INTO THE CUSTOMER TABLE
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS,
    CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Po', 'Op', 'TOILETBOWLS', '1234 STINKER LN', 'Turdsville',
    'OH', 'USA', '44646', '+1 (330) 488-1056', null, 'poo@smelly.pu', 1);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS,
    CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Gupta', 'Lalita', null, '127 N Los Roblez Ave', 'Passadena',
    'CA', 'USA', '90210', '+1 (537) 488-1056', null, 'rajIsABadDate@hotmail.com', 3);
--SELECT * FROM CUSTOMER ORDER BY CUSTOMERID DESC;
--2.4 UPDATE
--2.4.A) UPDATE AARON MITCHELL IN CUSTOMER TABLE TO ROBERT WALTER
--SELECT *FROM CUSTOMER WHERE LASTNAME ='Walter';
UPDATE CUSTOMER SET FIRSTNAME = 'Robert',LASTNAME = 'Walter' 
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
--2.4.B) UPDATE NAME OF ARTIST IN THE ARTIST TABLE 'CREEDENCE 
    --CLEARWATER REVIVAL' TO 'CCR'
--SELECT * FROM ARTIST WHERE NAME = 'Creedence Clearwater Revival';
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
--2.5.A) SELECT ALL INVOICES WITH A BILLING ADDRESS LIKE 'T%'
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
--2.6 BETWEEN
--2.6.A) SELECT ALL INVOICES THAT HAVE A TOTAL BETWEEN 15 AND 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--2.6.B) SELECT ALL EMPLOYEES HIRED BETWEEN 1ST OF JUNE 2003 AND 1 MARCH 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-MAR-03','DD-MON-YY')
AND TO_DATE('01-MAR-04', 'DD-MON-YY');
--2.7 DELETE
--2.7.A) DELETE A RECORD IN CUSTOMER WHERE THE NAME IS ROBERT WALTER
    --THERE MAY BE CONSTRAINTS THAT RELY ON THIS, FIND OUT HOW TO 
    --RESOLVE THEM. 
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--ORA-02292: integrity constraint (RYDERJ.FK_INVOICECUSTOMERID) violated 
--  - child record found
--DELETE CHILD RECORD. 
SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Robert';
--CUSTOMERID IS 32
--CUSTOMERID IS FK TO INVOICE
DELETE FROM INVOICE WHERE CUSTOMERID = 32;
--ANOTHER CONSTRAINT... INVOICELINEINVOICEID
SELECT * FROM INVOICE WHERE CUSTOMERID = 32;
--FROM INVOICELINE DELETE WHERE INVOICEID = 116.245.268.290.342.50,61;
DELETE FROM INVOICELINE WHERE INVOICEID = 116;
DELETE FROM INVOICELINE WHERE INVOICEID = 245;
DELETE FROM INVOICELINE WHERE INVOICEID = 268;
DELETE FROM INVOICELINE WHERE INVOICEID = 290;
DELETE FROM INVOICELINE WHERE INVOICEID = 342;
DELETE FROM INVOICELINE WHERE INVOICEID = 50;
DELETE FROM INVOICELINE WHERE INVOICEID = 61;
--NOW DELETE FROM INVOICE
DELETE FROM INVOICE WHERE CUSTOMERID = 32;
--NOW DELETE FROM CUSTOMER
DELETE FROM CUSTOMER WHERE  FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
-- DONE
--YOU CAN ALSO SET THE TABLE TO CASCADE ON DELETE, BUT I DIDNT WANT TO 
--CHANGE HOW THE DB WAS SET UP.
--YOU CAN ALSO REMOVE THE CONSTRAINT... BUT THIS CAN BE DANGEROUS 
    --BECAUSE YOU CAN LOSE VALUABLE RELATIONSHIP INFORMATION

--3 SQL FUNCTIONS
commit; --end of tuesday night work.
--3.1 SYSTEM DEFINED FUNCTIONS
--3.1.A) Create a function that returns current time. 
SELECT CURRENT_TIMESTAMP FROM DUAL;
--3.1.B) CREATE A FUNCTION THAT RETURNS THE LENGTH OF NAME IN MEDIATYPE TABLE
SELECT LENGTHB(NAME) FROM MEDIATYPE;
--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
--3.2.A) CREATE A FUNCTION THAT RETURNS THE AVERAGE TOTAL OF ALL INVOICES
SELECT AVG(TOTAL) FROM INVOICE;
--3.2.B) CREATE A FUNCTION THAT RETURNS THE MOST EXPENSIVE TRACK
SELECT MAX(UNITPRICE) FROM TRACK;
--3.3 USER DEFINED SCALAR FUNCTIONS
--3.3.A) CREATE A FUNCTION THAT RETURNS THE AVERAGE PRICE OF 
--          INVOICELINE ITEMS IN INVOICELINE TABLE
CREATE OR REPLACE FUNCTION AVGINVOICELINE
RETURN NUMBER AS AVERAGE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
    RETURN AVERAGE;
END;
/
SELECT AVGINVOICELINE FROM DUAL;
--3.4 USER DEFINED TABLE VALUED FUNCTIONS
SELECT * FROM EMPLOYEE;
--3.4.A) CREATE A FUNCTION THAT RETURNS ALL EMPLOYEES WHO WERE BORN AFTER 1968
CREATE OR REPLACE FUNCTION EMPAFTER1968
RETURN TABLE;
BEGIN
RETURN 
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-68';
END;
/
/--DOESNT WORK

--4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURE
--4.1.A) CREATE A STORED PROCEDURE THAT SELECTS FIRST AND LAST SAME OF ALL EMPLOYEES
CREATE OR REPLACE PROCEDURE NAMEEMP AS
BEGIN
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE INTO NAMEEMP;
END;
/





--7.0) JOINS
--7.1 INNER
--7.1.A) CREATE AN INNER JOIN THAT JOINS CUSTOMER AND ORDERS AND SPECIFIES 
--             NAME OF CUSTOMER AND INVOICEID
SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID 
ORDER BY CUSTOMER.LASTNAME;
--7.2) OUTER
--7.2.A) CREATE AN OUTER JOIN THAT JOINS CUSTOMER AND INVOICE TABLE SPECIFYING
--          THE CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, AND TOTAL
SELECT CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY LASTNAME;
--7.3) RIGHT 
--7.3.A) CREATE A RIGHT JOIN THAT JOINS ALBUM AND ARTIST SPECIFYING ARTIST NAME AND TITLE
SELECT NAME, TITLE
FROM ALBUM RIGHT JOIN ARTIST ON ARTIST.ARTISTID = ALBUM.ALBUMID
ORDER BY NAME;
--7.4) CROSS
--7.4.A) CREATE A CROSS JOIN THAT JOINS ARTIST AND ALBUM AND 
--          SORTS BY ARTIST NAME IN ASCENDING ORDER
SELECT *
FROM ALBUM CROSS JOIN ARTIST --ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY NAME;
--7.5) SELF
--7.5.A) PERFORM A SELF JOIN ON THE EMPLOYEE TABLE JOINING ON THE REPORTSTO COLUMN
SELECT * 
FROM EMPLOYEE A, EMPLOYEE B WHERE A.REPORTSTO = B.REPORTSTO;










