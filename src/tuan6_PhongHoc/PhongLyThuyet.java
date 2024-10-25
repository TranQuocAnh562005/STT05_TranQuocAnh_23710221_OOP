package tuan6_PhongHoc;

public class PhongLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && coMayChieu;
    }

    @Override
    public String toString() {
        return String.format("%10s|-%10s|-%10.2f|-%10d|-%10s", getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(),
                coMayChieu ? "Co" : "Khong");
    }
}