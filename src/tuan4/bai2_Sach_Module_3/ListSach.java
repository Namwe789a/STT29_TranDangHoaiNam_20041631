package tuan4.bai2_Sach_Module_3;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tuan4.bai1_ChuyenXe_Module3.ChuyenXe;
import tuan4.bai1_ChuyenXe_Module3.NgoaiThanh;
import tuan4.bai1_ChuyenXe_Module3.NoiThanh;

public class ListSach {
	ArrayList<Sach> sach;
	ArrayList k;
	
	public ListSach() {
		sach = new ArrayList<Sach>();
	}
	
	//-------------------------------begin method ----------------------------------
		public void add(Sach sach1) throws Exception {
			if (sach.contains(sach) == false)// hiểu dc nhờ hascode equa của lớp chuyến xe
				sach.add(sach1);
			else {
				throw new Exception("Mã chuyến xe đã trùng");
			}
		}
		public int timKiemViTri(String maSach) {
			Sach findsach = timKiem(maSach);
			if (findsach != null)
				return sach.indexOf(timKiem(maSach));
			return -1;
		}
		public Sach timKiem(String maSach) {
			for (Sach s : sach) {
				if (s.getMaSach().equalsIgnoreCase(maSach))
					return s;
			}
			return null;
		}
		
		public void xoa(Sach s) {
			sach.remove(s);
		}
		
		
		public ArrayList<Sach_Giao_Khoa> getListSachGiaoKhoa() {
			ArrayList<Sach_Giao_Khoa> DSSachGiaoKhao = new ArrayList<Sach_Giao_Khoa>();
			for (Sach s : sach)
				if (s instanceof Sach_Giao_Khoa)
					DSSachGiaoKhao.add((Sach_Giao_Khoa) s);

			return DSSachGiaoKhao;
		}
		//-----------------------------trả về danh sách xe ngoại thành -----------------
		public ArrayList<Sach_Kham_Khao> getListSachKhamKhao() {
			ArrayList<Sach_Kham_Khao> DSSachKhamKhao = new ArrayList<Sach_Kham_Khao>();
			for (Sach s : sach)
				if (s instanceof Sach_Kham_Khao)
					DSSachKhamKhao.add((Sach_Kham_Khao) s);

			return DSSachKhamKhao;
		}

	//-------------------------------trả về danh sách chuyến xe --------------------
		public ArrayList<Sach> getDS() {
			return sach;
		}
		
		 public ArrayList<Sach> getListThamKhao() {
		        ArrayList<Sach> temporaryLs = new ArrayList<Sach>();
		        for (Sach s : sach) {
		            if (s instanceof Sach_Kham_Khao) {
		                temporaryLs.add(s);
		            }
		        }
		        return temporaryLs;
		    }
		 
	// sắp xếp theo số lượng
		   public void sortTheoSoLuong() {
		        Collections.sort(sach, new Comparator<Sach>() {
					@Override
					public int compare(Sach o1, Sach o2) {
						int comp1 = Integer.compare(o1.getSoLuong(), o2.getSoLuong());
						return comp1;
					}  
		        });
		    }
		   
		   
// sắp xép theo đơn giá và ngày nhâp
		   public void sortDonGia() {
		        Collections.sort(sach, new Comparator<Sach>() {

		            @Override
		            public int compare(Sach o1, Sach o2) {
		                // So sánh số lượng
		                int comp1 = Double.compare(o1.getDonGia(), o2.getDonGia());

		                if (comp1 == 0) { // Nếu đơn giá bằng nhau, so sánh tiếp ngày nhập
		                	 return o2.getNgaNhap().compareTo(o1.getNgaNhap()); // So sánh đơn giá ngược (giảm dần)

		                } else {
		                    return comp1;
		                }
		            }
		        });
		    }
}
