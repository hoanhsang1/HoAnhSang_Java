package bai1;

public class PhanSo {
    // Thuộc tính
    private int tuSo;
    private int mauSo;
    
    // 1. Hàm dựng rỗng
    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }
    
    // 2. Hàm dựng có tham số
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    
    // 3. Getter - Setter
    public int getTuSo() {
        return tuSo;
    }
    
    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }
    
    public int getMauSo() {
        return mauSo;
    }
    
    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }
    
    // 4. Tìm ước chung lớn nhất (UCLN) - công khai
    public int timUCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 5. Tìm bội chung nhỏ nhất (BCNN)
    public int timBCNN(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        return (a * b) / timUCLN(a, b);
    }
    
    // 6. Tìm UCLN của 2 phân số (tử với tử, mẫu với mẫu)
    public PhanSo timUCLNPhanSo(PhanSo ps) {
        int uclnTu = timUCLN(this.tuSo, ps.tuSo);
        int uclnMau = timUCLN(this.mauSo, ps.mauSo);
        return new PhanSo(uclnTu, uclnMau);
    }
    
    // 7. Tìm BCNN của 2 phân số
    public PhanSo timBCNNPhanSo(PhanSo ps) {
        // BCNN của phân số a/b và c/d = BCNN(a,c)/UCLN(b,d)
        int bcnnTu = timBCNN(this.tuSo, ps.tuSo);
        int uclnMau = timUCLN(this.mauSo, ps.mauSo);
        return new PhanSo(bcnnTu, uclnMau);
    }
    
    // 8. Rút gọn phân số
    public void rutGon() {
        if (mauSo == 0) return;
        
        int ucln = timUCLN(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
        
        // Đảm bảo mẫu số dương
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }
    
    // 9. Cộng 2 phân số
    public PhanSo cong(PhanSo ps) {
        int tu = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
        int mau = this.mauSo * ps.mauSo;
        return new PhanSo(tu, mau);
    }
    
    // 10. Trừ 2 phân số
    public PhanSo tru(PhanSo ps) {
        int tu = this.tuSo * ps.mauSo - ps.tuSo * this.mauSo;
        int mau = this.mauSo * ps.mauSo;
        return new PhanSo(tu, mau);
    }
    
    // 11. Nhân 2 phân số
    public PhanSo nhan(PhanSo ps) {
        int tu = this.tuSo * ps.tuSo;
        int mau = this.mauSo * ps.mauSo;
        return new PhanSo(tu, mau);
    }
    
    // 12. Chia 2 phân số
    public PhanSo chia(PhanSo ps) {
        int tu = this.tuSo * ps.mauSo;
        int mau = this.mauSo * ps.tuSo;
        return new PhanSo(tu, mau);
    }
    
    // 13. Xuất phân số
    public String xuatPhanSo() {
        rutGon();
        
        if (mauSo == 1) {
            return tuSo + "";
        } else if (tuSo == 0) {
            return "0";
        } else {
            return tuSo + "/" + mauSo;
        }
    }
}