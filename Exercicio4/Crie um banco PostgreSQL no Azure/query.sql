/* By Larissa Valadares Silqueira */

CREATE TABLE prestador (
    idPrestador INT PRIMARY KEY,
    nome VARCHAR(45),
    cpf_cnpj CHAR(14),
    email VARCHAR(100),
    telefone VARCHAR(15),
    endereco VARCHAR(100)
);

INSERT INTO prestador (idPrestador, nome, cpf_cnpj, email, telefone, endereco) 
    VALUES (1, 'PC repair', '0123456789', 'computadorConsertos@mail.com', '3212-9876', 'rua X, n 73, Bairro Centro');

INSERT INTO prestador (idPrestador, nome, cpf_cnpj, email, telefone, endereco) 
    VALUES (2, 'Faxina em Casa', '9876543210', 'renataFaxineira@mail.com', '9999-6564', 'atendimento online');

SELECT * FROM prestador;
