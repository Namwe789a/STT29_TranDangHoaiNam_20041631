package tuan4.bai2_Sach_Module_3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Sach {
	protected String maSach;
	protected LocalDate ngaNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;
	
	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	  NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public LocalDate getNgaNhap() {
		return ngaNhap;
	}
	public void setNgaNhap(LocalDate ngaNhap) {
		this.ngaNhap = ngaNhap;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	
	public String getLoaiSach() {
	    return "Sách";
	}
	
	
	
	
	public Sach(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.ngaNhap = ngaNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}
	public Sach() {
		super();
	}
	  public double thanhTien() {
	        return 0;
	    }
	    

	@Override
	public String toString() {
	    return String.format(
	        "%-10s %-15s %-10s %-10d %-20s %-15s", // Bao gồm loại sách
	        maSach,                          // Mã sách
	        ngaNhap.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), // Ngày nhập
	        numberFormat.format(donGia),      // Đơn giá định dạng tiền tệ
	        soLuong,                         // Số lượng
	        nhaXuatBan,                      // Nhà xuất bản
	        getLoaiSach() 						 /// Loại sách
	        
	    );
	}
	
	
	


	
	
	
}
