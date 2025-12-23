package bai4;

import TaomoiTV.Test;
import java.util.ArrayList;

public class QuanLyBienLai {
    private ArrayList<BienLai> danhSachBienLai;
    private Test test;
    
    public QuanLyBienLai() {
        danhSachBienLai = new ArrayList<>();
        test = new Test();
    }
    
    // 1. Kiểm tra mã công tơ đã tồn tại chưa
    private boolean kiemTraMaCongToDaTonTai(String maCongTo) {
        for (BienLai bl : danhSachBienLai) {
            if (bl.getKhachHang().getMaSoCongTo().equalsIgnoreCase(maCongTo)) {
                return true;
            }
        }
        return false;
    }
    
    // 2. Kiểm tra số nhà đã tồn tại chưa (tùy chọn)
    private boolean kiemTraSoNhaDaTonTai(String soNha) {
        for (BienLai bl : danhSachBienLai) {
            if (bl.getKhachHang().getSoNha().equalsIgnoreCase(soNha)) {
                return true;
            }
        }
        return false;
    }
    
    // 3. Nhập thông tin cho n hộ (VỚI KIỂM TRA TRÙNG)
    public void nhapDanhSachHoaDon() {
        System.out.println("\n=== NHẬP DANH SÁCH BIÊN LAI ===");
        
        int n = test.inputPositiveInt("Nhập số lượng hộ cần nhập: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Hộ thứ " + (i + 1) + " ---");
            
            // Tạo biên lai tạm để nhập
            BienLai bl = new BienLai();
            
            // Nhập thông tin cơ bản
            System.out.print("Họ tên chủ hộ: ");
            String hoTen = test.inputNonEmptyString("");
            
            // Nhập số nhà và kiểm tra
            String soNha;
            while (true) {
                System.out.print("Số nhà: ");
                soNha = test.inputNonEmptyString("");
                
                if (kiemTraSoNhaDaTonTai(soNha)) {
                    System.out.println("⚠ Số nhà '" + soNha + "' đã tồn tại! Vui lòng nhập số nhà khác.");
                } else {
                    break;
                }
            }
            
            // Nhập mã công tơ và kiểm tra
            String maCongTo;
            while (true) {
                System.out.print("Mã số công tơ: ");
                maCongTo = test.inputNonEmptyString("");
                
                if (kiemTraMaCongToDaTonTai(maCongTo)) {
                    System.out.println("⚠ Mã công tơ '" + maCongTo + "' đã tồn tại! Vui lòng nhập mã khác.");
                } else {
                    break;
                }
            }
            
            // Thiết lập thông tin khách hàng
            bl.getKhachHang().setHoTenChuHo(hoTen);
            bl.getKhachHang().setSoNha(soNha);
            bl.getKhachHang().setMaSoCongTo(maCongTo);
            
            // Nhập chỉ số điện
            System.out.println("\n--- NHẬP CHỈ SỐ ĐIỆN ---");
            
            // Nhập chỉ số cũ
            int chiSoCu = test.inputPositiveInt("Chỉ số cũ (kWh): ");
            
            // Nhập chỉ số mới (phải >= chỉ số cũ)
            int chiSoMoi;
            while (true) {
                chiSoMoi = test.inputPositiveInt("Chỉ số mới (kWh): ");
                if (chiSoMoi >= chiSoCu) {
                    break;
                }
                System.out.println("⚠ Chỉ số mới phải >= chỉ số cũ (" + chiSoCu + ")! Vui lòng nhập lại.");
            }
            
            bl.setChiSoCu(chiSoCu);
            bl.setChiSoMoi(chiSoMoi);
            
            // Thêm vào danh sách
            danhSachBienLai.add(bl);
            System.out.println("✓ Đã thêm hộ: " + hoTen + " - Số nhà: " + soNha);
        }
        
