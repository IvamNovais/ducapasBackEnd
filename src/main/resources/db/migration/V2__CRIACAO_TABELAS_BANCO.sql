CREATE SCHEMA producao;

CREATE TABLE producao.produtos (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    categoria VARCHAR(255),
    preco_custo DOUBLE PRECISION,
    preco_venda DOUBLE PRECISION,
    quantidade_estoque INT,
    quantidade_estoque_minima INT
);
