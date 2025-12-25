package model;

public class PhongBan {
    private String maPhong;
    private String tenPhong;
    private String truongPhong;
    
    public PhongBan(String maPhong, String tenPhong, String truongPhong) {
        if (maPhong == null || maPhong.trim().isEmpty()) 
            throw new IllegalArgumentException("Mã phòng không được để trống");
        if (tenPhong == null || tenPhong.trim().isEmpty())
            throw new IllegalArgumentException("Tên phòng không được để trống");
        
        this.maPhong = maPhong.trim();
        this.tenPhong = tenPhong.trim();
        this.truongPhong = truongPhong != null ? truongPhong.trim() : "";
    }
    
    public String getMaPhong() { return maPhong; }
    public String getTenPhong() { return tenPhong; }
    public String getTruongPhong() { return truongPhong; }
    
    public void setTruongPhong(String truongPhong) { 
        this.truongPhong = truongPhong != null ? truongPhong.trim() : "";
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s", maPhong, tenPhong);
    }
}