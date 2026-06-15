package Tugas_Praktikum_6;

import java.util.List;

public class Member {

    String name;
    String memberId;
    List<LibraryItem> borrowedItems;

    public Member(String name, String memberId, List<LibraryItem> borrowedItems) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = borrowedItems;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " sedang dipinjam");
        }

        String result = item.borrowItem(days);
        borrowedItems.add(item);

        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);

        return "Item " + item.title +
                " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {

        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        System.out.println("+---------+----------------------+");
        System.out.println("|   ID    |        Judul         |");
        System.out.println("+---------+----------------------+");

        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-7d | %-20s |\n", item.itemId, item.title);
        }

        System.out.println("+---------+----------------------+");
    }
}