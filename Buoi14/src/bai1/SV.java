package bai1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SV {
    protected String MaSV;
    protected String Ten;
    protected String GioiTinh;
    protected Date NgaySinh;
    
    public SV() {
    }
    
    public SV(String maSV, String ten, String gioiTinh, Date ngaySinh) {
        this.MaSV = maSV;
        this.Ten = ten;
        this.GioiTinh = gioiTinh;
        this.NgaySinh = ngaySinh;
    }
    
    // Getter và Setter
    public String getMaSV() {
        return MaSV;
    }
    
    public void setMaSV(String maSV) {
        this.MaSV = maSV;
    }
    
    public String getTen() {
        return Ten;
    }
    
    public void setTen(String ten) {
        this.Ten = ten;
    }
    
    public String getGioiTinh() {
        return GioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }
    
    public Date getNgaySinh() {
        return NgaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.NgaySinh = ngaySinh;
    }
    
    // Phương thức chung
    public String getNgaySinhFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(NgaySinh);
    }
    
    // Phương thức XuatSV() - tương đương toString()
    public String XuatSV() {
        return "Mã SV: " + MaSV + ", Tên: " + Ten + 
               ", Giới tính: " + GioiTinh + ", Ngày sinh: " + getNgaySinhFormatted();
    }
    
    @Override
    public String toString() {
        return XuatSV();
    }
    
    // Các phương thức cần override bởi lớp con
    public String TinhXepLoai() {
        return "Chưa xác định";
    }
    
    public String getThongTin() {
        return "Mã SV: " + MaSV + "\n" +
               "Tên: " + Ten + "\n" +
               "Giới tính: " + GioiTinh + "\n" +
               "Ngày sinh: " + getNgaySinhFormatted() + "\n";
    }
    
    public String getHeDaoTao() {
        return "Chưa xác định";
    }
}