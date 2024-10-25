package tuan3.bai8_cd;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
	private CD[] danhSachCD;
	private int soLuongCD;

	// Constructor
	public CDList(int size) {
		danhSachCD = new CD[size];
		soLuongCD = 0;
	}

	// Thêm CD vào danh sách
	public boolean themCD(CD cd) {
	    if (soLuongCD >= danhSachCD.length) {
	        // Mở rộng mảng khi đầy
	        CD[] danhSachCDMoi = new CD[danhSachCD.length * 2]; // Tăng gấp đôi kích thước
	        for (int i = 0; i < danhSachCD.length; i++) {
	            danhSachCDMoi[i] = danhSachCD[i];
	        }
	        danhSachCD = danhSachCDMoi; // Gán mảng mới vào danh sách CD
	    }
	    
	    // Kiểm tra mã CD trùng
	    for (int i = 0; i < soLuongCD; i++) {
	        if (danhSachCD[i].getMaCD() == cd.getMaCD()) {
	            return false; // CD đã tồn tại
	        }
	    }
	    
	    // Thêm CD vào danh sách
	    danhSachCD[soLuongCD++] = cd;
	    return true;
	}


	
	public int getSoLuongCD() {
		return soLuongCD;
	}


	public double tongGiaThanh() {
		double tong = 0;
		for (int i = 0; i < soLuongCD; i++) {
			tong += danhSachCD[i].getGiaThanh();
		}
		return tong;
	}

	
	public void sapXepTheoGiaThanh() {
		Arrays.sort(danhSachCD, 0, soLuongCD, new Comparator<CD>() {
			@Override
			public int compare(CD cd1, CD cd2) {
				return Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh());
			}
		});
	}


	public void sapXepTheoTuaCD() {
		Arrays.sort(danhSachCD, 0, soLuongCD, new Comparator<CD>() {
			@Override
			public int compare(CD cd1, CD cd2) {
				return cd1.getTuaCD().compareTo(cd2.getTuaCD());
			}
		});
	}

	
	public void xuatDanhSach() {
		for (int i = 0; i < soLuongCD; i++) {
			System.out.println(danhSachCD[i]);
		}
	}
	public void nhapCung() {
	    CD cd1 = new CD(1, "Những Bài Hát Bất Hủ", "Ca Sỹ A", 10, 150000);
	    CD cd2 = new CD(2, "Hits of 2023", "Ca Sỹ B", 8, 200000);
	    CD cd3 = new CD(3, "Classical Music", "Ca Sỹ C", 12, 180000);
	    CD cd4 = new CD(4, "Pop Ballad", "Ca Sỹ D", 9, 170000);
	    CD cd5 = new CD(5, "Rock Legends", "Ca Sỹ E", 15, 250000);

	    themCD(cd1);
	    themCD(cd2);
	    themCD(cd3);
	    themCD(cd4);
	    themCD(cd5);
	    
	    System.out.println("Đã nhập cứng danh sách CD:");
	    xuatDanhSach();
	}

	

}
