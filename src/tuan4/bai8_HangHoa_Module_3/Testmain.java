package tuan4.bai8_HangHoa_Module_3;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class Testmain {
    static QuanLyKho dsHang = new QuanLyKho();
    static Scanner scanner = new Scanner(System.in);

    // Hàm hiển thị menu
    static void Menu() {
        System.out.println("\t****************************************");
        System.out.println("\t**   Chương trình quản lý kho hàng   **");
        System.out.println("\t* 1. Nhập hàng hóa cứng                *");
        System.out.println("\t* 2. Thêm hàng hóa từ bàn phím         *");
        System.out.println("\t* 3. Xuất danh sách hàng hóa            *");
        System.out.println("\t* 0. Thoát                              *");
        System.out.println("\t****************************************");
    }

    // Hàm in tiêu đề bảng
    public static void inTieuDe() {
        System.out.printf("%-10s|%-15s|%-10s|%-10s|%-15s|%-20s|%-10s|%-15s \n", 
                          "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", "Loại Hàng", "Nhà Cung Cấp", "VAT", "Giá Bán");
    }

    static void nhapCung() throws Exception {
        try {
            // Thêm một số hàng hóa mẫu
            HangThucPham thucPham1 = new HangThucPham("TP001", "Sữa tươi", 100, 20000, "2024-01-01", "2025-01-01", "Công ty TNHH ABC");
            HangDienMay dienMay1 = new HangDienMay("DM001", "Tivi LED", 50, 5000000, 24, 150);
            HangSanhSu sanhSu1 = new HangSanhSu("SS001", "Bộ chén sứ", 200, 50000, "Công ty TNHH XYZ", "2024-09-01");

            // Thêm hàng vào danh sách
            dsHang.addHang(thucPham1);
            dsHang.addHang(dienMay1);
            dsHang.addHang(sanhSu1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Hàm nhập hàng hóa từ bàn phím
    static void nhapHangTuBanPhim() throws Exception {
        System.out.println("Chọn loại hàng (1: Thực phẩm, 2: Điện máy, 3: Sành sứ): ");
        int loaiHang = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng mới sau khi nhập số

        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();

        System.out.print("Nhập số lượng tồn: ");
        int soLuongTon = scanner.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        scanner.nextLine(); // Đọc bỏ dòng mới

        HangHoa hang = null;

        switch (loaiHang) {
            case 1: // Hàng thực phẩm
                System.out.print("Nhập ngày sản xuất (yyyy-MM-dd): ");
                String ngaySanXuat = scanner.nextLine();
                System.out.print("Nhập ngày hết hạn (yyyy-MM-dd): ");
                String ngayHetHan = scanner.nextLine();
                System.out.print("Nhập nhà cung cấp: ");
                String nhaCungCap = scanner.nextLine();
                hang = new HangThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
                break;

            case 2: // Hàng điện máy
                System.out.print("Nhập thời gian bảo hành (tháng): ");
                int thoiGianBaoHanh = scanner.nextInt();
                System.out.print("Nhập công suất (KW): ");
                double congSuat = scanner.nextDouble();
                hang = new HangDienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
                break;

            case 3: // Hàng sành sứ
                System.out.print("Nhập nhà sản xuất: ");
                String nhaSanXuat = scanner.nextLine();
                System.out.print("Nhập ngày nhập kho (yyyy-MM-dd): ");
                String ngayNhapKho = scanner.nextLine();
                hang = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho);
                break;

            default:
                System.out.println("Loại hàng không hợp lệ.");
                return;
        }

        dsHang.addHang(hang);
        System.out.println("Thêm hàng hóa thành công!");
    }

    // Hàm xuất danh sách hàng hóa
    static void xuat(QuanLyKho dsHang) {
        inTieuDe();
        for (HangHoa hang : dsHang.getListHang()) {
            System.out.println(hang);
        }
    }

    public static void main(String[] args) {
        int chon = -1;
        try {
            do {
                Menu();
                System.out.println("Nhập lựa chọn: ");
                chon = scanner.nextInt();
                scanner.nextLine(); // Xử lý dòng mới

                switch (chon) {
                    case 1:
                        nhapCung();
                        break;
                    case 2:
                        nhapHangTuBanPhim();
                        break;
                    case 3:
                        xuat(dsHang);
                        break;
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                }
            } while (chon != 0);  // Kết thúc khi chọn 0
        } catch (Exception e) {
            System.out.println("Đã có lỗi xảy ra: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

