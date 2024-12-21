package com.ondrejwinter.euler;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

  private static final String SOLUTIONS_FILE = "solutions.json";
  private static final String INPUTS_FILE = "inputs.json";

  private TestUtils() {
    throw new UnsupportedOperationException("Utility class");
  }

  public static Long[] loadSolutions() {
    return loadFile(SOLUTIONS_FILE);
  }

  public static Long[] loadInputs() {
    return loadFile(INPUTS_FILE);
  }

  private static Long[] loadFile(String fileName) {
    ObjectMapper mapper = new ObjectMapper();
    try (InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(fileName)) {
      if (inputStream == null) {
        throw new RuntimeException(fileName + " not found");
      }
      byte[] fileBytes = inputStream.readAllBytes();
      return mapper.readValue(fileBytes, Long[].class);
    } catch (IOException e) {
      throw new RuntimeException("Error loading file: " + fileName, e);
    }
  }
}
