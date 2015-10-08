/* Criando a base de dados*/
CREATE DATABASE banco;

/* Removendo a base de dados*/
/*DROP DATABASE banco;*/

/*Selecionando qual database vou utilizar */
USE banco;

/* Criando uma table*/
CREATE TABLE banco.cliente(
	cpf INT,
    nome VARCHAR(100)
);

/* Removendo uma table*/
/* DROP TABLE banco.cliente; */


/* Alterando uma table*/
ALTER TABLE banco.cliente RENAME banco.clientes;
ALTER TABLE banco.clientes ADD dt_nasc DATE;
ALTER TABLE banco.clientes DROP COLUMN dt_nasc;
ALTER TABLE banco.clientes ADD data_nascimento DATE;
ALTER TABLE banco.clientes DROP cpf;
ALTER TABLE banco.clientes ADD cpf BIGINT;

