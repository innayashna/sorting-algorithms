package org.example.service;

import org.example.exception.FileProcessingException;
import org.example.exception.InvalidInputException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.example.exception.constants.ErrorMessage.COULD_NOT_READ_THE_FILE;
import static org.example.exception.constants.ErrorMessage.INVALID_INPUT;

@Service
public class FileReader {

    public int[] getArray(MultipartFile file) {
        try (InputStream is = file.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String input = br.readLine();
            return convertInputToIntegerArray(input);
        } catch (IOException e) {
            throw new FileProcessingException(COULD_NOT_READ_THE_FILE);
        }
    }

    private int[] convertInputToIntegerArray(String input) {
        String[] stringArray = input.split(", ");
        int[] array = new int[stringArray.length];

        try {
            for (int i = 0; i < stringArray.length; i++) {
                array[i] = Integer.parseInt(stringArray[i]);
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_INPUT);
        }

        return array;
    }
}
