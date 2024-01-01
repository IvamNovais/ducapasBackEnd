CREATE SCHEMA producao;

CREATE TABLE producao.produto (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    preco DOUBLE PRECISION,
    quantidade_estoque INTEGER
);

CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    rua VARCHAR(255),
    cidade VARCHAR(255),
    numero VARCHAR(255),
    bairo VARCHAR(10)
);

CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    nome_razao_social VARCHAR(255),
    cpf_cnpj VARCHAR(14),
    endereco_id INTEGER REFERENCES endereco(id)
    user_id INTEGER REFERENCES user(id)

);
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome_razao_social VARCHAR(255),
    cpf_cnpj VARCHAR(14),
    user_id INTEGER REFERENCES user(id)
);

CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    quantidade INTEGER,
    produto_id INTEGER REFERENCES produto(id)
);

CREATE TABLE encomenda (
    id SERIAL PRIMARY KEY,
    comprador_id INTEGER REFERENCES cliente(id),
    data TIMESTAMP,
    status VARCHAR(50),
);

