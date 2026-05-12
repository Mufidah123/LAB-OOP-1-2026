package Nomor2;

public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Speaker siap digunakan.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung ke WiFi.");
    }

    @Override
    public String prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: " + perintah);
        return perintah;
    }
}
