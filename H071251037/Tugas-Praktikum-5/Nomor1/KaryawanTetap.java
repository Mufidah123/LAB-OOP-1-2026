package Nomor1;

class KaryawanTetap extends Karyawan {
    int gajiPokok;
    int tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, int gajiPokok, int tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    int hitungGaji(){
        int TotalGaji = gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return TotalGaji;
    }
    
    int hitungGaji (double bonusKinerja) {
        return hitungGaji() + (int) bonusKinerja;
    }
}