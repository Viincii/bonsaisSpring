drop schema if exists bonsaisSpring cascade;
CREATE SCHEMA bonsaisSpring;
set search_path= bonsaisSpring;
drop table if exists bonsaisSpring.bonsai;
CREATE table bonsaisSpring.bonsai(id uuid, name varchar, species varchar, acquisition_date varchar, acquisition_age int, status varchar);