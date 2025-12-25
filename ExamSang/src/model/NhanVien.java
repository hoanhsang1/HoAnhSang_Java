package model;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String chucVu;
    private PhongBan phongBan;
    private Quyen quyen;
    
    public NhanVien(String maNV, String tenNV, String chucVu, PhongBan phongBan, Quyen quyen) {
        if (maNV == null || maNV.trim().isEmpty())
            throw new IllegalArgumentException("Mã NV không được để trống");
        if (tenNV == null || tenNV.trim().isEmpty())
            throw new IllegalArgumentException("Tên NV không được để trống");
        if (phongBan == null)
            throw new IllegalArgumentException("Phòng ban không được null");
        
        this.maNV = maNV.trim();
        this.tenNV = tenNV.trim();
        this.chucVu = chucVu != null ? chucVu.trim() : "";
        this.phongBan = phongBan;
        this.quyen = quyen != null ? quyen : Quyen.XEM_BAO_CAO;
    }
    
    public String getMaNV() { return maNV; }
    public String getTenNV() { return tenNV; }
    public String getChucVu() { return chucVu; }
    public PhongBan getPhongBan() { return phongBan; }
    public Quyen getQuyen() { return quyen; }
    
    public boolean laTruongPhong() {
        return quyen == Quyen.TRUONG_PHONG;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%s)", maNV, tenNV, chucVu);
    }
}