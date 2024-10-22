CREATE TABLE districts
(
    id                      INT PRIMARY KEY AUTO_INCREMENT,
    addresses_district_name VARCHAR(255) NOT NULL,
    renta_media             INT          NOT NULL,
    num_actividades         INT          NOT NULL,
    oferta_educativa        INT          NOT NULL,
    infantil                INT          NOT NULL,
    primarias               INT          NOT NULL,
    secundarias             INT          NOT NULL
);
