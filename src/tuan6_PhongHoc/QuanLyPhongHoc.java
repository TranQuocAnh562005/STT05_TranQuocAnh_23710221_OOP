package tuan6_PhongHoc;

import java.util.*;

public class QuanLyPhongHoc {
    private List<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        danhSachPhongHoc = new ArrayList<>();
    }

    public boolean themPhongHoc(PhongHoc phongHoc) {
        for (PhongHoc ph : danhSachPhongHoc) {
            if (ph.getMaPhong().equals(phongHoc.getMaPhong())) {
                return false;
            }
        }
        danhSachPhongHoc.add(phongHoc);
        return true;
    }

    public PhongHoc timPhongHoc(String maPhong) {
        for (PhongHoc ph : danhSachPhongHoc) {
            if (ph.getMaPhong().equals(maPhong)) {
                return ph;
            }
        }
        return null;
    }

    public void inDanhSachPhongHoc() {
        for (PhongHoc ph : danhSachPhongHoc) {
            System.out.println(ph);
        }
    }

    public void inDanhSachPhongDatChuan() {
        for (PhongHoc ph : danhSachPhongHoc) {
            if (ph.datChuan()) {
                System.out.println(ph);
            }
        }
    }

    public void sapXepTheoDayNhaTangDan() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDayNha));
    }

    public void sapXepTheoDienTichGiamDan() {
        Collections.sort(danhSachPhongHoc, (ph1, ph2) -> Double.compare(ph2.getDienTich(), ph1.getDienTich()));
    }

    public void sapXepTheoSoBongDenTangDan() {
        Collections.sort(danhSachPhongHoc, Comparator.comparingInt(PhongHoc::getSoBongDen));
    }

    public boolean capNhatSoMayTinh(String maPhong, int soMayTinh) {
        PhongHoc phongHoc = timPhongHoc(maPhong);
        if (phongHoc instanceof PhongMayTinh) {
            ((PhongMayTinh) phongHoc).capNhatSoMayTinh(soMayTinh);
            return true;
        }
        return false;
    }

    public boolean xoaPhongHoc(String maPhong) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn có chắc chắn muốn xóa phòng " + maPhong + "? (y/n)");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            return danhSachPhongHoc.removeIf(ph -> ph.getMaPhong().equals(maPhong));
        }
        return false;
    }

    public int tongSoPhongHoc() {
        return danhSachPhongHoc.size();
    }

    public void inDanhSachPhongMay60May() {
        for (PhongHoc ph : danhSachPhongHoc) {
            if (ph instanceof PhongMayTinh && ((PhongMayTinh) ph).getSoMayTinh() == 60) {
                System.out.println(ph);
            }
        }
    }
}