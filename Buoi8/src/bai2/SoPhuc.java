package bai2;

public class SoPhuc {
    // Thuộc tính
    private double phanThuc;
    private double phanAo;
    
    // 1. Hàm dựng rỗng
    public SoPhuc() {
        this.phanThuc = 0;
        this.phanAo = 0;
    }
    
    // 2. Hàm dựng có tham số
    public SoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }
    
    // 3. Getter - Setter
    public double getPhanThuc() {
        return phanThuc;
    }
    
    public void setPhanThuc(double phanThuc) {
        this.phanThuc = phanThuc;
    }
    
    public double getPhanAo() {
        return phanAo;
    }
    
    public void setPhanAo(double phanAo) {
        this.phanAo = phanAo;
    }
    
    // 4. Cộng hai số phức
    public SoPhuc cong(SoPhuc sp) {
        return new SoPhuc(this.phanThuc + sp.phanThuc, this.phanAo + sp.phanAo);
    }
    
    // 5. Trừ hai số phức
    public SoPhuc tru(SoPhuc sp) {
        return new SoPhuc(this.phanThuc - sp.phanThuc, this.phanAo - sp.phanAo);
    }
    
    // 6. Nhân hai số phức
    public SoPhuc nhan(SoPhuc sp) {
        // (a+bi)*(c+di) = (ac - bd) + (ad + bc)i
        double thuc = this.phanThuc * sp.phanThuc - this.phanAo * sp.phanAo;
        double ao = this.phanThuc * sp.phanAo + this.phanAo * sp.phanThuc;
        return new SoPhuc(thuc, ao);
    }
    
    // 7. Chia hai số phức
    public SoPhuc chia(SoPhuc sp) {
        // (a+bi)/(c+di) = [(a+bi)*(c-di)] / (c² + d²)
        double mau = sp.phanThuc * sp.phanThuc + sp.phanAo * sp.phanAo;
        
        if (mau == 0) {
            throw new ArithmeticException("Không thể chia cho số phức có module bằng 0!");
        }
        
        // Nhân với liên hợp
        SoPhuc lienHop = new SoPhuc(sp.phanThuc, -sp.phanAo);
        SoPhuc tu = this.nhan(lienHop);
        
        return new SoPhuc(tu.phanThuc / mau, tu.phanAo / mau);
    }
    
    // 8. Tính module (độ lớn)
    public double module() {
        return Math.sqrt(phanThuc * phanThuc + phanAo * phanAo);
    }
    
    // 9. Số phức liên hợp
    public SoPhuc lienHop() {
        return new SoPhuc(this.phanThuc, -this.phanAo);
    }
    
    // 10. Tính argument (góc φ)
    public double argument() {
        if (phanThuc == 0 && phanAo == 0) {
            return 0;
        }
        return Math.atan2(phanAo, phanThuc);
    }
    
    // 11. Lũy thừa số phức (n nguyên)
    public SoPhuc luyThua(int n) {
        if (n == 0) {
            return new SoPhuc(1, 0);
        }
        
        SoPhuc ketQua = new SoPhuc(this.phanThuc, this.phanAo);
        for (int i = 1; i < n; i++) {
            ketQua = ketQua.nhan(this);
        }
        return ketQua;
    }
    
    // 12. So sánh bằng
    public boolean bangNhau(SoPhuc sp) {
        return Math.abs(this.phanThuc - sp.phanThuc) < 0.0001 && 
               Math.abs(this.phanAo - sp.phanAo) < 0.0001;
    }
    
    // 13. Chuyển sang dạng lượng giác
    public String dangLuongGiac() {
        double r = this.module();
        double phi = this.argument();
        return String.format("%.2f(cos(%.2f) + i*sin(%.2f))", r, phi, phi);
    }
    
    // 14. Xuất số phức dạng a + bi
    public String xuatSoPhuc() {
        if (phanAo == 0) {
            return String.format("%.2f", phanThuc);
        } else if (phanThuc == 0) {
            return String.format("%.2fi", phanAo);
        } else if (phanAo > 0) {
            return String.format("%.2f + %.2fi", phanThuc, phanAo);
        } else {
            return String.format("%.2f - %.2fi", phanThuc, -phanAo);
        }
    }
    
    // 15. Kiểm tra số phức thuần ảo
    public boolean laSoPhucThuanAo() {
        return phanThuc == 0 && phanAo != 0;
    }
    
    // 16. Kiểm tra số phức thuần thực
    public boolean laSoPhucThuanThuc() {
        return phanAo == 0;
    }
}
