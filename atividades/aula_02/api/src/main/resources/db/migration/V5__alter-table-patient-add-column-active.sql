ALTER TABLE patient
ADD COLUMN active BOOLEAN NOT NULL
AFTER city;

UPDATE patient
SET active = true;