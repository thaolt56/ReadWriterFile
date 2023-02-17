

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSV {
	
	private ArrayList<SinhVien> danhSach;
	
	public DanhSachSV() {
		this.danhSach = new ArrayList<SinhVien>();
	}

	public DanhSachSV(ArrayList<SinhVien> danhSach) {
		
		this.danhSach = danhSach;
	}
	
	public void themSinhVien(SinhVien sv) {
		this.danhSach.add(sv);
	}
	
	public void danhSachSinhVien() {
		for (SinhVien sinhVien : danhSach) {
			System.out.println(sinhVien.toString());
		}
	}
	public boolean kiemTraDanhSachRong() {
		return this.danhSach.isEmpty();	
	}
	
	public int soLuongSinhVien() {
		return this.danhSach.size();
	}
	
	public void lamRongDanhSach() {
		this.danhSach.removeAll(danhSach);
	}
	
	public boolean kiemTraTonTaiSv(SinhVien sv) {
		return 	this.danhSach.contains(sv);
	}
	public void xoaSv(SinhVien sv) {
		this.danhSach.remove(sv);
	}
	
	public void timSv(String ten) {
		for (SinhVien sinhVien : danhSach) {
			if(sinhVien.getHoTen().indexOf(ten)>=0) {
				System.out.println(sinhVien.toString());
			}
		}
	}
	
	public void sapXepSVTheoDiemTB() {
		Collections.sort(this.danhSach, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				if(o1.getDiemTB()> o2.getDiemTB()) {
					return 1;
				}else if(o1.getDiemTB()< o2.getDiemTB()) {
					return -1;
				}else {
					return 0;
				}
			}
			
		});
	}
	
	public void ghiDanhSachXuongFile(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (SinhVien sinhVien : danhSach) {
				oos.writeObject(sinhVien);
			}
			
			oos.flush();
			oos.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void docDanhSach(File file) {
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			SinhVien sv = null;
			while(true) {
				Object oj = ois.readObject();
				if(oj == null) {
					break;
				}else if(oj != null) {
					sv = (SinhVien) oj;
					this.danhSach.add(sv);
				}
				
			}
			
			
			ois.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
