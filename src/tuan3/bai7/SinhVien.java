package tuan3.bai7;

import java.util.Arrays;
import java.util.Scanner;

class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    // Default constructor
    public SinhVien() {
    }

    // Constructor with parameters
    public SinhVien(int maSinhVien, String hoTen, String diaChi, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        setSoDienThoai(soDienThoai); // Use setter to validate phone number
    }

    // Getters and setters
    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        if (soDienThoai.matches("\\d{7}")) {
            this.soDienThoai = soDienThoai;
        } else {
            throw new IllegalArgumentException("Số điện thoại phải có 7 chữ số.");
        }
    }

    // Override toString
    @Override
    public String toString() {
        return "Mã sinh viên: " + maSinhVien + 
               "\nHọ tên: " + hoTen + 
               "\nĐịa chỉ: " + diaChi + 
               "\nSố điện thoại: " + soDienThoai;
    }
}
