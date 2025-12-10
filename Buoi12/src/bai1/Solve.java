package bai1;
import java.util.*;

public class Solve {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Employee> ds = new ArrayList<Employee>();
    
    // Phương thức kiểm tra mã NV đã tồn tại chưa
    public boolean isMaNVDaTonTai(String maNV) {
        for (Employee emp : ds) {
            if (emp.getMaNV().equalsIgnoreCase(maNV)) {
                return true; // Mã đã tồn tại
            }
        }
        return false; // Mã chưa tồn tại
    }
    
    // Phương thức nhập mã NV và kiểm tra duy nhất
    public String nhapMaNV() {
        String maNV;
        while (true) {
            System.out.print("Nhập mã nhân viên: ");
            maNV = sc.nextLine().trim();
            
            if (maNV.isEmpty()) {
                System.out.println("Lỗi: Mã nhân viên không được để trống!");
                continue;
            }
            
            if (isMaNVDaTonTai(maNV)) {
                System.out.println("Lỗi: Mã nhân viên '" + maNV + "' đã tồn tại!");
                System.out.println("Vui lòng nhập mã khác.");
            } else {
                break; // Mã hợp lệ và duy nhất
            }
        }
        return maNV;
    }
    
    public double DoubleInput(String message) {
        double value = 0;
        boolean check = false;
        while(!check) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                value = Double.parseDouble(input);
                
                // Kiểm tra giá trị dương
                if (value < 0) {
                    System.out.println("Lỗi: Giá trị phải lớn hơn 0!");
                    continue;
                }
                
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui long nhập một số hợp lệ!");
            }
        }
        return value;
    }
    
    public static int nhapSoNguyen(String message) {
        int value = 0;
        boolean isValid = false;
        
        while (!isValid) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                value = Integer.parseInt(input);
                
                // Kiểm tra giá trị dương
                if (value < 0) {
                    System.out.println("Lỗi: Giá trị phải lớn hơn 0!");
                    continue;
                }
                
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui long nhập một so nguyen hợp le!");
            }
        }
        
        return value;
    }
    
    public static int nhapTuoi(String message) {
        int tuoi = 0;
        boolean isValid = false;
        
        while (!isValid) {
            tuoi = nhapSoNguyen(message);
            
            // Kiểm tra điều kiện tuổi
            if (tuoi < 18) {
                System.out.println("Lỗi: Tuoi phải lớn hơn hoặc bằng 18!");
                System.out.println("(Theo quy dinh, nhan vien phai du 18 tuoi tro len)");
            } else if (tuoi > 56) {
                System.out.println("Lỗi: Tuoi phải nhỏ hơn hoặc bằng 56!");
                System.out.println("(Theo quy dinh, tuoi nghi huu la 56 cho mot so nghe)");
            } else {
                isValid = true;
            }
        }
        
        return tuoi;
    }
    
    public ArrayList<Employee> taoDanhSach() {
        int n = nhapSoNguyen("Nhập số lượng nhân viên muốn thêm: ");
        int a;
        for(int i = 0; i < n; i++) {
            System.out.println("\n=== NHẬP THÔNG TIN NHÂN VIÊN THỨ " + (i+1) + " ===");
            System.out.println("Nhập 0 nếu là nhân viên full time");
            System.out.println("Nhập 1 nếu là nhân viên part time");
            
            while(true) {
                a = nhapSoNguyen("Nhập lựa chọn: ");
                if (a == 0 || a == 1) {
                    break;
                }
                System.out.println("Lỗi: Chỉ nhập 0 hoặc 1!");
            }
            
            // Sử dụng phương thức nhập mã NV với kiểm tra duy nhất
            String maNV = nhapMaNV();
            
            System.out.print("Nhập tên nhân viên: ");
            String ten = sc.nextLine();
            
            int tuoi = nhapTuoi("Nhập tuổi của nhân viên: ");
            double HeSoLuong = DoubleInput("Nhập hệ số lương: ");
            
            if (a == 0) {
                double LuongCoBan = DoubleInput("Nhập lương cơ bản: ");
                FullTimeEmployee nv = new FullTimeEmployee(LuongCoBan, maNV, HeSoLuong, ten, tuoi);
                ds.add(nv);
                System.out.println("✓ Đã thêm nhân viên FullTime: " + ten);
            } else {
                double SoGioLam = DoubleInput("Nhập số giờ làm: ");
                double DonGiaGio = DoubleInput("Nhập đơn giá giờ: ");
                PartTimeEmployee nv = new PartTimeEmployee(SoGioLam, DonGiaGio, maNV, HeSoLuong, ten, tuoi);
                ds.add(nv);
                System.out.println("✓ Đã thêm nhân viên PartTime: " + ten);
            }
            
            System.out.println("----------------------------------------");
        }
        return ds;
    }
    
    public ArrayList<PartTimeEmployee> getDanhSachPartTime() {
        ArrayList<PartTimeEmployee> result = new ArrayList<>();
        for (Employee emp : ds) {
            if (emp instanceof PartTimeEmployee) {
                result.add((PartTimeEmployee) emp);
            }
        }
        return result;
    }
    
    public ArrayList<FullTimeEmployee> getDanhSachFullTime() {
        ArrayList<FullTimeEmployee> result = new ArrayList<>();
        for (Employee emp : ds) {
            if (emp instanceof FullTimeEmployee) {
                result.add((FullTimeEmployee) emp);
            }
        }
        return result;
    }
    
    public Employee timNVCaoNhat() {
        if (ds.isEmpty()) {
            return null;
        }
        
        Employee nvMax = ds.get(0);
        for (Employee emp : ds) {
            if (emp.TinhLuong() > nvMax.TinhLuong()) {
                nvMax = emp;
            }
        }
        return nvMax;
    }
    
    public boolean isDanhSachRong() {
        return ds.isEmpty();
    }
    
    public ArrayList<Employee> getDanhSachNV() {
        return ds;
    }
}