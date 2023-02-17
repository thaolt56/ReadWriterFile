

import java.io.File;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		System.out.println("---------MENU quản lý sinh  -------");
		
		DanhSachSV dssv = new DanhSachSV();
		Scanner sc = new Scanner(System.in);
		int luaChon = 0;
		do {
			
			
			System.out.println("Lựa chọn phím chức năng thích hợp ");
			System.out.println("1.Thêm sinh viên vào danh sach ");
			System.out.println("2.In danh sách sinh viên ");
			System.out.println("3.Kiểm tra danh sách sinh viên có rỗng không");
			System.out.println("4.Lấy số lươngj sinh viên ");
			System.out.println("5.Làm rỗng danh sách Sinh viên");
			System.out.println("6.Kiểm tra sinh viên có tồn tại trong danh sách");
			System.out.println("7.Xoá 1 sinh viên ra khỏi danh sách"	);
			System.out.println("8.Tìm kiếm sinh viên bằng Tên ");
			System.out.println("9.Xuất danh sách sinh viên điểm cao đến thấp");
			System.out.println("10.Lưu danh sách sinh viên xuống file ");
			System.out.println("11.Đọc danh sách sinh viên ");
			
			
			System.out.println("Chọn phím chức năng :");
			luaChon = sc.nextInt();
			sc.nextLine();
			
			if (luaChon == 1) {
				System.out.println("Thêm sinh viên vào danh sach");
				System.out.println("Nhập họ tên  ");String hoTen = sc.nextLine();
				System.out.println("Nhập mã sinh viên : ");String maSV = sc.nextLine();				
				System.out.println("Nhập năm sinh : ");int namSinh = sc.nextInt();
				System.out.println("Nhập điểm trung bình : ");float diemTb = sc.nextFloat();
				SinhVien sVien = new SinhVien(maSV, hoTen, diemTb, namSinh);
				dssv.themSinhVien(sVien);
				
			}else if (luaChon == 2) {
//				.In danh sách sinh viên
				dssv.danhSachSinhVien();
			}else if (luaChon == 3) {
				System.out.println("Danh sách sinh viên rỗng :"+dssv.kiemTraDanhSachRong());
			}else if (luaChon == 4) {
				System.out.println("Số lượng sinh viên : " + dssv.soLuongSinhVien());
			}else if (luaChon == 5) {
				dssv.lamRongDanhSach();
				System.out.println("Bạn đã xoá danh sách ");
			}else if (luaChon == 6) {
				System.out.println("Nhập mã sinh viên  "); String msSV = sc.nextLine();
				SinhVien sVien = new SinhVien(msSV);
				System.out.println("sSinh viên có tồn tại : " + dssv.kiemTraTonTaiSv(sVien));
			}else if (luaChon == 7) {
				System.out.println("Nhập mã sinh viên  "); String msSV = sc.nextLine();
				SinhVien sVien = new SinhVien(msSV);
				dssv.xoaSv(sVien);
			}else if (luaChon == 8) {
				System.out.println("Nhập tên sinh viên  "); String tenSV = sc.nextLine();
				dssv.timSv(tenSV);
			}else if (luaChon == 9){
				dssv.sapXepSVTheoDiemTB();
				dssv.danhSachSinhVien();
			}else if(luaChon == 10) {
				System.out.println("Nhập tên file: ");
				String tenFile = sc.nextLine();
				File file = new File(tenFile);
				
				dssv.ghiDanhSachXuongFile(file);
			}else if(luaChon == 11) {
				System.out.println("Nhập tên file: ");
				String tenFile = sc.nextLine();
				File file = new File(tenFile);
				
				dssv.docDanhSach(file);
			}
			
			
			
		}
		while(luaChon!=0);
		
	}
}
