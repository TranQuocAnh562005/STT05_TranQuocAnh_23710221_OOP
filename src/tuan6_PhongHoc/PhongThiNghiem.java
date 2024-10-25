package tuan6_PhongHoc;

public class PhongThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && coBonRua;
    }

    @Override
    public String toString() {
        return String.format("%10s|-%10s|-%10.2f|-%10d|-%10s|-%10d|-%10s", getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(),
                chuyenNganh, sucChua, coBonRua ? "Co" : "Khong");
    }
}