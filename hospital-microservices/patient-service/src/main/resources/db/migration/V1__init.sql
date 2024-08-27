CREATE TABLE patient
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) ,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    dob        VARCHAR(255) ,
    phone      VARCHAR(255) ,
    email      VARCHAR(255) ,
    street_number     INT          ,
    street     VARCHAR(255) ,
    city       VARCHAR(255) ,
    county     VARCHAR(255) ,
    postcode   VARCHAR(255) ,
    country    VARCHAR(255) ,
    weight     INT          ,
    height     DOUBLE       ,
    ward_id    INT          ,
    attending_doctor_id    INT
);

