package bai1;
import java.util.Date;

public class Sachthamkhao extends Sach {
    protected double Thue; // Thuế VAT (%)
    
    // Constructor
    public Sachthamkhao() {
        super();
    }
    
    public Sachthamkhao(String MaS, Date NgayNhap, double DonGia, int SL, 
                       String NhaXB, double Thue) {
        super(MaS, NgayNhap, DonGia, SL, NhaXB);
        this.Thue = Thue;
    }
    
    // Getter và Setter cho Thue
    public double getThue() {
        return Thue;
    }
    
    public void setThue(double thue) {
        this.Thue = thue;
    }
    
    @Override
    public double ThanhTien() {
        return SL * DonGia * (1 + Thue/100); // Cộng thêm thuế
    }
    
    @Override
    public String toString() {
        return String.format("STK|%s|%s|%.2f|%d|%s|%.1f%%|%.2f", 
            MaS, getNgayNhapFormatted(), DonGia, SL, NhaXB, 
            Thue, ThanhTien());
    }
}