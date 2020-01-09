create database BancoP4;
use BancoP4;

create table tbcontest(
iduser int primary key auto_increment,
usuario varchar(50) not null,
login varchar(15) not null unique,
senha varchar(15)
);

insert into tbcontest(usuario,login,senha)
values("Adm","adm","123456");

describe tbContest;
select *from tbcontest;

create table tbempregado(
idempregado int primary key auto_increment,
nome varchar(50) not null,
endereco varchar (50) not null, 
metodo_pagamento varchar(50) not null,
tipo_funcionario varchar(50) not null,
pertence_sindicato tinyint(1) not null
);

insert into tbempregado(nome,endereco,metodo_pagamento,tipo_funcionario,pertence_sindicato)
values("Jeremias","viçosa","correio","horista",0);

select * from tbempregado;

create table tbhorista(
	idhorista int key primary key auto_increment,
    hora_salario decimal (10,2) not null,
    hora decimal(10,2),
    idempregado int not null unique,
    foreign key (idempregado) references tbempregado(idempregado)
);

insert into tbhorista(hora_salario,hora,idempregado)
values(15.0,8.0,1);

select * from tbhorista;

create table tbassalariado (
	idassalariado int key primary key auto_increment,
    salario decimal(10,2) not null,
    idempregado int not null unique,
    foreign key (idempregado) references tbempregado(idempregado)
);

insert into tbassalariado(salario,idempregado)
values(800.00,1);

select * from tbassalariado;
delete from tbassalariado where idassalariado = 1;
 
create table tbcomissionado(
	idcomissionado int key primary key auto_increment,
    salario decimal(10,2) not null,
    taxa_venda decimal(10,2) not null,
    total_vendas decimal(10,2) not null,
    idempregado int not null unique,
    foreign key (idempregado) references tbempregado(idempregado)
);

insert into tbcomissionado(salario,taxa_venda,total_vendas,idempregado)
values(800.00,20.5,0.0,1);

select * from tbcomissionado;