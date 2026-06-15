package Tugas_Praktikum_6;

public class DVD extends LibraryItem{
    int duration;

    public DVD(int duration, boolean isBorrowed, int itemId, String title) {
        super(isBorrowed, itemId, title);
    }
    
    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("DVD hanya bisa dipinjam maksimal 7 hari!");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    public void printDescDVD() {
        System.out.println(getDescription());
    }
}
