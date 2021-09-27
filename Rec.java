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

     public static int num_of_digit(int x, int kol){ //упражнение 4
        if (x == 0)
            return kol;
        else
            return num_of_digit(x / 10, ++kol);
    }

    public static int sum(int n, int s){ //упражнение 4-5
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
        System.out.println("Input k and d: ");
        int k1 = in.nextInt(); //количество знаков в числе
        int d = in.nextInt(); //сумма цифр
        int s[] = new int[10]; //массив чисел
        System.out.println("Input 10 numbers: ");
        int res = 0; //количество чисел
        for (int i = 0; i < 10; i++) {
            s[i] = in.nextInt(); //заполнение массива
            if ((num_of_digit(Math.abs(s[i]), 0) == k1) && (sum(Math.abs(s[i]),0) == d)) //используем рекурсивные методы для проверки суммы цифр числа и количества знаков
                res++;
        }
        System.out.println("There are " + res + " " + k1 +"-digit numbers with the sum = " + d); //примечание: аргумент s не может превышать значения 9 * k

        //упражнение 5
        System.out.println("Exercise 5");
        System.out.println("Input n:");
        int num = in.nextInt(); //число для подсчета суммы цифр
        System.out.println("Sum digits of n = " + num + " is " + sum(Math.abs(num), 0));
    }
}
