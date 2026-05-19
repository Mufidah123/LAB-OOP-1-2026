package Nomor1;

public class Monitoring implements Runnable{
    private Gudang gudang;
    private boolean running = true;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }
    public void stop() {
        running = false;
    }

    @Override
    public void run(){
        while(running){
            int persentase = (gudang.getStok() * 100) / gudang.getKapasitasMaksimal();
            int panjangBar = persentase / 5;

            String bar = "";
            // Isi persentasenya
            for (int i = 0; i < panjangBar; i++) {
                bar += "#";
            }
            // Sisanya
            for (int i = panjangBar; i < 20; i++) {
                bar += "-";
            }

            System.out.println("Status Gudang: ["+ bar +"] "+persentase+ "%");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
