CREATE TABLE pauta (
    id SERIAL PRIMARY KEY,
    assunto_pauta VARCHAR(255) NOT NULL,
    ds_pauta VARCHAR(255) NULL,
    data_criacao TIMESTAMP NOT NULL
);

CREATE TABLE sessao (
    id SERIAL PRIMARY KEY,
    total_votos_sim INTEGER,
    total_votos_nao INTEGER,
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
);

CREATE TABLE sessao_usuario (
    id SERIAL PRIMARY KEY,
    id_sessao BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    FOREIGN KEY (id_sessao) REFERENCES sessao(id),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
