import java.util.Scanner;

public class Rec {
    public static void from_a_to_b(int a, int b){ //упражнение 3
        if (a == b) { //условие выхода из рекурсии
            System.out.println(b);
            return;
        }
        else
        {
            if (a > b) { //вывод в порядке убывания
                System.out.println(a);
                from_a_to_b(a - 1, b);
            }
            else { //вывод в порядке возрастания
                from_a_to_b(a, b - 1);
                System.out.println(b);
            }
        }
    }

    public static int sum_of_k(int length, int sum, int k, int s){ //упражнение 4
        if (length == k) //если длина совпала с нужным количеством знаков
            if (sum == s) //если сумма совпала с нужной
                return 1;
            else
                return 0;
        int c;
        if (length == 0) //фиксируем первую цифру числа (не может начинаться с нуля)
            c = 1;
        else
            c = 0;
        int res = 0; //количество чисел
        for (int i = c; i < 10; i++) //перебираем числа от 1-значных до k-значных
            res += sum_of_k(length + 1, sum + i, k, s);
        return res;
    }

    public static int sum(int n, int s){ //упражнение 5
        if (n == 0) //условие выхода из рекурсии
            return s;
        else
            return sum(n / 10, s + n % 10); //увеличиваем сумму на младший разряд числа, а само число уменьшаем на этот разряд
    }

    public static void main(String[] args) {
        //упражнение 3
        Scanner in = new Scanner(System.in);
        System.out.println("Exercise 3");
        System.out.println("Input a and b: ");
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        if (a1 < b1)
            System.out.println("In ascending order:");
        else
            System.out.println("In descending order:");
        from_a_to_b(a1, b1); //в порядке возрастания

        //упражнение 4
        System.out.println("Exercise 4");
        System.out.println("Input k and s: ");
        int k1 = in.nextInt(); //количество знаков в числе
        int s1 = in.nextInt(); //сумма цифр
        System.out.println("There are " + sum_of_k(0,0, k1, s1) + " " + k1 +"-digit numbers with the sum = " + s1); //примечание: аргумент s не может превышать значения 9 * k

        //упражнение 5
        System.out.println("Exercise 5");
        System.out.println("Input n:");
        int num = in.nextInt(); //число для подсчета суммы цифр
        System.out.println("Sum digits of n = " + num + " is " + sum(Math.abs(num), 0));
    }
}
