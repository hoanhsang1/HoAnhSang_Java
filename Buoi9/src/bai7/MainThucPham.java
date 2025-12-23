package bai7;

import java.util.Scanner;

public class MainThucPham {
    public static void main(String[] args) {
        QuanLyThucPham qltp = new QuanLyThucPham();
        XuLyThucPham xl = new XuLyThucPham(qltp); // Truyền qltp vào
        Scanner sc = new Scanner(System.in);
        
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("     QUẢN LÝ THỰC PHẨM - SIÊU THỊ");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Thêm thực phẩm mới");
            System.out.println("2. Hiển thị tất cả thực phẩm");
            System.out.println("3. Kiểm tra sản phẩm hết hạn");
            System.out.println("4. Kiểm tra sản phẩm sắp hết hạn");
            System.out.println("5. Tìm kiếm theo mã hàng");
            System.out.println("6. Xem chi tiết sản phẩm");
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
                    ThucPham tp = xl.nhapThucPham();
                    qltp.themThucPham(tp);
                    break;
                    
                case 2:
                    qltp.hienThiTatCa();
                    break;
                    
                case 3:
                    qltp.timSanPhamHetHan();
                    break;
                    
                case 4:
                    qltp.timSanPhamSapHetHan();
                    break;
                    
                case 5:
                    System.out.print("Nhập mã hàng cần tìm: ");
                    String maHang = sc.nextLine();
                    qltp.timKiemTheoMa(maHang);
                    break;
                    
                case 6:
                    if (qltp.getSoLuong() > 0) {
                        int stt = xl.nhapSoNguyen("Nhập số thứ tự (1-" + qltp.getSoLuong() + "): ");
                        if (stt >= 1 && stt <= qltp.getSoLuong()) {
                            qltp.hienThiChiTiet(stt - 1);
                        } else {
                            System.out.println("Số thứ tự không hợp lệ!");
                        }
                    } else {
                        System.out.println("Chưa có sản phẩm nào!");
                    }
                    break;
                    
                case 0:
                    System.out.println("\n══════════════════════════════════════════");
                    System.out.println("     Cảm ơn đã sử dụng hệ thống!");
                    System.out.println("     Tổng số sản phẩm: " + qltp.getSoLuong());
                    System.out.println("══════════════════════════════════════════");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
        } while (chon != 0);
    }
}