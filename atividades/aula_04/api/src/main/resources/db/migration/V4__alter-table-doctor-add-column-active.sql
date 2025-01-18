ALTER TABLE doctor
ADD COLUMN active BOOLEAN NOT NULL
AFTER city;

UPDATE doctor
SET active = true;