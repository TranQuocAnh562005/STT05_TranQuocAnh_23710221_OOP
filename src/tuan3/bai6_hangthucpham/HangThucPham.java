package tuan3.bai6_hangthucpham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.DecimalFormat;

public class HangThucPham {
    private static final String DEFAULT_MA_HANG = "UNKNOWN";
    private static final String DEFAULT_TEN_HANG = "UNKNOWN";
    private static final double DEFAULT_DON_GIA = 0.0;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, String ngaySanXuat, String ngayHetHan) {
        this.maHang = validateMaHang(maHang) ? maHang : DEFAULT_MA_HANG;
        this.tenHang = validateTenHang(tenHang) ? tenHang : DEFAULT_TEN_HANG;
        this.donGia = validateDonGia(donGia) ? donGia : DEFAULT_DON_GIA;
        this.ngaySanXuat = parseDate(ngaySanXuat);
        this.ngayHetHan = parseDate(ngayHetHan);
        if (!isValidNgayHetHan(this.ngaySanXuat, this.ngayHetHan)) {
            this.ngayHetHan = this.ngaySanXuat; // Gán ngày hết hạn mặc định là ngày sản xuất
        }
    }

    // Constructor với tham số mã hàng
    public HangThucPham(String maHang) {
        this(maHang, DEFAULT_TEN_HANG, DEFAULT_DON_GIA, LocalDate.now().format(DATE_FORMAT), LocalDate.now().format(DATE_FORMAT));
    }

    // Setters
    public void setMaHang(String maHang) {
        this.maHang = validateMaHang(maHang) ? maHang : DEFAULT_MA_HANG;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = validateTenHang(tenHang) ? tenHang : DEFAULT_TEN_HANG;
    }

    public void setDonGia(double donGia) {
        this.donGia = validateDonGia(donGia) ? donGia : DEFAULT_DON_GIA;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        LocalDate parsedDate = parseDate(ngaySanXuat);
        if (parsedDate != null) {
            this.ngaySanXuat = parsedDate;
            if (this.ngayHetHan != null && !isValidNgayHetHan(this.ngaySanXuat, this.ngayHetHan)) {
                this.ngayHetHan = this.ngaySanXuat;
            }
        }
    }

    public void setNgayHetHan(String ngayHetHan) {
        LocalDate parsedDate = parseDate(ngayHetHan);
        if (parsedDate != null && isValidNgayHetHan(this.ngaySanXuat, parsedDate)) {
            this.ngayHetHan = parsedDate;
        } else {
            this.ngayHetHan = this.ngaySanXuat;
        }
    }

    // Getters
    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat.format(DATE_FORMAT);
    }

    public String getNgayHetHan() {
        return ngayHetHan.format(DATE_FORMAT);
    }

    public boolean isExpired() {
        return ngayHetHan.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return String.format("Mã hàng: %s\nTên hàng: %s\nĐơn giá: %s VNĐ\nNgày sản xuất: %s\nNgày hết hạn: %s\n",
                maHang, tenHang, df.format(donGia), getNgaySanXuat(), getNgayHetHan());
    }

    private boolean validateMaHang(String maHang) {
        return maHang != null && !maHang.trim().isEmpty();
    }

    private boolean validateTenHang(String tenHang) {
        return tenHang != null && !tenHang.trim().isEmpty();
    }

    private boolean validateDonGia(double donGia) {
        return donGia > 0;
    }

    private boolean isValidNgayHetHan(LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        return ngayHetHan != null && ngaySanXuat != null && ngayHetHan.isAfter(ngaySanXuat);
    }

    private LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
