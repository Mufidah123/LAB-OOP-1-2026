package Tugas_Praktikum_2;

public class Hantu {
    String nama;
    String gender;
    String asal;
    int hp;
    Skill skill;

    public Hantu() {
        this.nama = "Hantu Tidak Dikenal";
        this.gender = "Perempuan";
        this.asal = "Kalimantan Barat";
        this.hp = 0;
        this.skill = new Skill("Tidak Ada", 0);
    }

    public Hantu(String nama, String gender, String asal, int hp, Skill skill) {
        this.nama = nama;
        this.gender = gender;
        this.asal = asal;
        this.hp = hp;
        this.skill = skill;
    }

    public void serang(Hantu musuh) {
        if (this.isHidup() && musuh.isHidup()) {
            int damage = skill.getDamage();
            musuh.hp -= damage;
            if (musuh.hp < 0) { // Ini agar HP-nya tidak sampai minus
                musuh.hp = 0;
            }
            System.out.println(nama + " menyerang " + musuh.nama + " dengan " + skill.getNamaSkill() + " (damage: " + damage + ")");
        }
    }

    public void mintaSesajen(Manusia manusia) {
        int tambahan = manusia.beriSesajen();
        hp += tambahan;
        System.out.println(nama + " menerima sesajen, HP +" + tambahan);
    }

    public void mintaTumbal(Manusia manusia) {
        int tambahan = manusia.jadiTumbal();
        hp += tambahan;
        System.out.println(nama + " mendapatkan tumbal, HP +" + tambahan);
    }

    public boolean isHidup() {
        return hp > 0;
    }

    // public void status() {
    //     System.out.println(nama + " | HP: " + hp);
    // }

    public void status() {
        System.out.printf("\n=========== %s Status ===========\n",nama);
        System.out.println("Nama   : " + nama);
        System.out.println("Gender : " + gender);
        System.out.println("Asal   : " + asal);
        System.out.println("HP     : " + hp);
        System.out.println("Skill  : " + skill.getNamaSkill() + " (Damage: " + skill.getDamage() + ")");
    }

    public String getNama() {
        return nama;
    }
    public int getHp() {
        return hp;
    }
    public Skill getSkill() {
        return skill;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}