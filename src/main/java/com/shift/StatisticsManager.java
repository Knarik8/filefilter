package com.shift;

public class StatisticsManager {

    private long intCount = 0;
    private long intSum = 0;
    private long intMin = Long.MAX_VALUE;
    private long intMax = Long.MIN_VALUE;

    private long floatCount = 0;
    private double floatSum = 0;
    private double floatMin = Double.MAX_VALUE;
    private double floatMax = Double.MIN_VALUE;

    private long stringCount = 0;
    private int minLength = Integer.MAX_VALUE;
    private int maxLength = Integer.MIN_VALUE;


    public void addInteger(String s) {
        long value = Long.parseLong(s);
        intCount++;
        intSum += value;
        intMin = Math.min(intMin, value);
        intMax = Math.max(intMax, value);
    }

    public void addFloat(String s) {
        double value = Double.parseDouble(s);
        floatCount++;
        floatSum += value;
        floatMin = Math.min(floatMin, value);
        floatMax = Math.max(floatMax, value);
    }

    public void addString(String s) {
        stringCount++;
        int len = s.length();
        minLength = Math.min(minLength, len);
        maxLength = Math.max(maxLength, len);
    }


    public void printSummary(StatisticsOption option) {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------\n");
        sb.append("====== Статистика ======\n");

        if (option == StatisticsOption.SHORT || option == StatisticsOption.FULL) {
            sb.append(String.format("Целые числа: %d%n", intCount));
            sb.append(String.format("Вещественные числа: %d%n", floatCount));
            sb.append(String.format("Строки: %d%n", stringCount));
        }

        if (option == StatisticsOption.FULL) {

            if (intCount > 0) {
                sb.append("----------------------------------\n");
                sb.append(String.format("Минимальное целое число: %d%n", intMin));
                sb.append(String.format("Максимальное целое число: %d%n", intMax));
                sb.append(String.format("Сумма целых чисел: %d%n", intSum));
                sb.append(String.format("Среднее целых чисел: %.2f%n", (double) intSum / intCount));
            }

            if (floatCount > 0) {
                sb.append("----------------------------------\n");
                sb.append(String.format("Минимальное вещественное число: %.5f%n", floatMin));
                sb.append(String.format("Максимальное вещественное число: %.5f%n", floatMax));
                sb.append(String.format("Сумма вещественных чисел: %.5f%n", floatSum));
                sb.append(String.format("Среднее вещественных чисел: %.5f%n", floatSum / floatCount));
            }

            if (stringCount > 0) {
                sb.append("----------------------------------\n");
                sb.append(String.format("Размер самой короткой строки: %d%n", minLength));
                sb.append(String.format("Размер самой длинной строки: %d%n", maxLength));
            }

        }
        System.out.print(sb);
    }
}
