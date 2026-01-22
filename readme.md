# Employee Data Fetch by Filters (JDBC + MySQL)

This project is a **Java JDBC console application** that fetches employee records from a MySQL database using **dynamic filters**.  
All filters are **optional** — if the user does not want to apply a filter, they can simply **press Enter**.

---

## 📌 Features
- Fetch employee data using JDBC
- Apply filters dynamically
- Skip any filter by pressing Enter
- Uses `PreparedStatement` (SQL Injection safe)
- Clean tabular output in console

---

## 🛠 Technologies Used
- Java (JDBC)
- MySQL
- Eclipse IDE

---

## ⚙️ Database Configuration

Update the database credentials in `EmpTable.java`:

```java
public static final String DB_URL  = "jdbc:mysql://localhost:3306/advjava";
public static final String DB_USER = "ANSHU";
public static final String DB_PASS = "anshu";
```
## 🧱 Database Setup
```
CREATE DATABASE advjava;
USE advjava;
CREATE TABLE EMP (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(20) NOT NULL,
    GENDER CHAR(1) CHECK (GENDER IN ('M','F','O')),
    DEPT VARCHAR(20),
    SAL DOUBLE(8,2) CHECK (SAL > 0),
    LOC VARCHAR(20)
);
```
## 📥 Insert Sample Data (50 Records)
```
INSERT INTO EMP (NAME, GENDER, DEPT, SAL, LOC) VALUES
('anshu','M','developer',98944.43,'hyd'),
('ankush','M','tester',8634.43,'bpl'),
('rahul','M','developer',15000.00,'delhi'),
('priya','F','hr',12000.50,'mumbai'),
('neha','F','tester',9800.75,'pune'),
('rohit','M','support',8500.00,'indore'),
('kiran','O','admin',11000.00,'bhopal'),
('amit','M','developer',20000.00,'bangalore'),
('sunita','F','hr',13000.25,'kolkata'),
('ravi','M','tester',9000.00,'pune'),
('pooja','F','developer',18000.00,'delhi'),
('manoj','M','support',8700.00,'indore'),
('sneha','F','tester',9200.00,'bpl'),
('vikas','M','developer',21000.00,'hyd'),
('deepa','F','hr',12500.00,'mumbai'),
('arjun','M','admin',11500.00,'jaipur'),
('komal','F','tester',9700.00,'pune'),
('sahil','M','developer',19500.00,'bangalore'),
('ritu','F','support',8800.00,'bhopal'),
('nilesh','M','tester',9400.00,'indore'),
('alok','M','developer',20500.00,'hyd'),
('meena','F','hr',13500.00,'jaipur'),
('karan','M','support',8600.00,'bpl'),
('payal','F','tester',9600.00,'pune'),
('yash','M','developer',22000.00,'bangalore'),
('monika','F','hr',14000.00,'delhi'),
('ajay','M','tester',9100.00,'indore'),
('rekha','F','admin',11800.00,'bhopal'),
('suresh','M','support',8900.00,'pune'),
('tina','F','tester',9300.00,'kolkata'),
('varun','M','developer',23000.00,'hyd'),
('kavita','F','hr',14500.00,'mumbai'),
('naveen','M','support',9000.00,'bpl'),
('shweta','F','tester',9500.00,'pune'),
('mohit','M','developer',21500.00,'bangalore'),
('sonal','F','hr',15000.00,'jaipur'),
('ramesh','M','admin',12000.00,'indore'),
('jyoti','F','tester',9800.00,'pune'),
('akash','M','developer',22500.00,'hyd'),
('preeti','F','hr',15500.00,'delhi'),
('vinod','M','support',9100.00,'bhopal'),
('neeraj','M','developer',24000.00,'bangalore'),
('swati','F','tester',9900.00,'pune'),
('harish','M','admin',12500.00,'indore'),
('seema','F','hr',16000.00,'mumbai'),
('amitabh','M','developer',25000.00,'hyd'),
('radha','F','tester',10000.00,'kolkata'),
('sanjay','M','support',9200.00,'bpl'),
('meenakshi','F','hr',16500.00,'jaipur');
```
Enter id:
Enter name: neha
Enter gender(M\F\O):
Enter department name:
Enter salary range from 0 to:
Enter location: pune
