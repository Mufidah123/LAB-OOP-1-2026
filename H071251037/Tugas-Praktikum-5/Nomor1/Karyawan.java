package Nomor1;

abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran = 0;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    public void absen(){
        jumlahKehadiran++ ;
    }

    abstract int hitungGaji();

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    String getName(){
        return nama;
    }

    String getIdKaryawan(){
        return idKaryawan;
    }
}
