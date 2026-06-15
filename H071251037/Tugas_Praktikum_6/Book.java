package Tugas_Praktikum_6;

public class Book extends LibraryItem{
    String author;

    public Book(String author, boolean isBorrowed, int itemId, String title) {
        super(isBorrowed, itemId, title);
        this.author = author;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal 14 hari!");
        }
        if (isBorrowed) {
            throw new IllegalArgumentException("Buku sedang dipinjam dan belum dikembalikan.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    public void printDescBooks() {
        System.out.println(getDescription());
    }
}