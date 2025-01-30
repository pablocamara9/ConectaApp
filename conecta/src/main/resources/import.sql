

INSERT INTO profesor (id, nombre, apellidos, email, telefono)
VALUES (nextval('profesor_seq'), 'Juan', 'Pérez', 'juan.perez@email.com', '600123456');

INSERT INTO profesor (id, nombre, apellidos, email, telefono)
VALUES (nextval('profesor_seq'), 'María', 'Gómez', 'maria.gomez@email.com', '600987654');

INSERT INTO profesor (id, nombre, apellidos, email, telefono)
VALUES (nextval('profesor_seq'), 'Carlos', 'Lopez', 'carlos.lopez@email.com', '600456789');

INSERT INTO profesor (id, nombre, apellidos, email, telefono)
VALUES (nextval('profesor_seq'), 'Ana', 'Rodríguez', 'ana.rodriguez@email.com', '600345678');


INSERT INTO curso (id, nombre, horas_empresa)
VALUES (nextval('curso_seq'), 'Curso de Programación Java', 50);

INSERT INTO curso (id, nombre, horas_empresa)
VALUES (nextval('curso_seq'), 'Curso de Desarrollo Web Full Stack', 60);

INSERT INTO curso (id, nombre, horas_empresa)
VALUES (nextval('curso_seq'), 'Curso de Bases de Datos Relacionales', 40);

INSERT INTO curso (id, nombre, horas_empresa)
VALUES (nextval('curso_seq'), 'Curso de Gestión de Proyectos Ágiles', 45);



INSERT INTO esDocenteEn (profesor_id, curso_id)
VALUES (currval('profesor_seq'), currval('curso_seq'));

INSERT INTO esDocenteEn (profesor_id, curso_id)
VALUES (currval('profesor_seq'), currval('curso_seq'));

INSERT INTO esDocenteEn (profesor_id, curso_id)
VALUES (currval('profesor_seq'), currval('curso_seq'));

INSERT INTO esDocenteEn (profesor_id, curso_id) VALUES (currval('profesor_seq'), currval('curso_seq'));

INSERT INTO esDocenteEn (profesor_id, curso_id) VALUES (currval('profesor_seq'), currval('curso_seq'));
