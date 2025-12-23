package bai1;

import TaomoiTV.Test;

public class MainClass {
    public static void main(String[] args) {
        ThuVienX thuVien = new ThuVienX();
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("        QUẢN LÝ THƯ VIỆN X - MENU");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập danh sách sách giáo khoa");
            System.out.println("2. Nhập danh sách sách tham khảo");
            System.out.println("3. Xuất danh sách sách giáo khoa");
            System.out.println("4. Xuất danh sách sách tham khảo");
            System.out.println("5. Tính tổng thành tiền từng loại");
            System.out.println("6. Tính trung bình đơn giá sách tham khảo");
            System.out.println("7. Xuất SGK theo nhà xuất bản");
            System.out.println("8. Sắp xếp SGK theo mã sách");
            System.out.println("9. Thống kê đơn giá STK");
            System.out.println("10. Xem tổng số lượng sách");
            System.out.println("0. Thoát chương trình");
            System.out.println("══════════════════════════════════════════");
            
            chon = Test.inputIntInRange("Chọn chức năng: ", 0, 10);
            
            switch (chon) {
                case 1:
                    thuVien.nhapDanhSachSGK();
                    break;
                    
                case 2:
                    thuVien.nhapDanhSachSTK();
                    break;
                    
                case 3:
                    thuVien.xuatDanhSachSGK();
                    break;
                    
                case 4:
                    thuVien.xuatDanhSachSTK();
                    break;
                    
                case 5:
                    System.out.println("\n=== TỔNG THÀNH TIỀN ===");
                    System.out.printf("Sách giáo khoa: %.2f\n", thuVien.tinhTongThanhTienSGK());
                    System.out.printf("Sách tham khảo: %.2f\n", thuVien.tinhTongThanhTienSTK());
                    System.out.printf("Tổng cộng: %.2f\n", 
                        thuVien.tinhTongThanhTienSGK() + thuVien.tinhTongThanhTienSTK());
                    break;
                    
                case 6:
                    double tb = thuVien.tinhTrungBinhDonGiaSTK();
                    System.out.printf("\nTrung bình đơn giá sách tham khảo: %.2f\n", tb);
                    break;
                    
                case 7:
                    thuVien.xuatSGKTheoNhaXuatBan();
                    break;
                    
                case 8:
                    thuVien.sapXepSGKTheoMa();
                    // Sau khi sắp xếp, hiển thị lại danh sách
                    System.out.print("Bạn có muốn xem danh sách sau khi sắp xếp? (1: Có, 0: Không): ");
                    int xem = Test.inputIntInRange("", 0, 1);
                    if (xem == 1) {
                        thuVien.xuatDanhSachSGK();
                    }
                    break;
                    
                case 9:
                    thuVien.thongKeDonGiaSTK();
                    break;
                    
                case 10:
                    System.out.println("\n=== TỔNG SỐ LƯỢNG SÁCH ===");
                    System.out.println("Sách giáo khoa: " + thuVien.getSoLuongSGK());
                    System.out.println("Sách tham khảo: " + thuVien.getSoLuongSTK());
                    System.out.println("Tổng cộng: " + (thuVien.getSoLuongSGK() + thuVien.getSoLuongSTK()));
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng chương trình!");
                    System.out.println("     Tổng số sách trong thư viện: " + 
                        (thuVien.getSoLuongSGK() + thuVien.getSoLuongSTK()));
                    System.out.println("══════════════════════════════════════════");
                    break;
            }
            
        } while (chon != 0);
    }
}