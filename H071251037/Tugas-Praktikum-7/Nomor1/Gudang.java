package Nomor1;

public class Gudang {
    int stok;
    int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }

    public synchronized void tambahStok(int jumlah){
        while (stok+jumlah > kapasitasMaksimal) {
            try {
                System.out.println("\nGudang sedang penuh, pemasok harus menunggu.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stok += jumlah;

        System.out.println("\nStok bertambah: " + jumlah);
        System.out.println("Total stok: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah){
        while (stok < jumlah) {
            try {
                System.out.println("\nStok tidak mencukupi, Kurir harus menunggu.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stok -= jumlah;
        
        System.out.println("\nStok yang diambil: " + jumlah);
        System.out.println("Total stok: " + stok);
        notifyAll();
    }
    
    public synchronized int getStok(){
        return stok;
    }

    public int getKapasitasMaksimal(){
        return kapasitasMaksimal;
    }
}
