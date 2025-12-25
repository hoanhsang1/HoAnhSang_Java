package ThuVienSang;

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

    // Hàm tính Bội chung nhỏ nhất (BCNN)
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    // Hàm kiểm tra số chính phương
    public static boolean isSquareNumber(int n) {
        if (n < 0) return false;
        long sqrt = Math.round(Math.sqrt(n));
        return sqrt * sqrt == n;
    }
    
    // ========== CÁC HÀM MỚI ==========
    
    // 1. Hàm kiểm tra số hoàn hảo (Perfect Number)
    public static boolean isPerfectNumber(int n) {
        if (n < 1) return false;
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
    
    // 2. Hàm kiểm tra số Armstrong (narcissistic number)
    public static boolean isArmstrongNumber(int n) {
        if (n < 0) return false;
        int original = n;
        int sum = 0;
        int digits = (int) Math.log10(n) + 1;
        
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }
    
    // 3. Hàm tính tổng các số nguyên tố từ 1 đến n
    public static int sumPrimesUpTo(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
    
    // 4. Hàm tính Fibonacci thứ n
    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    // 5. Hàm tính tổ hợp C(n, k)
    public static long combination(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        
        // Sử dụng công thức: C(n, k) = n! / (k! * (n-k)!)
        // Tối ưu để tránh tràn số
        k = Math.min(k, n - k);
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }
        return result;
    }
    
    // 6. Hàm tính chỉnh hợp A(n, k)
    public static long permutation(int n, int k) {
        if (k < 0 || k > n) return 0;
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
        }
        return result;
    }
    
    // 7. Hàm làm tròn số đến n chữ số thập phân
    public static double round(double value, int decimals) {
        if (decimals < 0) throw new IllegalArgumentException("Số chữ số thập phân phải ≥ 0");
        double scale = Math.pow(10, decimals);
        return Math.round(value * scale) / scale;
    }
    
    // 8. Hàm chuyển đổi độ C sang độ F
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9/5 + 32;
    }
    
    // 9. Hàm chuyển đổi độ F sang độ C
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    // 10. Hàm tính diện tích hình tròn
    public static double circleArea(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Bán kính phải ≥ 0");
        return Math.PI * radius * radius;
    }
    
    // 11. Hàm tính chu vi hình tròn
    public static double circleCircumference(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Bán kính phải ≥ 0");
        return 2 * Math.PI * radius;
    }
    
    // 12. Hàm giải phương trình bậc 2
    public static double[] solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            // Phương trình bậc 1
            if (b == 0) {
                return c == 0 ? new double[] {Double.POSITIVE_INFINITY} : new double[0];
            }
            return new double[] {-c / b};
        }
        
        double delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            return new double[0]; // Vô nghiệm
        } else if (delta == 0) {
            return new double[] {-b / (2 * a)}; // Nghiệm kép
        } else {
            double sqrtDelta = Math.sqrt(delta);
            return new double[] {
                (-b - sqrtDelta) / (2 * a),
                (-b + sqrtDelta) / (2 * a)
            };
        }
    }
    
    // 13. Hàm tính tổng chuỗi hình học
    public static double geometricSeries(double a, double r, int n) {
        if (r == 1) return a * n;
        return a * (1 - Math.pow(r, n)) / (1 - r);
    }
    
    // 14. Hàm kiểm tra số Palindrome (đối xứng)
    public static boolean isPalindrome(int n) {
        if (n < 0) n = -n; // Xử lý số âm
        return n == reverse(n);
    }
    
    // 15. Hàm tính logarit tự nhiên với chuỗi Taylor
    public static double lnTaylor(double x, int terms) {
        if (x <= 0) throw new IllegalArgumentException("x phải > 0");
        if (x == 1) return 0;
        
        // Chuỗi Taylor cho ln((1+y)/(1-y)) với y = (x-1)/(x+1)
        double y = (x - 1) / (x + 1);
        double result = 0;
        
        for (int n = 0; n < terms; n++) {
            int k = 2 * n + 1;
            result += Math.pow(y, k) / k;
        }
        
        return 2 * result;
    }
}