CREATE SCHEMA financeiro
CREATE TABLE financeiro.despesa (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    prazo DATE,
    pago BOOLEAN,
    dia_pagamento DATE,
    dia_criacao DATE
);

CREATE TABLE financeiro.receita (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    valor DOUBLE PRECISION,
    prazo DATE,
    dia_pagamento DATE,
    dia_criacao DATE,
    juros DOUBLE PRECISION,
    recebido BOOLEAN
);
