package tuan4.bai2_Sach_Module_3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Sach_Giao_Khoa extends Sach {
	private double tinhTrang;

	

	public double getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(double tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
	
	public Sach_Giao_Khoa(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan,
			double tinhTrang) {
		super(maSach, ngaNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public Sach_Giao_Khoa() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + "/n Tình Trạng"+getTinhTrang();
	}
	
	
	
}
