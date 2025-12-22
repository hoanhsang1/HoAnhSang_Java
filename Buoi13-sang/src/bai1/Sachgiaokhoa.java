package bai1;
import java.util.Date;

public class Sachgiaokhoa extends Sach {
    protected boolean TinhTrang; // true = mới, false = cũ
    
    // Constructor
    public Sachgiaokhoa() {
        super();
    }
    
    public Sachgiaokhoa(String MaS, Date NgayNhap, double DonGia, int SL, 
                       String NhaXB, boolean TinhTrang) {
        super(MaS, NgayNhap, DonGia, SL, NhaXB);
        this.TinhTrang = TinhTrang;
    }
    
    // Getter và Setter cho TinhTrang
    public boolean isTinhTrang() {
        return TinhTrang;
    }
    
    public void setTinhTrang(boolean tinhTrang) {
        this.TinhTrang = tinhTrang;
    }
    
    // Phương thức trả về tình trạng dạng chuỗi
    public String getTinhTrangString() {
        return TinhTrang ? "Moi" : "Cu";
    }
    
    // Có thể thêm getter/setter cho các thuộc tính kế thừa nếu muốn truy cập trực tiếp
    // (Không cần thiết vì đã có từ lớp cha, nhưng nếu muốn có thể thêm)
    
    @Override
    public double ThanhTien() {
        double thanhTienCoBan = SL * DonGia;
        if (TinhTrang) {
            return thanhTienCoBan; // Sách mới: 100%
        } else {
            return thanhTienCoBan * 0.5; // Sách cũ: 50%
        }
    }
    
    @Override
    public String toString() {
        return String.format("SGK|%s|%s|%.2f|%d|%s|%s|%.2f", 
            MaS, getNgayNhapFormatted(), DonGia, SL, NhaXB, 
            getTinhTrangString(), ThanhTien());
    }
}