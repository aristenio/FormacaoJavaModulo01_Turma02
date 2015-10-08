USE banco;

INSERT INTO banco.clientes (cpf,nome) VALUES (91518604827,'Aristenio Monteiro');

SELECT cpf, nome FROM banco.clientes;
SELECT * FROM banco.clientes;

UPDATE banco.clientes SET nome = 'Aristenio Batista Monteiro Filho' WHERE cpf = 91518604827;

DELETE FROM banco.clientes WHERE CPF = 91518604827;