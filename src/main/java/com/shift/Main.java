package com.shift;

public class Main {
    public static void main(String[] args) {

        AppConfig config = ArgumentParser.parse(args);

        if (config.getInputFiles().isEmpty()) {
            System.out.println("Не указаны входные файлы!");
            return;
        }


        WriterManager writerManager = new WriterManager(config.isAppend(), config.getOutputFilePrefix(), config.getOutputFolder());
        StatisticsManager statisticsManager = new StatisticsManager();

        InputFileReader inputFileReader = new InputFileReader(writerManager, statisticsManager);
        inputFileReader.readFiles(config.getInputFiles());

        writerManager.close();

        statisticsManager.printSummary(config.getStatisticsOption());
    }
}
