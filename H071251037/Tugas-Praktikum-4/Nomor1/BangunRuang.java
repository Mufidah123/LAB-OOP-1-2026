package Nomor1;

public class BangunRuang {
    public double hitungLuas(){
        return 0;
    }
    public double hitungVolume(){
        return 0;
    }
}

class Kubus extends BangunRuang {
    double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuas(){
        return 6 * sisi * sisi;
    }

    public double hitungVolume() {
        return sisi * sisi * sisi;
    }
}

class Balok extends BangunRuang {
    double p, l, t;

    public Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    public double hitungLuas(){
        return 2 * (p*l + p*t + l*t);
    }

    public double hitungVolume() {
        return p * l * t;
    }
}

class Bola extends BangunRuang {
    double r;

    public Bola(double r) {
        this.r = r;
    }

    public double hitungLuas(){
        return 4 * Math.PI * r * r;
    }

    public double hitungVolume() {
        return (4.0/3) * Math.PI * r * r * r;
    }
}

class Tabung extends BangunRuang {
    double r, t;

    public Tabung(double r, double t) {
        this.r = r;
        this.t = t;
    }

    public double hitungLuas(){
        return 2 * Math.PI * r * (r + t);
    }

    public double hitungVolume() {
        return Math.PI * r * r * t;
    }
}