package ktr;

public class Taikhoan {
    private int SoTaiKhoan;     // số tài khoản
    private double SoDu = 0;    // số dư ban đầu = 0

    // Constructor có tham số
    public Taikhoan(int SoTaiKhoan, double SoDu) {
        this.SoTaiKhoan = SoTaiKhoan;
        this.SoDu = SoDu;
    }

    // Constructor không tham số
    public Taikhoan() {}

    // Getter
    public int getSoTK() { return this.SoTaiKhoan; }
    public double getSoDu() { return this.SoDu; }

    // Setter cho số tài khoản
    public void setSoTK(int soTK) {
        if (soTK < 0) {
            System.out.println("Vui lòng nhập số tài khoản dương!");
        } else {
            this.SoTaiKhoan = soTK;
        }
    }

    // Nạp tiền
    public void NapTien(double SoTien) {
        this.SoDu = SoDu + SoTien;
    }

    // Rút tiền
    public void RutTien(double SoTien) {
    	if (SoTien < 0) {
            System.out.println("Vui lòng nhập số tài khoản dương!");
        } else {
        	if (SoTien > SoDu) {
                System.out.println("Số dư không đủ!");
            } else {
                this.SoDu = SoDu - SoTien;
            }
        }
        
    }

    // In thông tin tài khoản
    public void thongTin() {
        System.out.println("Số tài khoản: " + SoTaiKhoan);
        System.out.println("Số dư: " + SoDu);
    }
}
