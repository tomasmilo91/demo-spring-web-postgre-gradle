CREATE SEQUENCE person_id_seq;

CREATE TABLE person(
id int8 not null default nextval('person_id_seq'),
age int4, email varchar(255),
name varchar(255) not null,
person_type int4, salary int4 not null,
telephone varchar(255), primary key (id)
);