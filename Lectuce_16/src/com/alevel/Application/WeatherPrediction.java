package com.alevel.Application;

import java.util.List;

public class WeatherPrediction {
    private final List<String> reports;

    private WeatherPrediction(List<String> reports) {
        this.reports = reports;
    }

    public static WeatherPrediction basedOn(WeatherLog weatherLog) {
        // Получить все записи погоды из weatherLog
        // Создать WeatherPrediction из них
        List<String> reports = weatherLog.getReports();
        return new WeatherPrediction(reports);
    }

    public String getValue() {

        return reports.get(reports.size() - 1);
    }
}
