CREATE TABLE district_data_records
(
    id                  INT PRIMARY KEY AUTO_INCREMENT, -- Unique ID for each record
    nom_districte       VARCHAR(255),                   -- District name
    nom_barri           VARCHAR(255),                   -- Neighborhood name
    codi_barri          INT,                            -- Neighborhood code
    renta_barrio_mean   DECIMAL(10, 2),                 -- Average income in the neighborhood
    renta_distrito_mean DECIMAL(10, 2)                  -- Average income in the district
);
