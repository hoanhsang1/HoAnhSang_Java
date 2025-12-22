package bai2;
import java.util.Scanner;
import java.util.Arrays;

public class Xulycau2 {
    private Scanner sc = new Scanner(System.in);
    private int[] arr;
    private int size;
    private boolean daSapXep = false; // Thêm cờ kiểm tra đã sắp xếp chưa
    
    // Phương thức kiểm tra số nguyên dương
    public int inputPositiveInt(String message) {
        int num;
        while (true) {
            System.out.print(message);
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= 1) {
                    return num;
                } else {
                    System.out.println("Số phải lớn hơn hoặc bằng 1. Vui lòng nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
    
    // Phương thức nhập số nguyên
    public int inputInt(String message) {
        int num;
        while (true) {
            System.out.print(message);
            try {
                num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
    
    // Câu 1: Nhập mảng số nguyên
    public void nhapMang() {
        size = inputPositiveInt("Nhập số phần tử của mảng: ");
        arr = new int[size];
        
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            arr[i] = inputInt("Phần tử thứ " + (i + 1) + ": ");
        }
        daSapXep = false; // Reset trạng thái sắp xếp khi nhập mảng mới
        System.out.println("Đã nhập mảng thành công!");
    }
    
    // Câu 2: Xuất mảng số nguyên
    public void xuatMang() {
        if (arr == null || size == 0) {
            System.out.println("Mảng chưa được khởi tạo hoặc rỗng!");
            return;
        }
        
        System.out.print("Mảng hiện tại: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        if (daSapXep) {
            System.out.println("(Mảng đã được sắp xếp giảm dần)");
        } else {
            System.out.println("(Mảng chưa được sắp xếp)");
        }
    }
    
    // Phương thức sắp xếp nội bộ (chỉ dùng bên trong class)
    private void sapXepNoiBo() {
        // Sắp xếp giảm dần bằng thuật toán Bubble Sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Hoán đổi vị trí
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        daSapXep = true;
    }
    
    // Câu 3: Sắp xếp mảng giảm dần (CHỈ SẮP XẾP KHI BẤM CHỌN 3)
    public void sapXepGiamDan() {
        if (arr == null || size == 0) {
            System.out.println("Mảng chưa được khởi tạo hoặc rỗng!");
            return;
        }
        
        if (daSapXep) {
            System.out.println("Mảng đã được sắp xếp trước đó!");
        } else {
            sapXepNoiBo();
            System.out.println("Đã sắp xếp mảng theo thứ tự giảm dần!");
        }
        xuatMang();
    }
    
    // Câu 4: Chèn phần tử vào mảng đã sắp xếp
    public void chenPhanTu() {
        if (arr == null || size == 0) {
            System.out.println("Mảng chưa được khởi tạo hoặc rỗng!");
            return;
        }
        
        // Kiểm tra xem mảng đã được sắp xếp giảm dần chưa
        if (!daSapXep) {
            System.out.println("Mảng chưa được sắp xếp giảm dần!");
            System.out.println("Bạn có muốn sắp xếp mảng trước khi chèn không?");
            System.out.println("1. Có, sắp xếp trước");
            System.out.println("2. Không, chèn vào mảng hiện tại");
            System.out.print("Lựa chọn: ");
            
            int choice = inputInt("");
            if (choice == 1) {
                sapXepNoiBo();
                System.out.println("Đã sắp xếp mảng trước khi chèn!");
            }
        }
        
        int value = inputInt("Nhập giá trị cần chèn: ");
        
        // Tạo mảng mới với kích thước lớn hơn 1
        int[] newArr = new int[size + 1];
        int insertIndex = size;
        
        if (daSapXep) {
            // Tìm vị trí chèn phù hợp trong mảng đã sắp xếp (giảm dần)
            for (int i = 0; i < size; i++) {
                if (value > arr[i]) {
                    insertIndex = i;
                    break;
                }
            }
        } else {
            // Nếu mảng chưa sắp xếp, chèn vào cuối
            insertIndex = size;
        }
        
        // Chèn phần tử vào vị trí thích hợp
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == insertIndex) {
                newArr[i] = value;
            } else {
                newArr[i] = arr[j];
                j++;
            }
        }
        
        arr = newArr;
        size++;
        
        // Nếu mảng đã sắp xếp trước đó, chèn xong vẫn giữ trạng thái đã sắp xếp
        // (vì chèn đúng vị trí nên vẫn đảm bảo thứ tự)
        if (!daSapXep) {
            // Kiểm tra lại xem sau khi chèn có còn đúng thứ tự không
            boolean vanSapXep = true;
            for (int i = 0; i < size - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    vanSapXep = false;
                    break;
                }
            }
            daSapXep = vanSapXep;
        }
        
        System.out.println("Đã chèn phần tử " + value + " vào mảng!");
        xuatMang();
    }
    
    // Câu 5: Trộn 2 mảng theo đúng thứ tự sắp xếp
    public void tronHaiMang() {
        if (arr == null || size == 0) {
            System.out.println("Mảng chưa được khởi tạo hoặc rỗng!");
            return;
        }
        
        System.out.println("=== NHẬP MẢNG THỨ 2 ĐỂ TRỘN ===");
        int size2 = inputPositiveInt("Nhập số phần tử của mảng thứ 2: ");
        int[] arr2 = new int[size2];
        
        System.out.println("Nhập các phần tử của mảng thứ 2:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = inputInt("Phần tử thứ " + (i + 1) + ": ");
        }
        
        // Hỏi người dùng có muốn sắp xếp mảng thứ 2 không
        System.out.println("\nBạn có muốn sắp xếp mảng thứ 2 giảm dần không?");
        System.out.println("1. Có, sắp xếp mảng thứ 2");
        System.out.println("2. Không, giữ nguyên thứ tự");
        System.out.print("Lựa chọn: ");
        
        int choice = inputInt("");
        if (choice == 1) {
            // Sắp xếp mảng thứ 2 giảm dần
            for (int i = 0; i < size2 - 1; i++) {
                for (int j = 0; j < size2 - i - 1; j++) {
                    if (arr2[j] < arr2[j + 1]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + 1];
                        arr2[j + 1] = temp;
                    }
                }
            }
            System.out.println("Đã sắp xếp mảng thứ 2 giảm dần!");
        }
        
        System.out.print("Mảng thứ 2: [");
        for (int i = 0; i < size2; i++) {
            System.out.print(arr2[i] + (i < size2 - 1 ? ", " : ""));
        }
        System.out.println("]");
        
        // Nếu mảng 1 chưa sắp xếp, hỏi người dùng
        if (!daSapXep) {
            System.out.println("\nMảng 1 chưa được sắp xếp!");
            System.out.println("1. Sắp xếp mảng 1 trước khi trộn");
            System.out.println("2. Trộn mà không sắp xếp mảng 1");
            System.out.print("Lựa chọn: ");
            
            choice = inputInt("");
            if (choice == 1) {
                sapXepNoiBo();
                System.out.println("Đã sắp xếp mảng 1 trước khi trộn!");
            }
        }
        
        // Trộn 2 mảng
        int[] mergedArr = new int[size + size2];
        int i = 0, j = 0, k = 0;
        
        // Nếu cả 2 mảng đều đã sắp xếp giảm dần, trộn theo thứ tự
        if (daSapXep && choice == 1) {
            while (i < size && j < size2) {
                if (arr[i] >= arr2[j]) {
                    mergedArr[k++] = arr[i++];
                } else {
                    mergedArr[k++] = arr2[j++];
                }
            }
        } else {
            // Nếu không, chỉ đơn giản nối mảng
            while (i < size) {
                mergedArr[k++] = arr[i++];
            }
            while (j < size2) {
                mergedArr[k++] = arr2[j++];
            }
        }
        
        while (i < size) {
            mergedArr[k++] = arr[i++];
        }
        
        while (j < size2) {
            mergedArr[k++] = arr2[j++];
        }
        
        arr = mergedArr;
        size = size + size2;
        
        // Nếu trộn 2 mảng đã sắp xếp, kết quả vẫn là mảng đã sắp xếp
        // Ngược lại, đánh dấu là chưa sắp xếp
        if (daSapXep && choice == 1) {
            daSapXep = true;
        } else {
            daSapXep = false;
        }
        
        System.out.println("Đã trộn 2 mảng thành công!");
        xuatMang();
    }
    
    // Câu 6: In ra các phần tử lớn hơn giá trị trung bình cộng
    public void phanTuLonHonTrungBinh() {
        if (arr == null || size == 0) {
            System.out.println("Mảng chưa được khởi tạo hoặc rỗng!");
            return;
        }
        
        // Tính tổng
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        
        double average = (double) sum / size;
        System.out.printf("Giá trị trung bình cộng: %.2f\n", average);
        
        // Tìm phần tử lớn hơn trung bình
        System.out.print("Các phần tử lớn hơn trung bình cộng: ");
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] > average) {
                System.out.print(arr[i] + " ");
                found = true;
            }
        }
        
        if (!found) {
            System.out.print("Không có phần tử nào lớn hơn trung bình cộng!");
        }
        System.out.println();
    }
    
    // Kiểm tra xem mảng đã được khởi tạo chưa
    public boolean isMangInitialized() {
        return arr != null && size > 0;
    }
    
    // Kiểm tra mảng đã được sắp xếp chưa
    public boolean isDaSapXep() {
        return daSapXep;
    }
}