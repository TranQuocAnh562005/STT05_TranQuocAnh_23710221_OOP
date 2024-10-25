package tuan5_HangHoaSu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class QuanLyKho {
    private ArrayList<HangHoa> danhSachHang;

    public QuanLyKho() {
        danhSachHang = new ArrayList<>();
    }

    public void addHang(HangHoa hang) throws Exception {
    	if (!danhSachHang.contains(hang))// hiểu dc nhờ hascode equa của lớp sach
			danhSachHang.add(hang);
		else {
			throw new Exception("Mã Giao Dich đã trùng");
		}
    }

    public HangHoa timKiem(String maHang) {
        for (HangHoa hang : danhSachHang) {
            if (hang.maHang.equalsIgnoreCase(maHang)) {
                return hang;
            }
        }
        return null;
    }

    public boolean xoaHang(String maHang) {
        HangHoa hangToRemove = null;
        for (HangHoa hang : danhSachHang) {
            if (hang.getMaHang().equals(maHang)) {
                hangToRemove = hang;
                break;
            }
        }

        if (hangToRemove != null) {
            danhSachHang.remove(hangToRemove);
            return true; // Xóa thành công
        }
        return false; // Không tìm thấy hàng để xóa
    }


    public ArrayList<HangHoa> getListHangThucPham() {
        ArrayList<HangHoa> listThucPham = new ArrayList<>();
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangThucPham) {
                listThucPham.add(hang);
            }
        }
        return listThucPham;
    }

    public ArrayList<HangHoa> getListHangDienMay() {
        ArrayList<HangHoa> listDienMay = new ArrayList<>();
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangDienMay) {
                listDienMay.add(hang);
            }
        }
        return listDienMay;
    }

    public ArrayList<HangHoa> getListHangSanhSu() {
        ArrayList<HangHoa> listSanhSu = new ArrayList<>();
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangSanhSu) {
                listSanhSu.add(hang);
            }
        }
        return listSanhSu;
    }

    public ArrayList<HangHoa> getListHang() {
        return danhSachHang;
    }
    
 // Hàm sắp xếp theo số lượng
    public void sortTheoSoLuong() {
        Collections.sort(danhSachHang, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                return Integer.compare(o1.soLuongTon, o2.soLuongTon);
            }  
        });
        System.out.println("Đã sắp xếp theo số lượng.");
    }

    
    

	public void sortDonGia() {
		// TODO Auto-generated method stub
		 Collections.sort(danhSachHang, new Comparator<HangHoa>() {
	            public int compare(HangHoa o1, HangHoa o2) {
	                // So sánh đơn giá
	                int comp1 = Double.compare(o1.donGia, o2.donGia);

	                if (comp1 == 0) { // Nếu đơn giá bằng nhau, so sánh ngày nhập
	                    if (o1 instanceof HangThucPham && o2 instanceof HangThucPham) {
	                        return ((HangThucPham) o2).ngayHetHan.compareTo(((HangThucPham) o1).ngayHetHan); // So sánh ngày hết hạn giảm dần
	                    }
	                    return 0; // Hoặc xử lý cho các loại hàng khác nếu cần
	                } else {
	                    return comp1;
	                }
	            }
	        });
	        System.out.println("Đã sắp xếp theo đơn giá và ngày nhập.");
	}
}