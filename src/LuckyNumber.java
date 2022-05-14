import java.util.Scanner;
public class LuckyNumber {
    //Tạo hằng số
    public static final int MAXIMUM = 100;
    //Hàm so sánh và đếm
    public static int checkAndCount(int lucky) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn đoán? ");
        int number = sc.nextInt();
        int i = 1;
        while (lucky != number) {
            if (lucky > number) {
                System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
                System.out.print("Bạn đoán? ");
                number = sc.nextInt();
                ++i;
            } else {
                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                System.out.print("Bạn đoán? ");
                number = sc.nextInt();
                ++i;
            }
        }
        System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + i + " lần dự đoán!");
        return i;
    }
    //Hàm tạo 1 số ngẫu nhiên
    public static int randomNumber() {
        double x = Math.random() * MAXIMUM;
        return (int) x;
    }
    //Hàm chính
    public static void main(String[] args) {
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến " + MAXIMUM + "...");
        Boolean empty = true;
        String word = "";
        Scanner sc = new Scanner(System.in);
        int total_games = 0;
        int total_guess = 0;
        int best_game = 0;
        //Tạo vòng lặp trò chơi
        do {
            int x = checkAndCount(randomNumber());
            total_guess += x;
            total_games++;
            if (best_game == 0) {
                best_game = x;
            };
            if (best_game > x) {
                best_game = x;
            };
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            word = sc.nextLine();
            if (word.equals("y") ||word.equals("Y")||word.equals("yes")||word.equals("YES")||word.equals("Yes")) {
                empty = true;
            } else {
                empty = false;
            }
            ;
        }
        while (empty);
        double guess_avg_db =  (double) total_guess / total_games;
        double guess_avg = (double) Math.round(guess_avg_db * 10) / 10;
        //In ra kết quả trò chơi
        System.out.println("Kết quả tổng quát của trò chơi: ");
        System.out.println("Tổng số lần chơi    = " + total_games);
        System.out.println("Tổng số lần dự đoán = " + total_guess);
        System.out.println("Số lần dự đoán trung bình mỗi lượt = " + guess_avg);
        System.out.println("Số lần dự đoán ít nhất     = " + best_game);
    }
}
