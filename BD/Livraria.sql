CREATE DATABASE livraria ;

USE livraria;

CREATE TABLE livraria.Livro (
titulo VARCHAR (255) ,
preco DOUBLE
);

ALTER TABLE Livro RENAME livros ;

ALTER TABLE livros ADD pagnas INTEGER ;

INSERT INTO livros (titulo ,preco) VALUES ( 'Java' , 98.75);

SELECT * FROM livros ;

UPDATE livros SET preco = 115.9, paginas = 100 WHERE titulo = 'Java';

DROP table livro;

CREATE TABLE livraria.Livro (
titulo VARCHAR (255)  NOT NULL UNIQUE ,
preco DOUBLE  NOT NULL
);

INSERT INTO Livro (titulo, preco) VALUES ( 'Java' , 98.75);
INSERT INTO Livro (titulo, preco) VALUES ( NULL , 98.75);

SELECT * FROM livro ;

CREATE TABLE livraria.Editora (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (255) NOT NULL ,
email VARCHAR (255) NOT NULL
);

INSERT INTO Editora ( nome , email ) VALUES ( 'Oreilly' , 'oreilly@email.com') ;
INSERT INTO Editora ( nome , email ) VALUES ( 'Wrox' , 'wrox@email.com') ;
INSERT INTO Editora ( nome , email ) VALUES ( 'Apress' , 'apress@email.com') ;

select * FROM editora;

INSERT INTO Livro ( titulo , preco ) VALUES ( 'Aprendendo C#' , 89.90) ;
INSERT INTO Livro ( titulo , preco ) VALUES ( 'Introdução ao JSF 2' , 122.90) ;
INSERT INTO Livro ( titulo , preco ) VALUES ( 'JSF 2 Avançado' , 149.90) ;

DELETE FROM livro;
select * from Livro;
alter table livro add id bigint not null AUTO_INCREMENT PRIMARY KEY;

INSERT INTO Livro ( titulo , preco ) VALUES ( 'Aprendendo C#' , 89.90) ;
INSERT INTO Livro ( titulo , preco ) VALUES ( 'Introdução ao JSF 2' , 122.90) ;
INSERT INTO Livro ( titulo , preco ) VALUES ( 'JSF 2 Avançado' , 149.90) ;

select * from Livro;

UPDATE Editora SET nome = 'OReilly' WHERE id =1;