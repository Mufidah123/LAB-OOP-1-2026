package Nomor1;

public class BangunDatar {
    public double hitungLuas(){
        return 0;
    }
    public double hitungKeliling(){
        return 0;
    }
}

class Persegi extends BangunDatar {
    double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuas() {
        return sisi * sisi;
    }

    public double hitungKeliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;

    public PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    public double hitungLuas() {
        return p * l;
    }

    public double hitungKeliling() {
        return 2 * (p + l);
    }
}

class Lingkaran extends BangunDatar {
    double r;

    public Lingkaran(double r) {
        this.r = r;
    }

    public double hitungLuas() {
        return Math.PI * r * r;
    }

    public double hitungKeliling() {
        return 2 * Math.PI * r;
    }
}

class Trapesium extends BangunDatar {
    double a, b, c, d, t;

    public Trapesium(double a, double b, double c, double d, double t) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.t = t;
    }

    public double hitungLuas() {
        return ((a + b) / 2) * t;
    }

    public double hitungKeliling() {
        return a + b + c + d;
    }
}