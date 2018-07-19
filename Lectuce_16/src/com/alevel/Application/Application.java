package com.alevel.Application;

public class Application {

    public static final String PREDICT = "--predict";
    public static final String LOG = "--log";

    private Application() {
    }

    public static Application instance() {
        return new Application();

    }

    public void run(String[] args) {
        if (args.length < 1) {
            System.out.println("No parameters");
            System.exit(1);
        }

        final String mode = args[0];

        final WeatherLog weatherLog = WeatherLog.instance();
        if (mode.equals(LOG)) {
            final String temperature = args[1];
            try {
                weatherLog.addReport(temperature);
            } catch (TemperatureFormatException e) {
                System.out.println("Invalid format");
                System.exit(1);
            }
        } else if (mode.equals(PREDICT)) {
            WeatherPrediction prediction =
                    WeatherPrediction.basedOn(weatherLog);
            System.out.println(prediction.getValue());
        }
    }
}

