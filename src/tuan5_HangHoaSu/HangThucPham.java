package tuan5_HangHoaSu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    protected LocalDate ngayHetHan;
    private String nhaCungCap;

    // Constructor
    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, 
                        String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        super(maHang, tenHang, soLuongTon, donGia, "Thực phẩm"); // Loại hàng
        this.nhaCungCap = nhaCungCap;

        // Chuyển đổi từ String sang LocalDate
        this.ngaySanXuat =ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        
        // Kiểm tra ngày hết hạn phải sau hoặc bằng ngày sản xuất
        if (this.ngayHetHan.isBefore(this.ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất.");
        }
    }

    public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
    public double tinhVAT() {
        return tinhGiaBan() * 0.05; // Tính VAT cho hàng thực phẩm
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (soLuongTon > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
    	 String ngaySanXuatFormatted = ( ngaySanXuat != null) ? 
    			 ngaySanXuat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
    	 String ngayHetHanFormatted = ( ngaySanXuat != null) ? 
    			 ngaySanXuat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
        return super.toString() + String.format("|%-20s|%-15s|%-15s|%-10.2f",
                 nhaCungCap, ngaySanXuatFormatted, ngayHetHanFormatted, tinhVAT());
    }


}

