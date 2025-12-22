package bai1;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sach {
    protected String MaS;
    protected Date NgayNhap;
    protected double DonGia;
    protected int SL;
    protected String NhaXB;
    
    // Constructor
    public Sach() {};
    
    public Sach(String MaS, Date NgayNhap, double DonGia, int SL, String NhaXB) {
        this.MaS = MaS;
        this.NgayNhap = NgayNhap;
        this.DonGia = DonGia;
        this.SL = SL;
        this.NhaXB = NhaXB;
    }
    
    // Getter và Setter
    public String getMaS() {
        return MaS;
    }
    
    public void setMaS(String maS) {
        this.MaS = maS;
    }
    
    public Date getNgayNhap() {
        return NgayNhap;
    }
    
    public void setNgayNhap(Date ngayNhap) {
        this.NgayNhap = ngayNhap;
    }
    
    public double getDonGia() {
        return DonGia;
    }
    
    public void setDonGia(double donGia) {
        this.DonGia = donGia;
    }
    
    public int getSL() {
        return SL;
    }
    
    public void setSL(int sl) {
        this.SL = sl;
    }
    
    public String getNhaXB() {
        return NhaXB;
    }
    
    public void setNhaXB(String nhaXB) {
        this.NhaXB = nhaXB;
    }
    
    // Phương thức tính tiền
    public double ThanhTien() {
        return SL * DonGia;
    }
    
    // Phương thức format ngày
    protected String getNgayNhapFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return (NgayNhap != null) ? sdf.format(NgayNhap) : "Chưa có";
    }
    
    @Override
    public String toString() {
        return String.format("%s|%s|%.2f|%d|%s|%.2f", 
            MaS, getNgayNhapFormatted(), DonGia, SL, NhaXB, ThanhTien());
    }
}