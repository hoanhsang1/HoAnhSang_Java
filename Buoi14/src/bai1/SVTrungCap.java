package bai1;

import java.util.Date;

public class SVTrungCap extends SV {
    private int NienChe; // 2 năm
    private double DiemThiTN;
    private String XepLoai;
    
    public SVTrungCap() {
        super();
        this.NienChe = 2; // Trung cấp là 2 năm
        this.XepLoai = TinhXepLoai();
    }
    
    public SVTrungCap(String maSV, String ten, String gioiTinh, 
                   Date ngaySinh, double diemThiTN) {
        super(maSV, ten, gioiTinh, ngaySinh);
        this.NienChe = 2;
        this.DiemThiTN = diemThiTN;
        this.XepLoai = TinhXepLoai();
    }
    
    // Getter và Setter
    public int getNienChe() {
        return NienChe;
    }
    
    public void setNienChe(int nienChe) {
        this.NienChe = nienChe;
    }
    
    public double getDiemThiTN() {
        return DiemThiTN;
    }
    
    public void setDiemThiTN(double diemThiTN) {
        this.DiemThiTN = diemThiTN;
        this.XepLoai = TinhXepLoai(); // Cập nhật xếp loại khi thay đổi điểm
    }
    
    public String getXepLoai() {
        return XepLoai;
    }
    
    @Override
    public String TinhXepLoai() {
        if (DiemThiTN >= 8.0) {
            return "Giỏi";
        } else if (DiemThiTN >= 6.5) {
            return "Khá";
        } else if (DiemThiTN >= 5.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
    
    @Override
    public String getThongTin() {
        return "Sinh viên Trung cấp\n" +
               "Mã SV: " + MaSV + "\n" +
               "Tên: " + Ten + "\n" +
               "Giới tính: " + GioiTinh + "\n" +
               "Ngày sinh: " + getNgaySinhFormatted() + "\n" +
               "Niên chế: " + NienChe + " năm\n" +
               "Điểm thi tốt nghiệp: " + DiemThiTN + "\n" +
               "Xếp loại: " + XepLoai + "\n";
    }
    
    @Override
    public String getHeDaoTao() {
        return "Trung cấp";
    }
    
    // Ghi đè phương thức XuatSV()
    @Override
    public String XuatSV() {
        return super.XuatSV() + ", Hệ: Trung cấp" + 
               ", Niên chế: " + NienChe + " năm" +
               ", Điểm thi TN: " + DiemThiTN + 
               ", Xếp loại: " + XepLoai;
    }
}