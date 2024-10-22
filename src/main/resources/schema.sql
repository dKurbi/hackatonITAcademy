CREATE TABLE Districts
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    Nom_Districte   VARCHAR(255)   NOT NULL,
    renta_media     DECIMAL(10, 2) NOT NULL,
    num_actividades DECIMAL(10, 2) NOT NULL
);