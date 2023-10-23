CREATE TABLE IF NOT EXISTS persona (
 id SERIAL,
  nombre VARCHAR(100) NOT NULL,
  direccion VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS libro (
 id SERIAL,
 nombre VARCHAR(100) NOT NULL,
 autor VARCHAR(100) NOT NULL,
 persona_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (table1_id ) REFERENCES table1(id)
    );