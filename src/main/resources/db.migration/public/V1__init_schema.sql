CREATE TABLE pauta (
    id SERIAL PRIMARY KEY,
    assunto_pauta VARCHAR(255) NOT NULL,
    ds_pauta VARCHAR(255) NULL,
    data_criacao TIMESTAMP NOT NULL
);

CREATE TABLE sessao (
    id BIGINT PRIMARY KEY,
    total_votos INTEGER,
    inicio_sessao TIMESTAMP NOT NULL,
    final_sessao TIMESTAMP
);
