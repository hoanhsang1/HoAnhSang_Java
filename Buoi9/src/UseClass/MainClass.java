package UseClass;

import BuildClass.QuanLySinhVien;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();
        Scanner sc = new Scanner(System.in);
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("     QUẢN LÝ SINH VIÊN - MENU CHÍNH");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Thêm 1 sinh viên mới");
            System.out.println("3. Xem danh sách sinh viên");
            System.out.println("4. Sắp xếp theo điểm TB (tăng dần)");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Thống kê xếp loại");
            System.out.println("7. Xem điểm cao nhất/thấp nhất");
            System.out.println("0. Thoát chương trình");
            System.out.println("══════════════════════════════════════════");
            System.out.print("Chọn chức năng: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                chon = -1;
            }
            
            switch (chon) {
                case 1:
                    qlsv.nhapDanhSach();
                    break;
                    
                case 2:
                    qlsv.themSinhVien();
                    break;
                    
                case 3:
                    qlsv.xemDanhSachDonGian();
                    break;
                    
                case 4:
                    qlsv.sapXepTheoDiemTB();
                    break;
                    
                case 5:
                    qlsv.timKiemTheoTen();
                    break;
                    
                case 6:
                    qlsv.thongKeXepLoai();
                    break;
                    
                case 7:
                    System.out.println("\n=== ĐIỂM CAO NHẤT/THẤP NHẤT ===");
                    System.out.printf("Điểm cao nhất: %.2f\n", qlsv.timDiemCaoNhat());
                    System.out.printf("Điểm thấp nhất: %.2f\n", qlsv.timDiemThapNhat());
                    System.out.printf("Điểm trung bình: %.2f\n", qlsv.tinhDiemTrungBinh());
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng chương trình!");
                    System.out.println("     Tổng số sinh viên: " + qlsv.getSoLuong());
                    System.out.println("══════════════════════════════════════════");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
        } while (chon != 0);
        
        sc.close();
    }
}