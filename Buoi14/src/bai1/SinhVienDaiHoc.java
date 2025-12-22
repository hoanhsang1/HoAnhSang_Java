package bai1;

import java.util.Date;

public class SinhVienDaiHoc extends SV {
    private int TinChi;
    private String TenDeTai;
    private double DiemDanhGia;
    private String XepLoai;
    
    public SinhVienDaiHoc() {
        super();
        this.XepLoai = TinhXepLoai();
    }
    
    public SinhVienDaiHoc(String maSV, String ten, String gioiTinh, 
                         Date ngaySinh, int tinChi, 
                         String tenDeTai, double diemDanhGia) {
        super(maSV, ten, gioiTinh, ngaySinh);
        this.TinChi = tinChi;
        this.TenDeTai = tenDeTai;
        this.DiemDanhGia = diemDanhGia;
        this.XepLoai = TinhXepLoai();
    }
    
    // Getter và Setter
    public int getTinChi() {
        return TinChi;
    }
    
    public void setTinChi(int tinChi) {
        this.TinChi = tinChi;
    }
    
    public String getTenDeTai() {
        return TenDeTai;
    }
    
    public void setTenDeTai(String tenDeTai) {
        this.TenDeTai = tenDeTai;
    }
    
    public double getDiemDanhGia() {
        return DiemDanhGia;
    }
    
    public void setDiemDanhGia(double diemDanhGia) {
        this.DiemDanhGia = diemDanhGia;
        this.XepLoai = TinhXepLoai(); // Cập nhật xếp loại khi thay đổi điểm
    }
    
    public String getXepLoai() {
        return XepLoai;
    }
    
    @Override
    public String TinhXepLoai() {
        if (DiemDanhGia >= 4.0) {
            return "A";
        } else if (DiemDanhGia >= 3.0) {
            return "B";
        } else if (DiemDanhGia >= 2.0) {
            return "C";
        } else {
            return "D";
        }
    }
    
    @Override
    public String getThongTin() {
        return "Sinh viên Đại học\n" +
               "Mã SV: " + MaSV + "\n" +
               "Tên: " + Ten + "\n" +
               "Giới tính: " + GioiTinh + "\n" +
               "Ngày sinh: " + getNgaySinhFormatted() + "\n" +
               "Số tín chỉ: " + TinChi + "\n" +
               "Tên đề tài: " + TenDeTai + "\n" +
               "Điểm đánh giá: " + DiemDanhGia + "\n" +
               "Xếp loại: " + XepLoai + "\n";
    }
    
    @Override
    public String getHeDaoTao() {
        return "Đại học";
    }
    
    // Ghi đè phương thức XuatSV()
    @Override
    public String XuatSV() {
        return super.XuatSV() + ", Hệ: Đại học" + 
               ", Tín chỉ: " + TinChi +
               ", Tên đề tài: " + TenDeTai +
               ", Điểm đánh giá: " + DiemDanhGia + 
               ", Xếp loại: " + XepLoai;
    }
}