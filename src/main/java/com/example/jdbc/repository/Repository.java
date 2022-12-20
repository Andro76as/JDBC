package com.example.jdbc.repository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    public final NamedParameterJdbcTemplate template;
    String scriptFileName = read("select_name.sql");
    public Repository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        List<String> result = template.queryForList(scriptFileName, Map.of("name",name), String.class);
        return result;
    }
}
