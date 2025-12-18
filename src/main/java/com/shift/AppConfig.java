package com.shift;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AppConfig {

    private boolean append = false;
    private String inputFolder = "input";
    private final List<String> inputFiles = new ArrayList<>();
    private Path outputFolder = Path.of(".");
    private String outputFileNamePrefix = "";
    private StatisticsOption statisticsOption;


    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }
    public String getInputFolder() {
        return inputFolder;
    }

    public void setInputFolder(String folder) {
        this.inputFolder = folder;
    }

    public Path getOutputFolder() {
        return outputFolder;
    }
    public void setOutputFolder(Path dir) {
        this.outputFolder = dir;
    }

    public String getOutputFilePrefix() {
        return outputFileNamePrefix;
    }

    public void setOutputFilePrefix(String outputFilePrefix) {
        this.outputFileNamePrefix = outputFilePrefix;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public void addInputFile(String file) {
        inputFiles.add(file);
    }

    public StatisticsOption getStatisticsOption() {
        return statisticsOption;
    }

    public void setStatisticsOption(StatisticsOption statisticsOption) {
        this.statisticsOption = statisticsOption;
    }

}
