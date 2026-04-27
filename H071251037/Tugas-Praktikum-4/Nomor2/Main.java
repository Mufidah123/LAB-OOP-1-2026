package Nomor2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Smartphone("Poco F4", 787920, 8000000, 6.67, 225));
        products.add(new Laptop("Asus", 268561, 15600000, 16, "Intel Core i9"));
        products.add(new Camera("Canon", 456789, 12000000, 24, "Telephoto"));

        do {
            System.out.println("\n=== PILIHAN MENU ===");
            System.out.println("1. Tambah Produk \n2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk \n4. Keluar");

            System.out.print("\n>> Pilih menu (1-4): ");
            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1){
                System.out.print("Masukkan nama produk: ");
                String brand = input.nextLine();

                System.out.print("Masukkan nomor seri: ");
                int sn = input.nextInt();

                System.out.print("Masukkan harga: ");
                double price = input.nextDouble();

                pembatas();
                System.out.println("=== Tipe produk ===");
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");

                System.out.print("Pilih tipe produk (1-3): ");
                int tipe = input.nextInt();

                switch (tipe) {
                    case 1 -> {
                        System.out.print("Masukkan ukuran layar (inci): ");
                        double screen = input.nextDouble();
                        System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                        int storage = input.nextInt();
                        products.add(new Smartphone(brand, sn, price, screen, storage));
                    }
                    case 2 -> {
                        System.out.print("Masukkan ukuran RAM (GB): ");
                        int ram = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan tipe prosesor: ");
                        String proc = input.nextLine();
                        products.add(new Laptop(brand, sn, price, ram, proc));
                    }
                    case 3 -> {
                        System.out.print("Masukkan resolusi (MP): ");
                        int res = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan jenis lensa: ");
                        String lens = input.nextLine();
                        products.add(new Camera(brand, sn, price, res, lens));
                    }
                    default -> {
                        System.out.println("Tipe tidak valid!");
                    }
                }
                
                System.out.println("Produk berhasil ditambahkan!");
            } else if (menu == 2){
                if (products.isEmpty()) {
                    System.out.println("Belum ada produk.");
                } else {
                    System.out.println("=== Daftar Produk ===");
                    for (Product item : products) {
                        item.displayInfo();
                        pembatas();
                    }
                }
            } else if (menu == 3){
                System.out.print("Masukkan nomor seri produk: ");
                int cari = input.nextInt();
                boolean found = false;

                for (Product item : products) {
                    if (item.seriesNumber == cari) {
                        System.out.println("=== Info Produk ===");
                        item.displayInfo();
                        products.remove(item);
                        System.out.println("Produk dengan nomor seri tersebut berhasil dibeli!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                }
            } else if (menu == 4){
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                System.out.println("Keluar dari program...");
                break;
            } else{
                System.out.println("Plihan menu tidak tersedia!");
            }
        } while (true);

        input.close();
    }

    public static void pembatas() {
        System.out.println("--------------------------------------");
    }
}
