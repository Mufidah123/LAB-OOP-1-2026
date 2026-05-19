package Nomor1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(150);

        ExecutorService pemasok = Executors.newFixedThreadPool(2);
        ExecutorService kurir = Executors.newFixedThreadPool(3);
        ExecutorService monitorBar = Executors.newSingleThreadExecutor();

        Pemasok[] pemasokList = {new Pemasok(gudang), new Pemasok(gudang)};

        Kurir[] kurirList = {new Kurir(gudang),
                            new Kurir(gudang),
                            new Kurir(gudang)};

        Monitoring monitor = new Monitoring(gudang);

        for (Pemasok p : pemasokList) {
            pemasok.execute(p);
        }
        for (Kurir k : kurirList) {
            kurir.execute(k);
        }
        monitorBar.execute(monitor);

        try {
            Thread.sleep(15000); // 15 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Pemasok p : pemasokList) {
            p.stop();
        }
        for (Kurir k : kurirList) {
            k.stop();
        }
        monitor.stop();

        pemasok.shutdown();
        kurir.shutdown();
        monitorBar.shutdown();
        
        try {
            // maksimal 5 detik
            pemasok.awaitTermination(5, TimeUnit.SECONDS);
            kurir.awaitTermination(5, TimeUnit.SECONDS);
            monitorBar.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSistem selesai.");
    }
}