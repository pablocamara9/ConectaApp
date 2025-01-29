//Aqui meteremos los datos de prueba para probar la rama
-- Insertar cursos (con generación de ID automática)
INSERT INTO curso (id, nombre, horas_empresa) VALUES
(nextval('curso_seq'), 'Desarrollo Web', 200),
(nextval('curso_seq'), 'Programación en Java', 250),
(nextval('curso_seq'), 'Ciberseguridad', 180);

-- Insertar profesores en la tabla "persona" (usando la secuencia)
INSERT INTO persona (id, dtype, nombre, apellidos, email, telefono) VALUES
(nextval('persona_seq'), 'Profesor', 'Juan', 'Pérez', 'juan@educacion.com', '600123456'),
(nextval('persona_seq'), 'Profesor', 'Ana', 'López', 'ana@educacion.com', '600654321');

-- Insertar relación muchos a muchos (profesor - curso)
INSERT INTO esdocenteen (profesor_id, curso_id)
SELECT p.id, c.id FROM persona p, curso c
WHERE (p.nombre = 'Juan' AND c.nombre = 'Desarrollo Web')
   OR (p.nombre = 'Juan' AND c.nombre = 'Programación en Java')
   OR (p.nombre = 'Ana' AND c.nombre = 'Programación en Java')
   OR (p.nombre = 'Ana' AND c.nombre = 'Ciberseguridad');
