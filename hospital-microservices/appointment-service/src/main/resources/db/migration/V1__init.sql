CREATE TABLE appointment
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    doctor_id  BIGINT       NOT NULL,
    patient_id BIGINT       NOT NULL,
    date_time        VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL
);

