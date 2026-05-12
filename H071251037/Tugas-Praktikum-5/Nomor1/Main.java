package Nomor1;
// D:\Java Project\Nomor1

public class Main {
    public static void main(String[] args) {
        // Karyawan Tetap
        KaryawanTetap kt = new KaryawanTetap("Viola", "H071251043", 5000000, 20000);

        kt.absen();
        kt.absen();
        kt.absen();
        
        int gajiTetap = kt.hitungGaji(2500000);
        System.out.println("\n=== Identitas Karyawan Tetap ===");
        System.out.println("Nama : " + kt.getName());
        System.out.println("ID Karyawan : " + kt.getIdKaryawan());
        System.out.printf("Total gaji %s : Rp%,d\n", kt.getName(), gajiTetap);
        
        // Karyawan Kontrak
        KaryawanKontrak kk = new KaryawanKontrak("Vivien", "H071251036", 150000);

        for (int i = 0; i < 22; i++) {
            kk.absen();
        }

        int gajiKontrak = kk.hitungGaji();
        System.out.println("\n=== Identitas Karyawan Kontrak ===");
        System.out.println("Nama : " + kk.getName());
        System.out.println("ID Karyawan : " + kk.getIdKaryawan());
        System.out.printf("Total gaji %s : Rp%,d\n", kk.getName(), gajiKontrak);
    }
}
