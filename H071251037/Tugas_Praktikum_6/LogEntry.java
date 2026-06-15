package Tugas_Praktikum_6;

public class LogEntry {
    String borrowTime;
    String title;
    String member;
    String returnTime;

    public LogEntry(String borrowTime, String title, String member, String returnTime) {
        this.borrowTime = borrowTime;
        this.title = title;
        this.member = member;
        this.returnTime = returnTime;
    }
}