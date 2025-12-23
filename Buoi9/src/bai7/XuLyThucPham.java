package bai7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class XuLyThucPham {
    private Scanner sc;
    private SimpleDateFormat sdf;
    private QuanLyThucPham qltp; // Thêm tham chiếu để kiểm tra mã hàng
    
    public XuLyThucPham(QuanLyThucPham qltp) {
        sc = new Scanner(System.in);
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        this.qltp = qltp;
    }
    
    // Nhập thông tin thực phẩm với kiểm tra mã hàng duy nhất
    public ThucPham nhapThucPham() {
        System.out.println("\n=== NHẬP THÔNG TIN THỰC PHẨM ===");
        
        // Nhập mã hàng (KIỂM TRA DUY NHẤT)
        String maHang;
        while (true) {
            System.out.print("Mã hàng (không để trống): ");
            maHang = sc.nextLine().trim();
            
            if (maHang.isEmpty()) {
                System.out.println("Mã hàng không được để trống!");
                continue;
            }
            
            // Kiểm tra mã hàng đã tồn tại chưa
            if (kiemTraMaHangDaTonTai(maHang)) {
                System.out.println("⚠ Mã hàng '" + maHang + "' đã tồn tại! Vui lòng nhập mã khác.");
            } else {
                break;
            }
        }
        
        // Nhập tên hàng
        String tenHang;
        while (true) {
            System.out.print("Tên hàng (không để trống): ");
            tenHang = sc.nextLine().trim();
            if (!tenHang.isEmpty()) {
                break;
            }
            System.out.println("Tên hàng không được để trống!");
        }
        
        // Nhập đơn giá
        double donGia;
        while (true) {
            try {
                System.out.print("Đơn giá (> 0): ");
                donGia = Double.parseDouble(sc.nextLine());
                if (donGia > 0) {
                    break;
                }
                System.out.println("Đơn giá phải > 0!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
        
        // Nhập ngày sản xuất (không được ở tương lai)
        Date ngaySanXuat = nhapNgayKhongTuongLai("Ngày sản xuất (dd/MM/yyyy): ");
        
        // Nhập ngày hết hạn (phải sau ngày SX VÀ phải ở tương lai)
        Date ngayHetHan;
        while (true) {
            ngayHetHan = nhapNgayTuongLai("Ngày hết hạn (dd/MM/yyyy): ");
            if (ngayHetHan.after(ngaySanXuat)) {
                break;
            }
            System.out.println("Ngày hết hạn phải sau ngày sản xuất!");
        }
        
        // Tạo và trả về đối tượng ThucPham
        return new ThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
    }
    
    // Kiểm tra mã hàng đã tồn tại chưa
    private boolean kiemTraMaHangDaTonTai(String maHang) {
        for (ThucPham tp : qltp.getDanhSach()) {
            if (tp.getMaHang().equalsIgnoreCase(maHang)) {
                return true;
            }
        }
        return false;
    }
    
    // Nhập ngày với kiểm tra (không cho phép ngày tương lai)
    private Date nhapNgayKhongTuongLai(String message) {
        Date ngayHienTai = new Date();
        while (true) {
            try {
                System.out.print(message);
                String ngayStr = sc.nextLine().trim();
                Date ngay = sdf.parse(ngayStr);
                
                // Kiểm tra ngày không được ở tương lai
                if (ngay.after(ngayHienTai)) {
                    System.out.println("Ngày sản xuất không thể ở tương lai!");
                    continue;
                }
                
                return ngay;
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ! Vui lòng nhập dd/MM/yyyy");
            }
        }
    }
    
    // Nhập ngày với kiểm tra (phải ở tương lai)
    private Date nhapNgayTuongLai(String message) {
        Date ngayHienTai = new Date();
        while (true) {
            try {
                System.out.print(message);
                String ngayStr = sc.nextLine().trim();
                Date ngay = sdf.parse(ngayStr);
                
                // Kiểm tra ngày phải ở tương lai
                if (!ngay.after(ngayHienTai)) {
                    System.out.println("Ngày hết hạn phải ở tương lai!");
                    continue;
                }
                
                return ngay;
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ! Vui lòng nhập dd/MM/yyyy");
            }
        }
    }
    
    // Nhập số nguyên
    public int nhapSoNguyen(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }
}