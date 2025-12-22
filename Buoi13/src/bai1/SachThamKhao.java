package bai1;

import TaomoiTV.Test;
import java.time.LocalDate;

public class SachThamKhao extends Sach {
    protected double thue; // Thuế

    // Constructor không tham số
    public SachThamKhao() {
        super();
        this.thue = 0.0;
    }

    // Constructor có tham số
    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    // Ghi đè phương thức Nhập
    @Override
    public void nhap() {
        super.nhap(); // Nhập thông tin Sach cơ bản
        System.out.println("--- NHẬP THÔNG TIN SÁCH THAM KHẢO ---");
        
        // Thuế phải là số thực không âm (giả sử thư viện Test có hàm inputDouble)
        while (true) {
            this.thue = Test.inputDouble("  Nhập Thuế (>= 0): ");
            if (this.thue >= 0) {
                break;
            }
            System.out.println("  Lỗi: Thuế không thể là số âm. Vui lòng nhập lại.");
        }
    }

    // Ghi đè phương thức tính thành tiền
    @Override
    public double tinhThanhTien() {
        // Công thức: Thành tiền = số lượng * đơn giá + thuế
        return (this.soLuong * this.donGia) + this.thue;
    }
    
    // Phương thức Xuất (hiển thị chi tiết)
    public void xuat() {
        String separator = "-".repeat(110);
        System.out.println(separator);
        System.out.printf("| %-20s | %-10s | %-12s | %-10s | %-8s | %-20s | %-12s | %-15s |\n", 
            "LOẠI SÁCH", "Mã sách", "Ngày nhập", "Đơn giá", "SL", "NXB", "Thuế", "Thành tiền");
        System.out.println(separator);

        System.out.printf("| %-20s", "Sách Tham Khảo");
        System.out.print(super.xuatCoBan());
        System.out.printf(" | %-12.2f | %-15.2f |", thue, tinhThanhTien());
        System.out.println();
        System.out.println(separator);
    }
    
    // Getter cho Thuế (cần cho việc tính trung bình đơn giá ở bước sau)
    public double getThue() { return thue; }
}