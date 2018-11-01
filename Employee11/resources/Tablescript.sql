CREATE TABLE Customer(customer_id NUMBER PRIMARY KEY,customer_name VARCHAR2(20),phone VARCHAR2(10), age NUMBER,productInterested VARCHAR2(20),regDate DATE);
CREATE SEQUENCE customer_Id_sequence
START WITH 1000;