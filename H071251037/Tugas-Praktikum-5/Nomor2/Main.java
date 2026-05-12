package Nomor2;

public class Main {
    public static void main(String[] args) {

        // Instansiasi SmartLamp
        SmartLamp lamp = new SmartLamp("Philips", 60);
        lamp.infoPower();
        lamp.cekFungsi();

        lamp.prosesPerintah("NYALA");
        lamp.prosesPerintah("Mati");
        System.out.println();
        
        // Instansiasi SmartCCTV
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 100);
        cctv.infoPower();
        cctv.cekFungsi();

        cctv.hubungkanWiFi();
        System.out.println();

        // Instansiasi SmartSpeaker
        SmartSpeaker speaker = new SmartSpeaker("Samsung", 80);
        speaker.infoPower();
        speaker.cekFungsi();

        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Play music");
    }
}