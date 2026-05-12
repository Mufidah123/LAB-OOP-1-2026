package Nomor1;

class KaryawanKontrak extends Karyawan {
    int upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, int upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    int hitungGaji() {
        int TotalGaji = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            TotalGaji += 500000;
        }
        return TotalGaji;
    }
}
