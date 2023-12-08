CREATE TABLE interaccion
(
    id        VARCHAR(36) NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
    pregunta   TEXT,
    respuesta  TEXT,
    llamada_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (llamada_id) REFERENCES llamada (id) ON DELETE CASCADE
)