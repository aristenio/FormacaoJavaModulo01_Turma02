CREATE DATABASE ESCOLA;

USE ESCOLA;

drop table aluno;

CREATE TABLE ALUNO(
	matricula bigint not null AUTO_INCREMENT primary key,
    nome varchar(255) NOT NULL,
    email varchar(100),
    telefone varchar(20),
    altura double, 
    aprovado boolean DEFAULT true
);

INSERT INTO ALUNO (nome, email, telefone, altura) VALUES ('Arthur','arthur@gmail.com', '876987', 1.80);
INSERT INTO ALUNO (nome, email, telefone, altura) VALUES ('Nivardo','nivardo@gmail.com','897687', 1.73);
INSERT INTO ALUNO (nome, email, telefone, altura) VALUES ('Nivardo','nivardo@gmail.com', '9876987', 1.66);
INSERT INTO ALUNO (nome, email, telefone, altura) VALUES ('Rafael','rafael@gmail.com', '9876987', 1.66);

SELECT * FROM Aluno ;

delete from aluno where matricula=3;

CREATE TABLE PROFESSOR(
	id bigint not null AUTO_INCREMENT primary key,
    nome varchar(255) NOT NULL,
    email varchar(100),
    telefone varchar(20)
);

INSERT INTO PROFESSOR (nome,email, telefone) values ('Aristenio','aristenio@gmail.com','87698768976');
INSERT INTO PROFESSOR (nome,email, telefone) values ('Valdo','valdo@gmail.com','87698768976');
INSERT INTO PROFESSOR (nome,email, telefone) values ('Marcelo','marcelo@gmail.com','87698768976');

select * from professor;

/*aluno U professor*/

SELECT * from Aluno, Professor;

select aluno.nome, professor.nome from aluno, professor;

select aluno.nome as aluno_nome, professor.nome as professor_nome from aluno, professor;


SELECT * FROM Aluno WHERE altura = 1.8;

SELECT * FROM Aluno WHERE altura <> 1.8;
SELECT * FROM Aluno WHERE altura != 1.8;

SELECT * FROM Aluno WHERE altura <= 1.8;
SELECT * FROM Aluno WHERE altura < 1.8;

SELECT * FROM Aluno WHERE altura >= 1.8;
SELECT * FROM Aluno WHERE altura > 1.8;

SELECT * FROM Aluno WHERE aprovado IS TRUE;
SELECT * FROM Aluno WHERE aprovado IS NOT TRUE ;
SELECT * FROM Aluno WHERE aprovado IS FALSE;

SELECT * FROM Aluno WHERE nome IS NULL ;
SELECT * FROM Aluno WHERE nome IS NOT NULL ;

SELECT * FROM Aluno WHERE altura BETWEEN 1.5 AND 1.8;

SELECT * FROM Aluno WHERE altura NOT BETWEEN 1.5 AND 1.8;
SELECT * FROM Aluno WHERE nome LIKE 'Rafael';

SELECT * FROM Aluno WHERE nome LIKE 'Rafa%';

SELECT * FROM Aluno WHERE nome LIKE '%O';
SELECT * FROM Aluno WHERE nome LIKE '%A%';

SELECT * FROM Aluno WHERE nome  NOT LIKE '%O%';

SELECT * FROM Aluno WHERE altura IN (1.5 , 1.66 , 1.7 , 1.8) ;

SELECT * FROM Aluno WHERE altura NOT IN (1.5 , 1.6 , 1.7 , 1.8) ;

SELECT * FROM Aluno WHERE NOT altura = 1.80;
SELECT * FROM Aluno WHERE !(altura = 1.80);

SELECT * FROM Aluno WHERE altura < 1.8 AND nome LIKE 'Rafael%';
SELECT * FROM Aluno WHERE altura < 1.8 && nome LIKE 'Rafael%';

SELECT * FROM Aluno WHERE altura < 1.8 OR nome LIKE 'Rafael%';
SELECT * FROM Aluno WHERE altura < 1.8 || nome LIKE 'Rafael%';

SELECT * FROM Aluno WHERE altura < 1.8 XOR nome LIKE 'Rafael %';

SELECT * FROM Aluno ORDER BY altura;

SELECT * FROM Aluno ORDER BY altura , nome;

SELECT * FROM Aluno ORDER BY altura DESC , nome ASC ;

SELECT * FROM Aluno 
WHERE aprovado IS TRUE 
ORDER BY email , altura DESC , nome ;

UPDATE escola.Aluno SET aprovado=false where matricula=2;

/*Funções de agrupamento */
select COUNT(*) as TOTAL_ALUNOS from Aluno;
select COUNT(aprovado) as ALUNOS_APROVACAO from Aluno;

select AVG(altura) from Aluno where aprovado=true;

select MAX(altura) from Aluno;
select MIN(altura) from Aluno;

select SUM(altura) from Aluno;

select aprovado,nome, count(*) from Aluno group by aprovado;
