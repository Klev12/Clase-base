CREATE TABLE IF NOT EXISTS persona(
    id SERIAL Primary Key,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS libro (
   id SERIAL Primary Key,
   nickname VARCHAR(100) NOT NULL,
   autor VARCHAR(100) NOT NULL,
   persona_id INT NOT NULL,
   FOREIGN KEY (persona_id ) REFERENCES persona(id)
    );

