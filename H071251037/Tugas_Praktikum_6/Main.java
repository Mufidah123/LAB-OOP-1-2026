package Tugas_Praktikum_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\nItem yang tersedia:");
                    System.out.println("1. Book");
                    System.out.println("2. DVD");

                    System.out.print("\nPilih jenis item: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Masukkan judul: ");
                    String title = input.nextLine();

                    System.out.print("Masukkan ID item: ");
                    int itemId = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {
                        System.out.print("Masukkan author: ");
                        String author = input.nextLine();

                        Book book = new Book(author, false, itemId, title);
                        System.out.println(
                                library.addItem(book)
                        );
                    } else if (jenis == 2) {
                        System.out.print("Masukkan durasi: ");
                        int duration = input.nextInt();

                        DVD dvd = new DVD(duration, false, itemId, title);
                        System.out.println(
                                library.addItem(dvd)
                        );
                    }
                    break;

                case 2:
                    System.out.print("Nama anggota: ");
                    input.nextLine();
                    String name = input.nextLine();

                    System.out.print("ID anggota: ");
                    String memberId = input.nextLine();

                    Member member = new Member(name, memberId, new ArrayList<>());
                    library.members.add(member);
                    System.out.println("Anggota berhasil ditambahkan");
                    break;

                case 3:
                    System.out.print("Masukkan ID anggota: ");
                    input.nextLine();
                    String borrowMemberId = input.nextLine();

                    System.out.print("Masukkan ID item: ");
                    int borrowItemId = input.nextInt();

                    System.out.print("Jumlah hari: ");
                    int days = input.nextInt();
                    input.nextLine();

                    Member borrowMember = null;
                    for (Member ms : library.members) {
                        if (ms.memberId.equals(borrowMemberId)) {
                            borrowMember = ms;
                        }
                    }
                    if (borrowMember == null) {
                        System.out.println("Member tidak ditemukan");
                        break;
                    }

                    try {
                        LibraryItem item = library.findItemById(borrowItemId);
                        String result = borrowMember.borrow(item, days);
                        library.logger.logActivity(
                                library.logger.getCurrentTime(),
                                item.title,
                                borrowMember.memberId,
                                "-"
                        );
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID anggota: ");
                    input.nextLine();
                    String returnMemberId = input.nextLine();

                    System.out.print("Masukkan ID item: ");
                    int returnItemId = input.nextInt();

                    System.out.print("Hari keterlambatan: ");
                    int late = input.nextInt();
                    input.nextLine();

                    Member returnMember = null;
                    for (Member ms : library.members) {
                        if (ms.memberId.equals(returnMemberId)) {
                            returnMember = ms;
                        }
                    }
                    if (returnMember == null) {
                        System.out.println("Member tidak ditemukan");
                        break;
                    }

                    try {
                        LibraryItem item = library.findItemById(returnItemId);
                        String result = returnMember.returnItem(item, late);
                        library.logger.logActivity(
                                library.logger.getCurrentTime(),
                                item.title,
                                returnMember.memberId,
                                library.logger.getCurrentTime()
                        );

                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println(library.getLibraryStatus());
                    break;

                case 6:
                    System.out.println(library.getAllLogs());
                    break;

                case 7:

                    boolean adaData = false;

                    for (Member m : library.members) {

                        if (!m.borrowedItems.isEmpty()) {
                            m.getBorrowedItems();
                            adaData = true;
                        }
                    }

                    if (!adaData) {
                        System.out.println("Tidak ada item yang sedang dipinjam");
                    }

                    break;

                case 8:
                    System.out.println("Keluar dari program...");
                    return;

                default:
                    System.out.println("Menu tidak valid, Pilih menu yang tersedia!");
            }
        }
    }
}