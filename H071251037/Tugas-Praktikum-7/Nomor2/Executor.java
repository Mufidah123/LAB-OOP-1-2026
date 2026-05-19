package Nomor2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // new ThreadFactory() {int count = 1;
        //     @Override
        //     public Thread newThread(Runnable r) {
        //         return new Thread(r, "Thread-" + count++);
        //     }
        // });
        ConcurrentHashMap<String, Result> resultMap = new ConcurrentHashMap<>();

        DataProcessor processor = new DataProcessor();
        CountDownLatch latch = new CountDownLatch(10);

        List<Long> durations = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= 10; i++) {
            String fileName = "Dokumen_" + i + ".txt";

            executor.execute(() -> {
                long start = System.currentTimeMillis();
                
                try {
                    int wordCount = processor.process(fileName);
                    long duration = System.currentTimeMillis() - start;
                    String threadName = Thread.currentThread().getName();

                    resultMap.put(fileName, new Result(fileName, threadName, wordCount, duration));
                    durations.add(duration);

                    System.out.println("[" + threadName.replace("pool-1-thread-", "Thread-") + "] selesai memproses "
                    + fileName +" (" + wordCount + " kata)");
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.println("\nTABEL RINGKASAN :");
        System.out.println("+-----------------+----------------------+----------+------------+");
        System.out.println("|   Nama Dokumen  |        Thread        |   Kata   | Durasi(ms) |");
        System.out.println("+-----------------+----------------------+----------+------------+");

        int totalKata = 0;
        long totalWaktu = 0;

        for (Result r : resultMap.values()){
        // for (int i = 1; i <= 10; i++) {
            // String key = "Dokumen_" + i + ".txt";
            // Result r = resultMap.get(key);

            // if (r != null) {
                System.out.printf("| %-15s | %-20s | %-8d | %-10d |\n",
                r.fileName, r.threadName, r.wordCount, r.duration);

                totalKata += r.wordCount;
                totalWaktu += r.duration;
            // }
        }
        System.out.println("+-----------------+----------------------+----------+------------+");

        System.out.println("\nTotal kata keseluruhan: " + totalKata + " kata");
        System.out.println("Rata-rata waktu: " + (totalWaktu/resultMap.size()) + " ms");
    }
}