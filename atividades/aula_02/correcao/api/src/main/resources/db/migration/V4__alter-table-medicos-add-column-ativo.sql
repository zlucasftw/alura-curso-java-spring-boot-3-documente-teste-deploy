ALTER TABLE medicos
ADD COLUMN ativo TINYINT NOT NULL
AFTER cidade;

UPDATE medicos
SET ativo = 1;