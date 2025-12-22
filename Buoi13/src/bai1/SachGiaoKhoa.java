package bai1;

import TaomoiTV.Test;
import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
    // Tình trạng: 'mới' hoặc 'cũ'
    protected String tinhTrang; 

    // Constructor không tham số
    public SachGiaoKhoa() {
        super();
        this.tinhTrang = "";
    }

    // Constructor có tham số
    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tt) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tt;
    }

    // Ghi đè phương thức Nhập
    @Override
    public void nhap() {
        super.nhap(); // Nhập thông tin Sach cơ bản
        System.out.println("--- NHẬP THÔNG TIN SÁCH GIÁO KHOA ---");
        
        // Nhập Tình trạng, chỉ cho phép 'mới' hoặc 'cũ'
        while (true) {
            String tt = Test.inputNonEmptyString("  Nhập Tình trạng (mới/cũ): ").toLowerCase();
            if (tt.equals("mới") || tt.equals("cũ")) {
                this.tinhTrang = tt;
                break;
            }
            System.out.println("  Lỗi: Tình trạng phải là 'moi' hoặc 'cu'. Vui lòng nhập lại.");
        }
    }

    // Ghi đè phương thức tính thành tiền
    @Override
    public double tinhThanhTien() {
        if (this.tinhTrang.equals("moi")) {
            // Nếu mới: thành tiền = số lượng * đơn giá
            return this.soLuong * this.donGia;
        } else {
            // Nếu cũ: thành tiền = số lượng * đơn giá * 50%
            return this.soLuong * this.donGia * 0.5;
        }
    }
    
    // Phương thức Xuất (hiển thị chi tiết)
    public void xuat() {
        String separator = "-".repeat(110);
        System.out.println(separator);
        System.out.printf("| %-20s | %-10s | %-12s | %-10s | %-8s | %-20s | %-12s | %-15s |\n", 
            "LOẠI SÁCH", "Mã sách", "Ngày nhập", "Đơn giá", "SL", "NXB", "Tình trạng", "Thành tiền");
        System.out.println(separator);

        System.out.printf("| %-20s", "Sách Giáo Khoa");
        System.out.print(super.xuatCoBan());
        System.out.printf(" | %-12s | %-15.2f |", tinhTrang, tinhThanhTien());
        System.out.println();
        System.out.println(separator);
    }
    
    // Getter cho Tình trạng (cần nếu muốn lọc theo tình trạng)
    public String getTinhTrang() { return tinhTrang; }
}