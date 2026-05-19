package Nomor2;

public class Result {
    String fileName;
    String threadName;
    int wordCount;
    long duration;

    public Result(String fileName, String threadName, int wordCount, long duration) {
        this.fileName = fileName;
        this.threadName = threadName;
        this.wordCount = wordCount;
        this.duration = duration;
    }
}