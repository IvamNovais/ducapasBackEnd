CREATE SCHEMA financeiro
CREATE TABLE financeiro.despesa (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    prazo DATE,
    pago BOOLEAN,
    diaPagamento DATE,
    diaCriacao DATE
);

CREATE TABLE financeiro.receita (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    prazo DATE,
    diaPagamento DATE,
    diaCriacao DATE,
    juros BOOLEAN,
    recebido BOOLEAN
);
