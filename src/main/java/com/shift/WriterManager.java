package com.shift;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterManager {

    private static final Logger logger = Logger.getLogger(WriterManager.class.getName());

    private BufferedWriter intWriter;
    private BufferedWriter floatWriter;
    private BufferedWriter stringWriter;
    private final boolean append;
    private final String outputFileNamePrefix;
    private final Path resultPath;


    public WriterManager(boolean append, String outputFilePrefix, Path resultPath) {
        this.append = append;
        this.outputFileNamePrefix = outputFilePrefix;
        this.resultPath = resultPath.toAbsolutePath();


        try {
            Files.createDirectories(this.resultPath);
            logger.log(Level.INFO, "Создана/существует папка для результатов: {0}", this.resultPath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не удалось создать папку для результатов: " + this.resultPath, e);
        }
    }

    public void writeInteger(String s) {
        try {
            if (intWriter == null) {
                Path file = resultPath.resolve(outputFileNamePrefix + "integers.txt");
                intWriter = new BufferedWriter(new FileWriter(file.toFile(), append));
                logger.log(Level.INFO, "Создан файл для целых чисел: {0}", file);
            }
            intWriter.write(s);
            intWriter.newLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи в файл integers.txt", e);
        }
    }

    public void writeFloat(String s) {
        try {
            if (floatWriter == null) {
                Path file = resultPath.resolve(outputFileNamePrefix + "floats.txt");
                floatWriter = new BufferedWriter(new FileWriter(file.toFile(), append));
                logger.log(Level.INFO, "Создан файл для вещественных чисел: {0}", file);

            }
            floatWriter.write(s);
            floatWriter.newLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи в файл floats.txt", e);
        }
    }

    public void writeString(String s) {
        try {
            if (stringWriter == null) {
                Path file = resultPath.resolve(outputFileNamePrefix + "strings.txt");
                stringWriter = new BufferedWriter(new FileWriter(file.toFile(), append));
                logger.log(Level.INFO, "Создан файл для строк: {0}", file);
            }
            stringWriter.write(s);
            stringWriter.newLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи в файл strings.txt", e);
        }
    }

    public void close() {
        try {
            if (intWriter != null) intWriter.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка закрытия файла integers.txt", e);
        }

        try {
            if (floatWriter != null) floatWriter.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка закрытия файла floats.txt", e);
        }

        try {
            if (stringWriter != null) stringWriter.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка закрытия файла strings.txt", e);
        }
    }
}
