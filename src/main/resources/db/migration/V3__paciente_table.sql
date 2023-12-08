CREATE TABLE paciente
(
    id       VARCHAR(36) NOT NULL,
    dni       VARCHAR(100) NOT NULL UNIQUE,
    nombre    VARCHAR(100) NOT NULL,
    apellido  VARCHAR(100) NOT NULL,
    direccion VARCHAR(100),
    telefono  VARCHAR(100),
    PRIMARY KEY (id)
);