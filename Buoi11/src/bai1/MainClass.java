package bai1;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        XuLy xuLy = new XuLy();
        Scanner sc = new Scanner(System.in);
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("        QUẢN LÝ NGƯỜI - MENU CHÍNH");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Nhập danh sách giáo viên");
            System.out.println("3. Xuất danh sách sinh viên");
            System.out.println("4. Xuất danh sách giáo viên");
            System.out.println("5. Thống kê xếp loại sinh viên");
            System.out.println("6. Thống kê xếp loại giáo viên");
            System.out.println("7. Xem tổng số lượng");
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
                    xuLy.nhapDanhSachSinhVien();
                    break;
                    
                case 2:
                    xuLy.nhapDanhSachGiaoVien();
                    break;
                    
                case 3:
                    xuLy.xuatDanhSachSinhVien();
                    break;
                    
                case 4:
                    xuLy.xuatDanhSachGiaoVien();
                    break;
                    
                case 5:
                    xuLy.thongKeSinhVien();
                    break;
                    
                case 6:
                    xuLy.thongKeGiaoVien();
                    break;
                    
                case 7:
                    System.out.println("\n=== TỔNG SỐ LƯỢNG ===");
                    System.out.println("Số lượng sinh viên: " + xuLy.getSoLuongSV());
                    System.out.println("Số lượng giáo viên: " + xuLy.getSoLuongGV());
                    System.out.println("Tổng cộng: " + (xuLy.getSoLuongSV() + xuLy.getSoLuongGV()));
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng chương trình!");
                    System.out.println("     Tổng số sinh viên: " + xuLy.getSoLuongSV());
                    System.out.println("     Tổng số giáo viên: " + xuLy.getSoLuongGV());
                    System.out.println("══════════════════════════════════════════");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
        } while (chon != 0);
        
        sc.close();
    }
}