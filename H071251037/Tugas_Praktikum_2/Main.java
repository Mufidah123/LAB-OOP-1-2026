package Tugas_Praktikum_2;

public class Main {
    public static void main(String[] args) {
        
        Skill santet = new Skill("Santet Hitam", 40);
        Hantu wewe = new Hantu("Wewe Gombel", "Perempuan", "Jawa Tengah", 100, santet);

        Skill jerit = new Skill();
        jerit.setNamaSkill("Jeritan Malam");
        Hantu kuntilanak = new Hantu();
        kuntilanak.setNama("Kuntilanak");
        kuntilanak.setSkill(jerit);
        kuntilanak.setHp(80);

        Manusia manusia = new Manusia("Budi", 50, 2);

        wewe.status();
        pembatas();

        kuntilanak.status();
        pembatas();

        int ronde = 1;

        while (wewe.isHidup() && kuntilanak.isHidup()) {

            System.out.println("RONDE " + ronde);

            wewe.serang(kuntilanak);

            if (kuntilanak.isHidup()) {
                kuntilanak.serang(wewe);
            }

            if (ronde == 4) {
                System.out.println("Energi gaib meningkat, serangan jadi lebih kuat!");
                wewe.getSkill().setDamage(wewe.getSkill().getDamage() + 20);
                kuntilanak.getSkill().setDamage(kuntilanak.getSkill().getDamage() + 10);
            }

            if (wewe.getHp() > 30 && wewe.getHp() <= 50) {
                wewe.mintaSesajen(manusia);
            } else if (wewe.getHp() <= 30) {
                wewe.mintaTumbal(manusia);
            }

            if (kuntilanak.getHp() > 30 && kuntilanak.getHp() <= 50) {
                kuntilanak.mintaSesajen(manusia);
            } else if (kuntilanak.getHp() <= 30) {
                kuntilanak.mintaTumbal(manusia);
            }

            wewe.status();
            pembatas();

            kuntilanak.status();
            pembatas();

            ronde++;
        }

        if (!wewe.isHidup()) {
            System.out.println(wewe.getNama() + " kalah (kehabisan energi gaib)!");
        } else {
            System.out.println(kuntilanak.getNama() + " kalah (kehabisan energi gaib)!");
        }
    }

    public static void pembatas() {
        System.out.println("==========================================");
    }
}