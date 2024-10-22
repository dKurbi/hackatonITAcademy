package com.itacademy.hackaton.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Map;

@Configuration
public class CsvDataLoader {

    private final JdbcTemplate jdbcTemplate;

    public CsvDataLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public ApplicationRunner loadCsvData() {
        return args -> {
            try {
                // Ruta del archivo CSV
                File file = new File("src/main/resources/dataset.csv");

                // Configuración para leer el CSV
                CsvSchema schema = CsvSchema.emptySchema().withHeader();
                CsvMapper mapper = new CsvMapper();
                MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(file);

                // Insertar cada fila en la base de datos
                while (it.hasNext()) {
                    Map<String, String> row = it.next();
                    String sql = "INSERT INTO Districts (Nom_Districte, renta_media, num_actividades) VALUES (?, ?, ?)";
                    jdbcTemplate.update(sql,
                            row.get("Nom_Districte"),
                            Double.parseDouble(row.get("renta_media")),
                            Double.parseDouble(row.get("num_actividades")));
                }
                System.out.println("Data loaded successfully from CSV!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
