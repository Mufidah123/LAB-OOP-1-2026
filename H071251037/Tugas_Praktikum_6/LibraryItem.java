package Tugas_Praktikum_6;

abstract class LibraryItem {
    String title;
    int itemId;
    boolean isBorrowed;

    public LibraryItem(boolean isBorrowed, int itemId, String title) {
        this.isBorrowed = isBorrowed;
        this.itemId = itemId;
        this.title = title;
    }

    abstract String getDescription();
    abstract String borrowItem(int days);
    abstract double calculateFine (int daysLate);

    public String returnItem() {
        isBorrowed = false;
        return title + " dikembalikan";
    }
}

