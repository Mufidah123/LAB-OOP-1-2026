package Nomor2;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Lampu berfungsi dengan baik");
    }

    @Override
    public String prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else if (perintah.equalsIgnoreCase("MATI")) {
            System.out.println("Lampu dimatikan.");
        }
        return perintah;
    }
}
