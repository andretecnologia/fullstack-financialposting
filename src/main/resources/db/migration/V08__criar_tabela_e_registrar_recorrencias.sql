CREATE TABLE recorrencia (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO recorrencia (nome) values ('Nenhuma');
INSERT INTO recorrencia (nome) values ('Mensal');

ALTER TABLE lancamento ADD COLUMN codigo_recorrencia BIGINT(20);
ALTER TABLE lancamento ADD CONSTRAINT fk_lancamento_recorrencia FOREIGN KEY (codigo_recorrencia) REFERENCES recorrencia(codigo);


UPDATE lancamento SET codigo_recorrencia = 2;