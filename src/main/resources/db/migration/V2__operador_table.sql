CREATE TABLE operador(
                              id VARCHAR(36) NOT NULL,
                              nombre VARCHAR(100) NOT NULL,
                              apellido VARCHAR(100) NOT NULL,
                              email VARCHAR(100) NOT NULL,
                              direccion VARCHAR(100) ,
                              turno ENUM('TURNO1','TURNO2','TURNO3','TURNO4','TURNO5','TURNO6') NOT NULL,
                              PRIMARY KEY(id)
);