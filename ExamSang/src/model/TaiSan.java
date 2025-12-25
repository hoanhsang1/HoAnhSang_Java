package model;

public class TaiSan {
    private String maTS;
    private String tenTS;
    private int soLuong;
    private String tinhTrang;
    
    public TaiSan(String maTS, String tenTS, int soLuong, String tinhTrang) {
        if (maTS == null || maTS.trim().isEmpty())
            throw new IllegalArgumentException("Mã tài sản không được để trống");
        if (tenTS == null || tenTS.trim().isEmpty())
            throw new IllegalArgumentException("Tên tài sản không được để trống");
        if (soLuong <= 0)
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0");
        
        this.maTS = maTS.trim();
        this.tenTS = tenTS.trim();
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang != null ? tinhTrang.trim() : "";
    }
    
    public String getMaTS() { return maTS; }
    public String getTenTS() { return tenTS; }
    public int getSoLuong() { return soLuong; }
    public String getTinhTrang() { return tinhTrang; }
    
    public void setSoLuong(int soLuong) { 
        if (soLuong <= 0) throw new IllegalArgumentException("Số lượng phải > 0");
        this.soLuong = soLuong; 
    }
    
    public void setTinhTrang(String tinhTrang) { 
        this.tinhTrang = tinhTrang != null ? tinhTrang.trim() : ""; 
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %-8d %-15s", tenTS, soLuong, tinhTrang);
    }
}