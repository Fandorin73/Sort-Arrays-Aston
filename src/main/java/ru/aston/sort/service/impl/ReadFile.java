package ru.aston.sort.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReadFile {
    public List<Integer> readIntegersFromFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        try (InputStream inputStream = file.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }

            List<Integer> numbers = new ArrayList<>();
            for (String numStr : lines) {
                int number = Integer.parseInt(numStr);
                numbers.add(number);
            }

            return numbers;

        } catch (IOException e) {
            throw new IllegalArgumentException("File is empty");
        }
    }
}
