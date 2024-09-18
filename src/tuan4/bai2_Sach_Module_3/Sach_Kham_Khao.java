package tuan4.bai2_Sach_Module_3;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Sach_Kham_Khao extends Sach {
    private double thue;

    public Sach_Kham_Khao() {
        super();
    }



    public Sach_Kham_Khao(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan,
			double thue) {
		super(maSach, ngaNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}



	public double getThue() {
		return thue;
	}



	public void setThue(double thue) {
		this.thue = thue;
	}



	@Override
    public double thanhTien() {
        try {
            return soLuong * donGia + thue;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính thành tiền sách tham khảo: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "%s   %-15.2f  %-15s", // Điều chỉnh kích thước cột nếu cần thiết
            super.toString(), 
            getThue(),
            numberFormat.format(thanhTien())
        );
    }

    
}