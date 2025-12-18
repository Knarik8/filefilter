package com.shift;


import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArgumentParser {


    private static final Logger logger = Logger.getLogger(ArgumentParser.class.getName());


    public static AppConfig parse(String[] args) {
        AppConfig config = new AppConfig();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-a" -> config.setAppend(true);

                case "-p" -> {
                    if (i + 1 < args.length) {
                        config.setOutputFilePrefix(args[i + 1]);
                        i++;
                    } else {
                        logger.log(Level.SEVERE, "Ошибка: после -p должно быть значение префикса");
                    }
                }

                case "-o" -> {
                    if (i + 1 < args.length) {
                        config.setOutputFolder(Path.of(args[i + 1]));
                        i++;
                    } else {
                        logger.log(Level.SEVERE, "Ошибка: после -o должно быть указано имя папки");
                    }
                }

                case "-s" -> config.setStatisticsOption(StatisticsOption.SHORT);

                case "-f" -> config.setStatisticsOption(StatisticsOption.FULL);

                default -> {
                    if (!arg.startsWith("-")) {
                        config.addInputFile(config.getInputFolder() + "/" + arg);
                    }
                }
            }
        }
        return config;
    }
}
