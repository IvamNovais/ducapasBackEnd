CREATE TABLE producao.cliente (
    id UUID PRIMARY KEY,
    nomeRasaoSocial VARCHAR(255),
    cpfCnpj VARCHAR(20),
    endereco_id UUID
);

CREATE TABLE producao.fornecedor (
    id UUID PRIMARY KEY,
    nomeRasaoSocial VARCHAR(255),
    cpfCnpj VARCHAR(20),
    endereco_id UUID
);

CREATE TABLE producao.endereco (
    id UUID PRIMARY KEY,
    rua VARCHAR(255),
    numero VARCHAR(20),
    bairro VARCHAR(255),
    cidade VARCHAR(255)
);

CREATE TABLE producao.pedido (
    id UUID PRIMARY KEY,
    quantidade INT,
    produto_id UUID,
    FOREIGN KEY (produto_id) REFERENCES producao.produtos(id)
);

CREATE TABLE producao.encomenda (
    id UUID PRIMARY KEY,
    comprador_id UUID,
    data DATE,
    status VARCHAR(255),
    FOREIGN KEY (comprador_id) REFERENCES producao.cliente(id)
);

CREATE TABLE producao.venda (
    id UUID PRIMARY KEY,
    comprador_id UUID,
    dataVenda TIMESTAMP,
    status VARCHAR(255),
    FOREIGN KEY (comprador_id) REFERENCES producao.cliente(id)
);
