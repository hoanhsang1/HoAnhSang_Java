package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PhieuKiemKe {
    private String maPhieu;
    private LocalDate ngayKiemKe;
    private NhanVien nhanVienKK;
    private PhongBan phongBanKK;
    private List<TaiSan> danhSachTS;
    
    public PhieuKiemKe(String maPhieu, LocalDate ngayKiemKe, NhanVien nhanVienKK, PhongBan phongBanKK) {
        if (maPhieu == null || maPhieu.trim().isEmpty())
            throw new IllegalArgumentException("Mã phiếu không được để trống");
        if (nhanVienKK == null)
            throw new IllegalArgumentException("Nhân viên kiểm kê không được null");
        if (phongBanKK == null)
            throw new IllegalArgumentException("Phòng ban kiểm kê không được null");
        
        this.maPhieu = maPhieu.trim();
        this.ngayKiemKe = ngayKiemKe != null ? ngayKiemKe : LocalDate.now();
        this.nhanVienKK = nhanVienKK;
        this.phongBanKK = phongBanKK;
        this.danhSachTS = new ArrayList<>();
    }
    
    public void themTaiSan(TaiSan taiSan) {
        if (taiSan == null)
            throw new IllegalArgumentException("Tài sản không được null");
        danhSachTS.add(taiSan);
    }
    
    public int tongSoLuong() {
        int tong = 0;
        for (TaiSan ts : danhSachTS) {
            tong += ts.getSoLuong();
        }
        return tong;
    }
    
    public int soLoaiTaiSan() {
        return danhSachTS.size();
    }
    
    public String getMaPhieu() { return maPhieu; }
    public LocalDate getNgayKiemKe() { return ngayKiemKe; }
    public NhanVien getNhanVienKK() { return nhanVienKK; }
    public PhongBan getPhongBanKK() { return phongBanKK; }
    public List<TaiSan> getDanhSachTS() { return new ArrayList<>(danhSachTS); }
    
    public void xuatBaoCao() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PHIẾU KIỂM KÊ TÀI SẢN");
        System.out.println("═".repeat(60));
        
        System.out.println("Mã phiếu: " + maPhieu);
        System.out.println("Ngày kiểm kê: " + ngayKiemKe.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("-".repeat(60));
        
        System.out.println("Nhân viên kiểm kê: " + nhanVienKK.getTenNV());
        System.out.println("Chức vụ: " + nhanVienKK.getChucVu());
        System.out.println("Kiểm kê tại phòng: " + phongBanKK.getTenPhong());
        System.out.println("Mã phòng: " + phongBanKK.getMaPhong());
        System.out.println("Trưởng phòng: " + phongBanKK.getTruongPhong());
        System.out.println("-".repeat(60));
        
        System.out.println("Tên tài sản            | Số lượng | Tình trạng");
        System.out.println("-".repeat(60));
        
        if (danhSachTS.isEmpty()) {
            System.out.println("Không có tài sản");
        } else {
            for (TaiSan ts : danhSachTS) {
                System.out.printf("%-22s | %-8d | %s\n", 
                    ts.getTenTS(), ts.getSoLuong(), ts.getTinhTrang());
            }
        }
        
        System.out.println("-".repeat(60));
        System.out.println("Số tài sản đã kiểm kê: " + soLoaiTaiSan() + 
                          ". Tổ số lượng: " + tongSoLuong());
        System.out.println("═".repeat(60));
    }
}