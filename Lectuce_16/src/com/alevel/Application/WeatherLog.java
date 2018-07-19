package com.alevel.Application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.alevel.Application.Temperature.isValid;
//import static com.alevel.j4.Temperature.isValid;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public class WeatherLog {
    private final static String FILENAME = "/Users/luver/weather_log.txt";

    private WeatherLog() {

    }

    public static WeatherLog instance() {
        return new WeatherLog();
    }

    public void addReport(String temperature) throws TemperatureFormatException {
        if (isValid(temperature)) {

            try (BufferedWriter writer = new
                    BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.newLine();
                writer.write(temperature);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new TemperatureFormatException();
        }
    }

    public List<String> getReports() {
        try {
            return readAllLines(get(FILENAME));
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}
