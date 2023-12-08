CREATE TABLE llamada(
    id         VARCHAR(36) NOT NULL,
    fecha_hora       TIMESTAMP    NOT NULL,
    es_broma    BOOLEAN NOT NULL,
    comentario   TEXT,
    operador_id VARCHAR(36) NOT NULL,
    especialista_id VARCHAR(36)  ,
    paciente_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (operador_id) REFERENCES operador (id),
    FOREIGN KEY (especialista_id) REFERENCES especialista (id) ,
    FOREIGN KEY (paciente_id) REFERENCES paciente (id) ON DELETE CASCADE

);

