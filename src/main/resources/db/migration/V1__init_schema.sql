CREATE TABLE pauta (
    id SERIAL PRIMARY KEY,
    assunto_pauta VARCHAR(255) NOT NULL,
    ds_pauta VARCHAR(255) NULL,
    data_criacao TIMESTAMP NOT NULL
);

CREATE TABLE sessao (
    id SERIAL PRIMARY KEY,
    total_votos INTEGER,
    funcionamento_sessao INTEGER,
    inicio_sessao TIMESTAMP NOT NULL,
    final_sessao TIMESTAMP,
    id_pauta BIGINT,
    FOREIGN KEY (id_pauta) REFERENCES pauta(id)
);

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL
)
