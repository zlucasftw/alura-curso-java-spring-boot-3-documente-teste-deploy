ALTER TABLE appointment
ADD COLUMN cancellation_reason VARCHAR(100) DEFAULT NULL
AFTER canceled;