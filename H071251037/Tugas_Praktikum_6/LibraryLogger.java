package Tugas_Praktikum_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {

    List<LogEntry> logs = new ArrayList<>();

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logActivity(String borrowTime, String title, String member, String returnTime) {
        logs.add(new LogEntry(borrowTime, title, member, returnTime));
    }

    public String getLogs() {
        if (logs.isEmpty()) {
            return "Belum ada log";
        }

        String result = "";

        result += "+---------------------+------------------------------+---------------+---------------------+\n";
        result += "| Dipinjam pada       | Judul                        | Member        | Dikembalikan pada   |\n";
        result += "+---------------------+------------------------------+---------------+---------------------+\n";

        for (LogEntry log : logs) {
            result += String.format("| %-19s | %-28s | %-13s | %-19s |\n",
                    log.borrowTime,
                    log.title,
                    log.member,
                    log.returnTime);
        }

        result += "+---------------------+------------------------------+---------------+---------------------+\n";

        return result;
    }

    public String getCurrentTime() {
        return LocalDateTime.now().format(formatter);
    }
}