package Nomor2;

abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    abstract void cekFungsi();

    public PerangkatElektronik(String merk, int dayaListrik){
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public void infoPower() {
        System.out.printf("Perangkat %s sedang menyedot daya sebesar %d Watt\n", merk, dayaListrik);
    }
}

interface InteraksiInternet {
    void hubungkanWiFi();
}

interface KontrolSuara {
    String prosesPerintah(String perintah);
}