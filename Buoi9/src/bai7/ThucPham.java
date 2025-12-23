package bai7;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThucPham {
    // Thuộc tính
    private String maHang;      // Không cho phép sửa, không rỗng
    private String tenHang;     // Không rỗng
    private double donGia;      // > 0
    private Date ngaySanXuat;   // Không rỗng
    private Date ngayHetHan;    // Không rỗng, phải sau ngày SX
    
    private SimpleDateFormat sdf;
    
    // Constructor mặc định
    public ThucPham() {
        this.maHang = "TP000";
        this.tenHang = "Thực phẩm";
        this.donGia = 10000;
        this.ngaySanXuat = new Date();
        this.ngayHetHan = new Date();
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    // Constructor chỉ có mã hàng
    public ThucPham(String maHang) {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // Kiểm tra và gán mã hàng
        if (maHang == null || maHang.trim().isEmpty()) {
            this.maHang = "TP000";
        } else {
            this.maHang = maHang;
        }
        
        // Giá trị mặc định cho các thuộc tính khác
        this.tenHang = "Thực phẩm";
        this.donGia = 10000;
        this.ngaySanXuat = new Date();
        this.ngayHetHan = new Date();
    }
    
    // Constructor đầy đủ tham số
    public ThucPham(String maHang, String tenHang, double donGia, 
                    Date ngaySanXuat, Date ngayHetHan) {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // Kiểm tra và gán mã hàng
        if (maHang == null || maHang.trim().isEmpty()) {
            this.maHang = "TP000";
        } else {
            this.maHang = maHang;
        }
        
        // Kiểm tra và gán tên hàng
        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenHang = "Thực phẩm";
        } else {
            this.tenHang = tenHang;
        }
        
        // Kiểm tra và gán đơn giá
        if (donGia <= 0) {
            this.donGia = 10000;
        } else {
            this.donGia = donGia;
        }
        
        // Kiểm tra và gán ngày sản xuất
        if (ngaySanXuat == null) {
            this.ngaySanXuat = new Date();
        } else {
            this.ngaySanXuat = ngaySanXuat;
        }
        
        // Kiểm tra và gán ngày hết hạn
        if (ngayHetHan == null || ngayHetHan.before(this.ngaySanXuat)) {
            // Nếu ngày hết hạn trước ngày SX, đặt bằng ngày SX + 1 ngày
            this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + (24 * 60 * 60 * 1000));
        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }
    
    // GETTER - SETTER
    
    // Mã hàng: chỉ có getter, không có setter
    public String getMaHang() {
        return maHang;
    }
    
    // Tên hàng
    public String getTenHang() {
        return tenHang;
    }
    
    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenHang = "Thực phẩm";
        } else {
            this.tenHang = tenHang;
        }
    }
    
    // Đơn giá
    public double getDonGia() {
        return donGia;
    }
    
    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            this.donGia = 10000;
        } else {
            this.donGia = donGia;
        }
    }
    
    // Ngày sản xuất
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }
    
    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat == null) {
            this.ngaySanXuat = new Date();
        } else {
            this.ngaySanXuat = ngaySanXuat;
            // Kiểm tra lại ngày hết hạn
            if (this.ngayHetHan.before(this.ngaySanXuat)) {
                this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + (24 * 60 * 60 * 1000));
            }
        }
    }
    
    // Ngày hết hạn
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    
    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan == null || ngayHetHan.before(this.ngaySanXuat)) {
            this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + (24 * 60 * 60 * 1000));
        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }
    
    // PHƯƠNG THỨC KIỂM TRA
    
    // Kiểm tra hàng đã hết hạn chưa
    public boolean daHetHan() {
        Date ngayHienTai = new Date();
        return ngayHienTai.after(this.ngayHetHan);
    }
    
    // Kiểm tra hàng sắp hết hạn (còn < 7 ngày)
    public boolean sapHetHan() {
        Date ngayHienTai = new Date();
        long soNgayConLai = (this.ngayHetHan.getTime() - ngayHienTai.getTime()) / (24 * 60 * 60 * 1000);
        return soNgayConLai > 0 && soNgayConLai <= 7;
    }
    
    // Tính số ngày còn hạn
    public int tinhSoNgayConHan() {
        Date ngayHienTai = new Date();
        long diff = this.ngayHetHan.getTime() - ngayHienTai.getTime();
        return (int) (diff / (24 * 60 * 60 * 1000));
    }
    
    // PHƯƠNG THỨC HIỂN THỊ
    
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMaximumFractionDigits(0);
        
        String trangThai = daHetHan() ? "ĐÃ HẾT HẠN" : 
                          (sapHetHan() ? "SẮP HẾT HẠN" : "CÒN HẠN");
        
        int soNgayConLai = tinhSoNgayConHan();
        String thongBaoHan = daHetHan() ? 
            String.format("Đã hết hạn %d ngày", -soNgayConLai) :
            String.format("Còn %d ngày", soNgayConLai);
        
        return String.format(
            "┌─────────────────────────────────────────────────────┐\n" +
            "│ MÃ HÀNG: %-40s │\n" +
            "│ TÊN HÀNG: %-39s │\n" +
            "│ ĐƠN GIÁ: %-40s │\n" +
            "│ NGÀY SX: %-40s │\n" +
            "│ NGÀY HH: %-40s │\n" +
            "│ TRẠNG THÁI: %-37s │\n" +
            "│ THỜI GIAN: %-38s │\n" +
            "└─────────────────────────────────────────────────────┘",
            maHang,
            tenHang,
            nf.format(donGia) + " VNĐ",
            sdf.format(ngaySanXuat),
            sdf.format(ngayHetHan),
            trangThai,
            thongBaoHan
        );
    }
    
    // Hiển thị ngắn gọn (cho danh sách)
    public String toStringNgan() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMaximumFractionDigits(0);
        
        String trangThai = daHetHan() ? "HẾT HẠN" : "CÒN HẠN";
        String kyHieu = daHetHan() ? "⚠" : "✓";
        
        return String.format("%s %-10s %-20s %,10.0f %10s %10s %10s",
            kyHieu,
            maHang,
            (tenHang.length() > 20 ? tenHang.substring(0, 17) + "..." : tenHang),
            donGia,
            sdf.format(ngaySanXuat),
            sdf.format(ngayHetHan),
            trangThai
        );
    }
}