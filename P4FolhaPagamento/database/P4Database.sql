create database P4Database;
use P4Database;

create table usuarios(
    id_usuario int primary key auto_increment, 
    usuario varchar(15) not null unique, 
    senha varchar(15) not null,
    tipo_usuario varchar(15) not null
);

create table empregados(
    id_empregado int primary key auto_increment, 
    nome varchar(50) not null, 
    endereco varchar (50) not null, 
    metodo_pagamento varchar(50) not null, 
    tipo_funcionario varchar(50) not null, 
    pertence_sindicato varchar(50) not null,
    data_pagamento varchar(50) not null
);

create table horista(
    id_horista int key primary key auto_increment, 
    hora_salario decimal (10, 2) not null, 
    salario decimal (10, 2) not null default 0, 
    id_empregado int not null unique, 
    foreign key (id_empregado) references empregados(id_empregado)
);

create table assalariado (
    id_assalariado int key primary key auto_increment, 
    salario decimal(10, 2) not null, 
    id_empregado int not null unique, 
    foreign key (id_empregado) references empregados(id_empregado)
);

create table comissionado(
    id_comissionado int key primary key auto_increment, 
    salario decimal(10, 2) not null, 
    taxa_venda int not null, 
    total_vendas decimal(10, 2) not null default 0, 
    id_empregado int not null unique, 
    foreign key (id_empregado) references empregados(id_empregado)
);

insert into usuarios(usuario, senha, tipo_usuario) values ("admin", "admin", "admin");
insert into usuarios(usuario, senha, tipo_usuario) values ("", "", "admin");
insert into usuarios(usuario, senha, tipo_usuario) values ("jeremias", "123", "user");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("Vitor", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Banco", "Assalariado", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("Lucas", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Dinheiro", "Assalariado", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("Pedro", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Banco", "Comissionado", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("João", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Banco", "Horista", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("Beatriz", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Dinheiro", "Assalariado", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("Camila", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Dinheiro", "Horista", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("Caio", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Banco", "Comissionado", "Sindicato", "1");
insert into empregados (nome, endereco, metodo_pagamento, tipo_funcionario, pertence_sindicato, data_pagamento) values ("José", "Avenida Brasil, 150, Maceió, Alagoas, Brasil", "Dinheiro", "Comissionado", "Sindicato", "1");