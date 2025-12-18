package com.shift;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputFileReader {

    private static final Logger logger = Logger.getLogger(InputFileReader.class.getName());

    private final WriterManager writer;
    private final StatisticsManager stats;

    public InputFileReader(WriterManager writer, StatisticsManager stats) {
        this.writer = writer;
        this.stats = stats;
    }

    public void readFiles(List<String> files) {
        for (String file : files) {
            readSingleFile(Path.of(file));
        }
    }

    private void readSingleFile(Path path) {
        if (!Files.exists(path)) {
            logger.log(Level.WARNING, "Файл не найден: {0}", path);
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка чтения файла: " + path, e);
        }
    }

    private void processLine(String line) {
        line = line.trim();
        if (line.isEmpty()) return;

        if (TypeClassifier.isInteger(line)) {
            writer.writeInteger(line);
            stats.addInteger(line);
        } else if (TypeClassifier.isFloat(line)) {
            writer.writeFloat(line);
            stats.addFloat(line);
        } else {
            writer.writeString(line);
            stats.addString(line);
        }
    }
}
