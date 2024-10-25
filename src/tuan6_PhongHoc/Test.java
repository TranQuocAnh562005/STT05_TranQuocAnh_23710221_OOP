package tuan6_PhongHoc;
import java.util.Scanner;

public class Test {
    static void tieuDe() {
        System.out.println("====================================================================================================");
        System.out.println(String.format("%10s|-%10s|-%10s|-%10s|-%10s", "Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Thông tin thêm"));
    }

    static void nhapCung() {
        QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();
        PhongLyThuyet phongLyThuyet = new PhongLyThuyet("LT001", "D1", 30, 5, true);
        PhongMayTinh phongMayTinh = new PhongMayTinh("MT001", "D2", 40, 6, 50);
        PhongThiNghiem phongThiNghiem = new PhongThiNghiem("TN001", "D3", 50, 8, "Hóa học", 30, true);

        quanLyPhongHoc.themPhongHoc(phongLyThuyet);
        quanLyPhongHoc.themPhongHoc(phongMayTinh);
        quanLyPhongHoc.themPhongHoc(phongThiNghiem);

        System.out.println("Danh sách phòng học (nhập cứng): ");
        quanLyPhongHoc.inDanhSachPhongHoc();
    }

    static void nhap() {
        QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm phòng học");
            System.out.println("2. Tìm kiếm phòng học");
            System.out.println("3. In danh sách phòng học");
            System.out.println("4. In danh sách phòng đạt chuẩn");
            System.out.println("5. Sắp xếp theo dãy nhà tăng dần");
            System.out.println("6. Sắp xếp theo diện tích giảm dần");
            System.out.println("7. Sắp xếp theo số bóng đèn tăng dần");
            System.out.println("8. Cập nhật số máy tính");
            System.out.println("9. Xóa phòng học");
            System.out.println("10. In tổng số phòng học");
            System.out.println("11. In danh sách phòng máy có 60 máy");
            System.out.println("12 Nhập cứng");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Nhập phòng học từ người dùng
                    System.out.println("Chọn loại phòng học:");
                    System.out.println("1. Phòng lý thuyết");
                    System.out.println("2. Phòng máy tính");
                    System.out.println("3. Phòng thí nghiệm");
                    int loaiPhong = sc.nextInt();
                    sc.nextLine(); // Bỏ qua dòng mới sau khi nhập số

                    System.out.print("Nhập mã phòng: ");
                    String maPhong = sc.nextLine();
                    System.out.print("Nhập dãy nhà: ");
                    String dayNha = sc.nextLine();
                    System.out.print("Nhập diện tích (m2): ");
                    double dienTich = sc.nextDouble();
                    System.out.print("Nhập số bóng đèn: ");
                    int soBongDen = sc.nextInt();

                    switch (loaiPhong) {
                        case 1:
                            System.out.print("Phòng có máy chiếu không? (true/false): ");
                            boolean coMayChieu = sc.nextBoolean();
                            PhongHoc phongLyThuyet = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                            if (quanLyPhongHoc.themPhongHoc(phongLyThuyet)) {
                                System.out.println("Thêm phòng lý thuyết thành công!");
                            } else {
                                System.out.println("Mã phòng bị trùng!");
                            }
                            break;
                        case 2:
                            System.out.print("Nhập số lượng máy tính: ");
                            int soMayTinh = sc.nextInt();
                            PhongHoc phongMayTinh = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                            if (quanLyPhongHoc.themPhongHoc(phongMayTinh)) {
                                System.out.println("Thêm phòng máy tính thành công!");
                            } else {
                                System.out.println("Mã phòng bị trùng!");
                            }
                            break;
                        case 3:
                            sc.nextLine(); // Bỏ qua dòng mới sau khi nhập số
                            System.out.print("Nhập chuyên ngành: ");
                            String chuyenNganh = sc.nextLine();
                            System.out.print("Nhập sức chứa: ");
                            int sucChua = sc.nextInt();
                            System.out.print("Phòng có bồn rửa không? (true/false): ");
                            boolean coBonRua = sc.nextBoolean();
                            PhongHoc phongThiNghiem = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
                            if (quanLyPhongHoc.themPhongHoc(phongThiNghiem)) {
                                System.out.println("Thêm phòng thí nghiệm thành công!");
                            } else {
                                System.out.println("Mã phòng bị trùng!");
                            }
                            break;
                        default:
                            System.out.println("Loại phòng không hợp lệ.");
                    }
                    break;
                case 2:
                    // Tìm kiếm phòng học
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String maPhongTim = sc.next();
                    PhongHoc phongTimKiem = quanLyPhongHoc.timPhongHoc(maPhongTim);
                    if (phongTimKiem != null) {
                        System.out.println("Thông tin phòng: " + phongTimKiem);
                    } else {
                        System.out.println("Không tìm thấy phòng với mã " + maPhongTim);
                    }
                    break;
                case 3:
                    // In danh sách phòng học
                	System.out.println("Danh sách phòng học: ");
                    tieuDe();
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 4:
                    // In danh sách phòng đạt chuẩn
                    System.out.println("Danh sách phòng đạt chuẩn: ");
                    quanLyPhongHoc.inDanhSachPhongDatChuan();
                    break;
                case 5:
                    // Sắp xếp theo dãy nhà tăng dần
                    quanLyPhongHoc.sapXepTheoDayNhaTangDan();
                    System.out.println("Danh sách phòng sau khi sắp xếp theo dãy nhà tăng dần: ");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 6:
                    // Sắp xếp theo diện tích giảm dần
                    quanLyPhongHoc.sapXepTheoDienTichGiamDan();
                    System.out.println("Danh sách phòng sau khi sắp xếp theo diện tích giảm dần: ");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 7:
                    // Sắp xếp theo số bóng đèn tăng dần
                    quanLyPhongHoc.sapXepTheoSoBongDenTangDan();
                    System.out.println("Danh sách phòng sau khi sắp xếp theo số bóng đèn tăng dần: ");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 8:
                    // Cập nhật số lượng máy tính
                    System.out.print("Nhập mã phòng máy tính cần cập nhật: ");
                    String maPhongMayTinh = sc.next();
                    System.out.print("Nhập số lượng máy tính mới: ");
                    int soMayTinhMoi = sc.nextInt();
                    if (quanLyPhongHoc.capNhatSoMayTinh(maPhongMayTinh, soMayTinhMoi)) {
                        System.out.println("Cập nhật thành công.");
                    } else {
                        System.out.println("Không tìm thấy phòng máy tính với mã " + maPhongMayTinh);
                    }
                    break;
                case 9:
                    // Xóa phòng học
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maPhongXoa = sc.next();
                    if (quanLyPhongHoc.xoaPhongHoc(maPhongXoa)) {
                        System.out.println("Xóa thành công.");
                    } else {
                        System.out.println("Xóa không thành công hoặc đã hủy.");
                    }
                    break;
                case 10:
                    // In tổng số phòng học
                    System.out.println("Tổng số phòng học: " + quanLyPhongHoc.tongSoPhongHoc());
                    break;
                case 11:
                    // In danh sách phòng máy có 60 máy
                    System.out.println("Danh sách phòng máy có 60 máy: ");
                    quanLyPhongHoc.inDanhSachPhongMay60May();
                    break;
                case 12:
                    // Nhập cứng
                    tieuDe();
                    nhapCung();
                    break;
                case 0:
                    // Thoát chương trình
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        nhap();
    }
}