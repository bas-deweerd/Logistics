BEGIN WORK;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS usertype CASCADE;
DROP TABLE IF EXISTS product_info CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS location CASCADE;
DROP TABLE IF EXISTS truck CASCADE;
DROP TABLE IF EXISTS trailer CASCADE;


CREATE TABLE Users(
id  SERIAL PRIMARY KEY,
username VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
usertype int not null  
);

CREATE TABLE usertype(
id INTEGER PRIMARY KEY,
userstring VARCHAR(255) NOT NULL
);

CREATE TABLE product_info(
pr_name VARCHAR(255) PRIMARY KEY,
pricepert INTEGER NOT NULL
);

CREATE TABLE customer(
id  SERIAL PRIMARY KEY,
name VARCHAR(30),
phone_nr VARCHAR(30),
email VARCHAR(50),
location_nr INTEGER
);

CREATE TABLE location(
id  SERIAL PRIMARY KEY,
company_name VARCHAR(50),
adress VARCHAR(30),
city VARCHAR(30),
country VARCHAR(30),
amount INTEGER
);

CREATE TABLE truck(
truck_nr  SERIAL PRIMARY KEY,
brand VARCHAR(30) NOT NULL,
model VARCHAR(30) NOT NULL,
buildyear int not null,
licenseplate  varchar(15) not null unique,
towing_cap int not null
);

CREATE TABLE trailer(
trailer_nr  SERIAL PRIMARY KEY,
licenseplate  varchar(15) not null unique,
loading_cap int not null
);

CREATE TABLE orders(
id SERIAL PRIMARY KEY,
customer_name VARCHAR(50) not null,
product VARCHAR(50) not null,
amount int not null
);

ALTER TABLE users
ADD CONSTRAINT "foreign_key_user_type" FOREIGN KEY (usertype) REFERENCES usertype (id);

ALTER TABLE usertype
ADD CHECK (userstring IN('BUSINESS_SUPPORT','CEO','ORDER_INVOICE','PLANNING','TRUCKDRIVER'));

INSERT INTO usertype VALUES (1,'BUSINESS_SUPPORT');
INSERT INTO usertype VALUES (2,'CEO');
INSERT INTO usertype VALUES (3,'TRUCKDRIVER');
INSERT INTO usertype VALUES (4,'ORDER_INVOICE');
INSERT INTO usertype VALUES (5,'PLANNING');


/* TEST DATA
-- users
INSERT INTO users(username,password,usertype) VALUES ('bob beton','engrish',1); -- solid data works
select * from users;
INSERT INTO users(username,password,usertype) VALUES ('bob gbeton','engrish',99); -- There is no such usertype. violates check constraint
-- usertype
INSERT INTO usertype VALUES (99,'BUSINESS_SUPPORT');

*/

COMMIT;