        System.out.println("\n✓ Đã nhập xong " + n + " hộ sử dụng điện!");
    }
    
    // 4. Hiển thị tất cả biên lai
    public void hienThiTatCaBienLai() {
        if (danhSachBienLai.isEmpty()) {
            System.out.println("\n⚠ Chưa có biên lai nào trong hệ thống!");
            return;
        }
        
        System.out.println("\n========================================================================================");
        System.out.println("                     DANH SÁCH BIÊN LAI ĐIỆN (" + danhSachBienLai.size() + " hộ)");
        System.out.println("========================================================================================");
        System.out.println("STT  Họ tên chủ hộ           Số nhà    Mã công tơ    Chỉ cũ  Chỉ mới  Tiền điện (VNĐ)");
        System.out.println("---------------------------------------------------------------------------------------");
        
        for (int i = 0; i < danhSachBienLai.size(); i++) {
            BienLai bl = danhSachBienLai.get(i);
            String ten = bl.getKhachHang().getHoTenChuHo();
            if (ten.length() > 20) ten = ten.substring(0, 17) + "...";
            
            String maCongTo = bl.getKhachHang().getMaSoCongTo();
            if (maCongTo.length() > 12) maCongTo = maCongTo.substring(0, 9) + "...";
            
            System.out.printf("%-4d %-23s %-10s %-13s %7d %7d %,15.0f\n",
                i + 1,
                ten,
                bl.getKhachHang().getSoNha(),
                maCongTo,
                bl.getChiSoCu(),
                bl.getChiSoMoi(),
                bl.getSoTienPhaiTra());
        }
        
        System.out.println("========================================================================================");
        
        // Thống kê
        thongKeTienDien();
    }
    
    // 5. Thêm 1 biên lai mới (VỚI KIỂM TRA TRÙNG)
    public void themBienLai() {
        System.out.println("\n=== THÊM BIÊN LAI MỚI ===");
        
        // Tạo biên lai tạm
        BienLai bl = new BienLai();
        
        // Nhập thông tin cơ bản
        System.out.print("Họ tên chủ hộ: ");
        String hoTen = test.inputNonEmptyString("");
        
        // Nhập số nhà và kiểm tra
        String soNha;
        while (true) {
            System.out.print("Số nhà: ");
            soNha = test.inputNonEmptyString("");
            
            if (kiemTraSoNhaDaTonTai(soNha)) {
                System.out.println("⚠ Số nhà '" + soNha + "' đã tồn tại! Vui lòng nhập số nhà khác.");
            } else {
                break;
            }
        }
        
        // Nhập mã công tơ và kiểm tra
        String maCongTo;
        while (true) {
            System.out.print("Mã số công tơ: ");
            maCongTo = test.inputNonEmptyString("");
            
            if (kiemTraMaCongToDaTonTai(maCongTo)) {
                System.out.println("⚠ Mã công tơ '" + maCongTo + "' đã tồn tại! Vui lòng nhập mã khác.");
            } else {
                break;
            }
        }
        
        // Thiết lập thông tin khách hàng
        bl.getKhachHang().setHoTenChuHo(hoTen);
        bl.getKhachHang().setSoNha(soNha);
        bl.getKhachHang().setMaSoCongTo(maCongTo);
        
        // Nhập chỉ số điện
        System.out.println("\n--- NHẬP CHỈ SỐ ĐIỆN ---");
        
        // Nhập chỉ số cũ
        int chiSoCu = test.inputPositiveInt("Chỉ số cũ (kWh): ");
        
        // Nhập chỉ số mới (phải >= chỉ số cũ)
        int chiSoMoi;
        while (true) {
            chiSoMoi = test.inputPositiveInt("Chỉ số mới (kWh): ");
            if (chiSoMoi >= chiSoCu) {
                break;
            }
            System.out.println("⚠ Chỉ số mới phải >= chỉ số cũ (" + chiSoCu + ")! Vui lòng nhập lại.");
        }
        
        bl.setChiSoCu(chiSoCu);
        bl.setChiSoMoi(chiSoMoi);
        
        // Thêm vào danh sách
        danhSachBienLai.add(bl);
        System.out.println("\n✓ Đã thêm biên lai mới thành công!");
        System.out.println("• Chủ hộ: " + hoTen);
        System.out.println("• Số nhà: " + soNha);
        System.out.println("• Mã công tơ: " + maCongTo);
    }
    
    // 6. Hiển thị chi tiết 1 biên lai
    public void hienThiChiTietBienLai() {
        if (danhSachBienLai.isEmpty()) {
            System.out.println("\n⚠ Chưa có biên lai nào!");
            return;
        }
        
        int stt = test.inputIntInRange(
            "Nhập số thứ tự biên lai cần xem (1-" + danhSachBienLai.size() + "): ", 
            1, danhSachBienLai.size());
        
        danhSachBienLai.get(stt - 1).hienThiThongTin();
    }
    
    // 7. Thống kê tiền điện
    private void thongKeTienDien() {
        if (danhSachBienLai.isEmpty()) return;
        
        double tongTien = 0;
        double minTien = danhSachBienLai.get(0).getSoTienPhaiTra();
        double maxTien = danhSachBienLai.get(0).getSoTienPhaiTra();
        
        for (BienLai bl : danhSachBienLai) {
            double tien = bl.getSoTienPhaiTra();
            tongTien += tien;
            if (tien < minTien) minTien = tien;
            if (tien > maxTien) maxTien = tien;
        }
        
        double trungBinh = tongTien / danhSachBienLai.size();
        
        System.out.println("THỐNG KÊ:");
        System.out.printf("• Tổng số hộ: %d\n", danhSachBienLai.size());
        System.out.printf("• Tổng tiền: %,.0f VNĐ\n", tongTien);
        System.out.printf("• Tiền trung bình: %,.0f VNĐ\n", trungBinh);
        System.out.printf("• Tiền cao nhất: %,.0f VNĐ\n", maxTien);
        System.out.printf("• Tiền thấp nhất: %,.0f VNĐ\n", minTien);
        System.out.println("========================================================================\n");
    }
    
    // 8. Tìm kiếm theo tên chủ hộ
    public void timKiemTheoTen() {
        if (danhSachBienLai.isEmpty()) {
            System.out.println("\n⚠ Chưa có biên lai nào!");
            return;
        }
        
        String tenCanTim = test.inputNonEmptyString("Nhập tên chủ hộ cần tìm: ");
        boolean found = false;
        
        System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
        System.out.println("STT  Họ tên chủ hộ           Số nhà    Mã công tơ    Chỉ cũ  Chỉ mới  Tiền điện (VNĐ)");
        System.out.println("---------------------------------------------------------------------------------------");
        
        for (int i = 0; i < danhSachBienLai.size(); i++) {
            String tenChuHo = danhSachBienLai.get(i).getKhachHang().getHoTenChuHo();
            if (tenChuHo.toLowerCase().contains(tenCanTim.toLowerCase())) {
                BienLai bl = danhSachBienLai.get(i);
                String ten = bl.getKhachHang().getHoTenChuHo();
                if (ten.length() > 20) ten = ten.substring(0, 17) + "...";
                
                System.out.printf("%-4d %-23s %-10s %-13s %7d %7d %,15.0f\n",
                    i + 1,
                    ten,
                    bl.getKhachHang().getSoNha(),
                    bl.getKhachHang().getMaSoCongTo(),
                    bl.getChiSoCu(),
                    bl.getChiSoMoi(),
                    bl.getSoTienPhaiTra());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy chủ hộ có tên: " + tenCanTim);
        }
        System.out.println("---------------------------------------------------------------------------------------\n");
    }
    
    // 9. Tìm kiếm theo mã công tơ
    public void timKiemTheoMaCongTo() {
        if (danhSachBienLai.isEmpty()) {
            System.out.println("\n⚠ Chưa có biên lai nào!");
            return;
        }
        
        String maCanTim = test.inputNonEmptyString("Nhập mã công tơ cần tìm: ");
        boolean found = false;
        
        for (int i = 0; i < danhSachBienLai.size(); i++) {
            String maCongTo = danhSachBienLai.get(i).getKhachHang().getMaSoCongTo();
            if (maCongTo.equalsIgnoreCase(maCanTim)) {
                System.out.println("\n=== THÔNG TIN CHI TIẾT ===");
                danhSachBienLai.get(i).hienThiThongTin();
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy mã công tơ: " + maCanTim);
        }
    }
    
    // Getter danh sách
    public ArrayList<BienLai> getDanhSachBienLai() {
        return danhSachBienLai;
    }
}