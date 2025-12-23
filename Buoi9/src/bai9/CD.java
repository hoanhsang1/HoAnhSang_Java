package bai9;

public class CD {
    // Thuộc tính private
    private int maCD;           // Mã CD
    private String tuaCD;       // Tựa CD
    private String caSy;        // Ca sĩ
    private int soBaiHat;       // Số bài hát (>0)
    private double giaThanh;    // Giá thành (>0)
    
    // Constructor mặc định
    public CD() {
        this.maCD = 0;
        this.tuaCD = "Chưa có";
        this.caSy = "Chưa có";
        this.soBaiHat = 1;
        this.giaThanh = 10000;
    }
    
    // Constructor đầy đủ tham số
    public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setCaSy(caSy);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }
    
    // GETTER - SETTER với kiểm tra ràng buộc
    
    public int getMaCD() {
        return maCD;
    }
    
    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }
    
    public String getTuaCD() {
        return tuaCD;
    }
    
    public void setTuaCD(String tuaCD) {
        if (tuaCD == null || tuaCD.trim().isEmpty()) {
            this.tuaCD = "Chưa có";
        } else {
            this.tuaCD = tuaCD;
        }
    }
    
    public String getCaSy() {
        return caSy;
    }
    
    public void setCaSy(String caSy) {
        if (caSy == null || caSy.trim().isEmpty()) {
            this.caSy = "Chưa có";
        } else {
            this.caSy = caSy;
        }
    }
    
    public int getSoBaiHat() {
        return soBaiHat;
    }
    
    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0) {
            this.soBaiHat = 1;
        } else {
            this.soBaiHat = soBaiHat;
        }
    }
    
    public double getGiaThanh() {
        return giaThanh;
    }
    
    public void setGiaThanh(double giaThanh) {
        if (giaThanh <= 0) {
            this.giaThanh = 10000;
        } else {
            this.giaThanh = giaThanh;
        }
    }
    
    // Phương thức toString
    @Override
    public String toString() {
        return String.format("│ %-8d │ %-25s │ %-20s │ %10d │ %,15.0f VNĐ │",
            maCD, tuaCD, caSy, soBaiHat, giaThanh);
    }
    
    // Phương thức toString cho hiển thị đẹp
    public String toStringDep() {
        return String.format(
            "┌─────────────────────────────────────────────────────────────────────────────────┐\n" +
            "│                                THÔNG TIN CD                                    │\n" +
            "├─────────────────────────────────────────────────────────────────────────────────┤\n" +
            "│ Mã CD: %-70d │\n" +
            "│ Tựa CD: %-69s │\n" +
            "│ Ca sĩ: %-70s │\n" +
            "│ Số bài hát: %-66d │\n" +
            "│ Giá thành: %-,65.0f VNĐ │\n" +
            "└─────────────────────────────────────────────────────────────────────────────────┘",
            maCD, tuaCD, caSy, soBaiHat, giaThanh
        );
    }
}
