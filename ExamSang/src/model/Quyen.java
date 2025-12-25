package model;

public enum Quyen {
    ADMIN("Quản trị hệ thống", "Toàn quyền", 1),
    TRUONG_PHONG("Trưởng phòng", "Quản lý phòng ban", 2),
    QUAN_LY("Quản lý", "Quản lý và báo cáo", 3),
    NHAN_VIEN_KK("Nhân viên kiểm kê", "Nhập liệu kiểm kê", 4),
    XEM_BAO_CAO("Xem báo cáo", "Chỉ xem báo cáo", 5);
    
    private String tenQuyen;
    private String moTa;
    private int capDo;
    
    Quyen(String tenQuyen, String moTa, int capDo) {
        this.tenQuyen = tenQuyen;
        this.moTa = moTa;
        this.capDo = capDo;
    }
    
    public String getTenQuyen() { return tenQuyen; }
    public String getMoTa() { return moTa; }
    public int getCapDo() { return capDo; }
    
    public boolean coQuyenCaoHon(Quyen quyenKhac) {
        return this.capDo < quyenKhac.getCapDo();
    }
    
    @Override
    public String toString() {
        return tenQuyen;
    }
}