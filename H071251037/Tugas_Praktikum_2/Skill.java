package Tugas_Praktikum_2;

public class Skill {
    String namaSkill;
    int damage;

    public Skill() {
        this.namaSkill = "Belum diketahui";
        this.damage = 30;
    }

    public Skill(String namaSkill, int damage) {
        this.namaSkill = namaSkill;
        this.damage = damage;
    }

    public String getNamaSkill() {
        return namaSkill;
    }
    public void setNamaSkill(String namaSkill) {
        this.namaSkill = namaSkill;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}