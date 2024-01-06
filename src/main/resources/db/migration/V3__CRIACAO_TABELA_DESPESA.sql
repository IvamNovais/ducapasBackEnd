CREATE SCHEMA financeiro
CREATE TABLE financeiro.despesa (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    prazo DATE,
    pago BOOLEAN
);
