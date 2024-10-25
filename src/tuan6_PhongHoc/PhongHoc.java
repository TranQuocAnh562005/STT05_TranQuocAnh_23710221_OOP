package tuan6_PhongHoc;

public abstract class PhongHoc {
    private String maPhong;
    private String dayNha;
    private double dienTich;
    private int soBongDen;

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public boolean duAnhSang() {
        return (dienTich / soBongDen) <= 10;
    }

    public abstract boolean datChuan();

    @Override
    public String toString() {
        return String.format("%10s|-%10s|-%10.2f|-%10d", maPhong, dayNha, dienTich, soBongDen);
    }
}