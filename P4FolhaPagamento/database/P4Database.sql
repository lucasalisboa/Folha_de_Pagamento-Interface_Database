#create database P4Database;
use P4Database;

create table usuarios(
	id_usuario int primary key auto_increment, 
	usuario varchar(15) not null unique, 
	senha varchar(15) not null,
    tipo_usuario varchar(15) not null
);

describe usuarios;
select * from usuarios;

insert into usuarios(usuario, senha, tipo_usuario) values ("admin", "admin", "admin");
insert into usuarios(usuario, senha, tipo_usuario) values ("", "", "admin");
insert into usuarios(usuario, senha, tipo_usuario) values ("jeremias", "123", "user");

create table empregados(
	id_empregado int primary key auto_increment, 
	nome varchar(50) not null, 
	endereco varchar (50) not null, 
	metodo_pagamento varchar(50) not null, 
	tipo_funcionario varchar(50) not null, 
	pertence_sindicato varchar(50) not null
);
DELETE FROM empregados WHERE id_empregado = 6;
select max(id_empregado) from empregados;
select * from empregados;
describe empregados;

create table horistas(
	id_horista int key primary key auto_increment, 
	hora_salario decimal (10, 2) not null, 
	hora decimal(10, 2), 
	id_empregado int not null unique, 
	foreign key (id_empregado) references empregados(id_empregado)
);
select * from assalariados;
create table assalariados (
	id_assalariado int key primary key auto_increment, 
	salario decimal(10, 2) not null, 
	id_empregado int not null unique, 
	foreign key (id_empregado) references empregados(id_empregado)
);

create table comissionados(
	id_comissionado int key primary key auto_increment, 
	salario decimal(10, 2) not null, 
	taxa_venda decimal(10, 2) not null, 
	total_vendas decimal(10, 2) not null, 
	id_empregado int not null unique, 
	foreign key (id_empregado) references empregados(id_empregado)
);