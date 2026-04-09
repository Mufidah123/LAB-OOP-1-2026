package Tugas_Praktikum_2;

public class Manusia {
    String nama;
    int energi;
    int levelKepercayaan;

    // public Manusia() {}

    public Manusia(String nama, int energi, int levelKepercayaan) {
        this.nama = nama;
        this.energi = energi;
        this.levelKepercayaan = levelKepercayaan;
    }

    public int beriSesajen() {
        if (energi >= 5) {
            energi -= 5;
            return 10 * levelKepercayaan;
        }
        return 0;
    }

    public int jadiTumbal() {
        if (energi >= 10) {
            energi -= 10;
            return 20 * levelKepercayaan;
        }
        return 0;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
}