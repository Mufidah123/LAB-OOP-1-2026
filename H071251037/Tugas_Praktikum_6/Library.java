package Tugas_Praktikum_6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<LibraryItem> items = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId) {
                return item;
            }
        }

        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public String getLibraryStatus() {
        String result = "";
        result += "+------+----------------------+------------+\n";
        result += "| ID   | Judul               | Status     |\n";
        result += "+------+----------------------+------------+\n";

        for (LibraryItem item : items) {
            String status;
            if (item.isBorrowed) {
                status = "Dipinjam";
            } else {
                status = "Tersedia";
            }

            result += String.format( "| %-4d | %-20s | %-10s |\n",
            item.itemId, item.title, status);
        }

        result += "+------+----------------------+------------+\n";
        return result;
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}