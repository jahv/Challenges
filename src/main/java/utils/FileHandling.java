package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class FileHandling {

    public static StringBuilder validateFileContains(String path, String search) {
        StringBuilder stringBuilder = new StringBuilder();
        int exists = -1;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(s -> stringBuilder.append(s + "\n"));
            exists = stringBuilder.indexOf(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists == -1 ? stringBuilder : new StringBuilder();
    }

    public static StringBuilder validateFileContains(String path, String search1, String search2) {
        StringBuilder stringBuilder = new StringBuilder();
        int exists1 = -1;
        int exists2 = -1;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(s -> stringBuilder.append(s + "\n"));
            exists1 = stringBuilder.indexOf(search1);
            exists2 = stringBuilder.indexOf(search2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists1 != -1 || exists2 != -1 ? stringBuilder : new StringBuilder();
    }

    public static List<String> listFiles(String basePath, String extension)  {
        List<String> files = new ArrayList<>();
        try{
            Path path = Paths.get(basePath);
            Stream<Path> pathStream = Files.walk(path);

            pathStream.forEach(
                    s -> {

                        String name = s.toString();

                        File f = new File(name);

                        if(!f.isDirectory() && name.endsWith(extension)) {
                            System.out.println(name);
                            files.add(name);
                        }
                    }
            );

            System.out.println(files.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

    public static Map<String, String> listFilesNameContains(String basePath, String patternName) {
        Map<String, String> files = new HashMap<>();

        try {
            Path path = Paths.get(basePath);
            Stream<Path> pathStream = Files.walk(path, 1);

            String regex = createRegex(patternName);

            pathStream.forEach(
                    s -> {
                        String fullName = s.toString();
                        String name = fullName.replaceFirst(basePath, "").replaceFirst("/", "");
                        File f = new File(fullName);

                        if(!f.isDirectory() && name.matches(regex)) {
                            files.put(name, fullName);
                        } else {
                            System.out.println("Discard: " + name);
                        }
                    }
            );
            pathStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

    private static String createRegex(String pattern) {
        StringBuilder regex = new StringBuilder("^");
        for(char c : pattern.toCharArray()) {
            switch (c) {
                case '*': regex.append(".*"); break;
                case '.': regex.append("\\."); break;
                case '/': regex.append("\\/"); break;
                default: regex.append(c);
            }
        }
        regex.append("$");
        return regex.toString();
    }

    public static Map<LogInfo, Integer> getStatistics(Map<String, String> files) {

        String dateTimeRegex = "^\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d.+";

        Map<LogInfo, Integer> metrics = new HashMap<>();

        for(String name : files.keySet()) {
            String filePath = files.get(name);

            try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
                stream.forEach(
                        s -> {
                            if(s.matches(dateTimeRegex)) {
                                LogInfo logInfo = new LogInfo();
                                logInfo.setFileName(name);
                                logInfo.setDateTime(s.substring(0,19));

                                Integer counter = metrics.get(logInfo);
                                if(counter == null) {
                                    counter = 1;
                                } else {
                                    counter++;
                                }
                                metrics.put(logInfo, counter);
                            }
                        }
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return metrics;
    }

    public static class LogInfo {
        private String fileName;
        private String dateTime;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LogInfo logInfo = (LogInfo) o;
            return Objects.equals(fileName, logInfo.fileName) &&
                    Objects.equals(dateTime, logInfo.dateTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fileName, dateTime);
        }
    }

}



