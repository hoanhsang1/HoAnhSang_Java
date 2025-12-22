package TaomoiTV;

public class Toanhoc {
	
    // Hàm tính tổng các chữ số
    public static int sumDigit(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    // Hàm đảo ngược số
    public static int reverse(int n) {
        String chuoi = Integer.toString(n);
        String b = "";
        for (int i = chuoi.length() - 1; i >= 0; i--) {
            b += chuoi.charAt(i);
        }
        return Integer.parseInt(b);
    }
    
    // Hàm tính tổng số chẵn đầu tiên
    public static int sumEvenNumbers(int n) {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum = sum + i * 2;
        }
        return sum;
    }
    
    // Hàm tính tổng từ 1 đến n
    public static int sum1ToN(int n) {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum = sum + i;
        }
        return sum;
    }
    
    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // Hàm tìm UCLN
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Hàm tính giai thừa
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n phải ≥ 0");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    // --- CÁC HÀM MỚI ---

    // Hàm tính Bội chung nhỏ nhất (BCNN)
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        // BCNN = (|a * b|) / UCLN(a, b)
        return Math.abs(a * b) / gcd(a, b);
    }

    // Hàm kiểm tra số chính phương
    public static boolean isSquareNumber(int n) {
        if (n < 0) return false;
        long sqrt = Math.round(Math.sqrt(n)); // Sử dụng Math.round để xử lý số thực
        return sqrt * sqrt == n;
    }
}