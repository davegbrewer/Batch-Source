DROP TRIGGER ERS_REIMBURSEMENTS_TRG;
DROP SEQUENCE ERS_REIMBURSEMENTS_SEQ; 
DROP TABLE ERS_REIMBURSEMENTS;
DROP TRIGGER ERS_USERS_TRG;
DROP SEQUENCE ERS_USERS_SEQ;
DROP TABLE ERS_USERS ;
DROP TABLE ERS_USER_ROLES ;
DROP TABLE ERS_REIMBURSEMENT_STATUS;
DROP TABLE ERS_REIMBURSEMENT_TYPE;

CREATE TABLE ERS_USER_ROLES 
(
  UR_ID NUMBER NOT NULL 
, UR_ROLE VARCHAR2(40) NOT NULL UNIQUE
, CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY 
  (
    UR_ID 
  )
  ENABLE 
);
/
CREATE TABLE ERS_REIMBURSEMENT_STATUS
(
  RS_ID NUMBER
, RS_STATUS VARCHAR2(30)
, CONSTRAINT ERS_REIMBURSEMENT_STATUS_PK PRIMARY KEY
  (
    RS_ID
  )
  ENABLE
);
/
CREATE TABLE ERS_REIMBURSEMENT_TYPE
(
  RT_ID NUMBER
, RT_TYPE VARCHAR2(30)
, CONSTRAINT ERS_REIMBURSEMENT_TYPE_PK PRIMARY KEY
  (
    RT_ID
  )
  ENABLE
);
/
CREATE TABLE ERS_USERS 
(
  U_ID NUMBER NOT NULL 
, U_USERNAME VARCHAR2(40) NOT NULL UNIQUE
, U_PASSWORD VARCHAR2(40) NOT NULL
, U_FIRSTNAME VARCHAR2(30) NOT NULL
, U_LASTNAME VARCHAR2(30) NOT NULL
, U_EMAIL VARCHAR2(100) NOT NULL UNIQUE
, UR_ID NUMBER NOT NULL 
, CONSTRAINT ERS_USERS_PK PRIMARY KEY 
  (
    U_ID 
  )
  ENABLE 
,CONSTRAINT ERS_USERS_USER_ROLES_FK1 FOREIGN KEY
(
  UR_ID 
)
REFERENCES ERS_USER_ROLES
(
  UR_ID 
)
ENABLE
);
/
CREATE SEQUENCE ERS_USERS_SEQ;
/
CREATE OR REPLACE TRIGGER ERS_USERS_TRG 
BEFORE INSERT ON ERS_USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.UR_ID IS NULL THEN
      SELECT ERS_USERS_SEQ.NEXTVAL INTO :NEW.UR_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
CREATE TABLE ERS_REIMBURSEMENTS 
(
  R_ID NUMBER NOT NULL 
, R_AMOUNT NUMBER(22,2) NOT NULL 
, R_DESCRIPTION VARCHAR2(100) 
, R_RECEIPT BLOB
, R_SUBMITTED TIMESTAMP NOT NULL 
, R_RESOLVED TIMESTAMP 
, U_ID_AUTHOR NUMBER NOT NULL 
, U_ID_RESOLVER NUMBER 
, RT_TYPE NUMBER 
, RT_STATUS NUMBER 
, CONSTRAINT ERS_REIMBURSEMENTS_PK PRIMARY KEY 
  (
    R_ID 
  )
  ENABLE 
, CONSTRAINT ERS_REIMBURSEMENTS_AUTHOR_FK FOREIGN KEY
  (
    U_ID_AUTHOR
  )
  REFERENCES ERS_USERS
  (
    U_ID
  )
  ENABLE
, CONSTRAINT ERS_REIMBURSEMENTS_RESOLVER_FK FOREIGN KEY
  (
    U_ID_RESOLVER
  )
  REFERENCES ERS_USERS
  (
    U_ID
  )
  ENABLE
, CONSTRAINT ERS_REIMBURSEMENTS_RT_TYPE_FK FOREIGN KEY
  (
    RT_TYPE
  )
  REFERENCES ERS_REIMBURSEMENT_TYPE
  (
    RT_ID
  )
  ENABLE
, CONSTRAINT ERS_REIMBURSEMENTS_RS_TYPE_FK FOREIGN KEY
  (
    RT_STATUS
  )
  REFERENCES ERS_REIMBURSEMENT_STATUS
  (
    RS_ID
  )
 ENABLE
);
/
CREATE SEQUENCE ERS_REIMBURSEMENTS_SEQ; /
CREATE OR REPLACE TRIGGER ERS_REIMBURSEMENTS_TRG 
BEFORE INSERT ON ERS_REIMBURSEMENTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.R_ID IS NULL THEN
      SELECT ERS_REIMBURSEMENTS_SEQ.NEXTVAL INTO :NEW.R_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/