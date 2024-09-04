package tuan3_bai5_bai6_bai7;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestHangThucPham {

    public static void main(String[] args) {
        // Tạo đối tượng HangThucPham
        HangThucPham htp1 = createHangThucPham("HTP001", "Gạo", 20000, 2023, Calendar.JANUARY, 1, 2024, Calendar.JANUARY, 1);
        HangThucPham htp2 = inputHangThucPham();

        // In thông tin các hàng thực phẩm
        System.out.println(htp1);
        System.out.println();
        System.out.println(htp2);
    }

    // Tách ra hàm riêng để tạo đối tượng HangThucPham với tham số truyền vào
    public static HangThucPham createHangThucPham(String maHang, String tenHang, double donGia,
                                                  int namSanXuat, int thangSanXuat, int ngaySanXuat,
                                                  int namHetHan, int thangHetHan, int ngayHetHan) {
        Calendar cal = Calendar.getInstance();
        cal.set(namSanXuat, thangSanXuat, ngaySanXuat);
        Date ngaySX = cal.getTime();

        cal.set(namHetHan, thangHetHan, ngayHetHan);
        Date ngayHH = cal.getTime();

        return new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayHH);
    }

    // Hàm nhập thông tin từ bàn phím
    public static HangThucPham inputHangThucPham() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập ngày sản xuất (yyyy-mm-dd): ");
        String[] ngaySXStr = scanner.next().split("-");
        int namSX = Integer.parseInt(ngaySXStr[0]);
        int thangSX = Integer.parseInt(ngaySXStr[1]) - 1; // Calendar month is 0-based
        int ngaySX = Integer.parseInt(ngaySXStr[2]);

        System.out.print("Nhập ngày hết hạn (yyyy-mm-dd): ");
        String[] ngayHHStr = scanner.next().split("-");
        int namHH = Integer.parseInt(ngayHHStr[0]);
        int thangHH = Integer.parseInt(ngayHHStr[1]) - 1;
        int ngayHH = Integer.parseInt(ngayHHStr[2]);

        Calendar cal = Calendar.getInstance();
        cal.set(namSX, thangSX, ngaySX);
        Date ngaySXDate = cal.getTime();

        cal.set(namHH, thangHH, ngayHH);
        Date ngayHHDate = cal.getTime();

        return new HangThucPham(maHang, tenHang, donGia, ngaySXDate, ngayHHDate);
    }
}
