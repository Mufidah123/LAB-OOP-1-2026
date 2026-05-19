package Nomor1;
import java.util.Random;

public class Pemasok implements Runnable{
    Gudang gudang;
    private boolean running = true;

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }
    public void stop() {
        running = false;
    }

    @Override
    public void run(){
        Random random = new Random();

        while(running){
            int jumlah = random.nextInt(20) + 1;
            gudang.tambahStok(jumlah);

            try {
                int delay = random.nextInt(1000) + 1000;
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
