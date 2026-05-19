package Nomor1;
import java.util.Random;

public class Kurir implements Runnable{
    Gudang gudang;
    private boolean running = true;

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }
    public void stop() {
        running = false;
    }

    @Override
    public void run(){
        Random random = new Random();

        while(running){
            int jumlah = random.nextInt(10) + 1;
            gudang.ambilStok(jumlah);

            try {
                int delay = random.nextInt(1001) + 2000;
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}