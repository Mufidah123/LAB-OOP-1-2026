package Nomor1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Bola");
        System.out.println("4. Tabung");
        pembatas();

        System.out.println("\n===== BANGUN DATAR =====");
        System.out.println("5. Persegi");
        System.out.println("6. Persegi Panjang");
        System.out.println("7. Lingkaran");
        System.out.println("8. Trapesium");
        pembatas();

        System.out.print(">> Pilihan: ");
        int pilih = input.nextInt();
        pembatas();

        switch (pilih) {
            // Bangun ruang
            case 1 -> {
                System.out.println("\n=== KUBUS ===");
                System.out.print("Masukkan sisi: ");
                double s = input.nextDouble();
                BangunRuang obj = new Kubus(s);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Volume: " + obj.hitungVolume());
            }
            case 2 -> {
                System.out.println("\n=== BALOK ===");
                System.out.print("Panjang: "); double p = input.nextDouble();
                System.out.print("Lebar: "); double l = input.nextDouble();
                System.out.print("Tinggi: "); double t = input.nextDouble();

                BangunRuang obj = new Balok(p,l,t);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Volume: " + obj.hitungVolume());
            }
            case 3 -> {
                System.out.println("\n=== BOLA ===");
                System.out.print("Jari-jari: ");
                double r = input.nextDouble();

                BangunRuang obj = new Bola(r);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Volume: " + obj.hitungVolume());
            }
            case 4 -> {
                System.out.println("\n=== TABUNG ===");
                System.out.print("Jari-jari: "); double r = input.nextDouble();
                System.out.print("Tinggi: "); double t = input.nextDouble();

                BangunRuang obj = new Tabung(r,t);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Volume: " + obj.hitungVolume());
            }

            // Bangun Datar
            case 5 -> {
                System.out.println("\n=== PESERGI ===");
                System.out.print("Sisi: ");
                double s = input.nextDouble();

                BangunDatar obj = new Persegi(s);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Keliling: " + obj.hitungKeliling());
            }
            case 6 -> {
                System.out.println("\n=== PESERGI PANJANG ===");
                System.out.print("Panjang: "); double p = input.nextDouble();
                System.out.print("Lebar: "); double l = input.nextDouble();

                BangunDatar obj = new PersegiPanjang(p,l);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Keliling: " + obj.hitungKeliling());
            }
            case 7 -> {
                System.out.println("\n=== LINGKARAN ===");
                System.out.print("Jari-jari: ");
                double r = input.nextDouble();

                BangunDatar obj = new Lingkaran(r);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Keliling: " + obj.hitungKeliling());
            }
            case 8 -> {
                System.out.println("\n=== TRAPESIUM ===");
                System.out.print("Sisi 1: "); double a = input.nextDouble();
                System.out.print("Sisi 2: "); double b = input.nextDouble();
                System.out.print("Sisi 3: "); double c = input.nextDouble();
                System.out.print("Sisi 4: "); double d = input.nextDouble();
                System.out.print("Tinggi: "); double t = input.nextDouble();

                BangunDatar obj = new Trapesium(a,b,c,d,t);

                System.out.println("Luas: " + obj.hitungLuas());
                System.out.println("Keliling: " + obj.hitungKeliling());
            }

            default -> System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }

    public static void pembatas() {
        System.out.println("------------------------");
    }
}