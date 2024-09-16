import java.util.Scanner;

        /**
         * Клас, що представляє число Фібоначчі.
         * Зберігає його індекс та значення числа у послідовності.
         * Надає методи для перевірки, чи можна число подати у виразі (w^2 + 1).
         */
class FibonacciNumber {
    private int index;  // Індекс числа Фібоначчі
    private long value;  // Значення числа Фібоначчі


        /**
         * Конструктор для створення об'єкта, що представляє
         *число Фібоначчі з його індексом та значенням.
         * @param index Індекс числа Фібоначі у послідовності (починаючи з 0)
         * @param value Значення числа Фібоначчі
         */
    public FibonacciNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }


            /**
             *  Повертає значення числа Фібоначчі.
             * @return Значення числа Фібоначі
             */
    public long getValue() {
        return value;
    }


            /**
             * Повертає індекс числа Фібоначчі.
             * @return Індекс числа Фібоначчі (починаючи з 0)
             */
    public int getIndex() {
        return index;
    }

            /**
             * Перевіряє, чи є число Фібоначчі квадратом плюс 1 (w^2 + 1).
             *
             * Число є квадратом плюс один, якщо існує ціле число, яке можна піднести до квадрата додати 1 і воно буде дорівнювати цьому числу.
             * Наприклад, є число 17, його можна подати у вигляді 4^2 + 1 = 17.
             *
             * @return true, якщо число є квадратом плюс 1; false, якщо не є
             */
    public boolean isSqrtPlusOne() {
        long SqrtRoot = Math.round(Math.sqrt(value - 1));
        return SqrtRoot * SqrtRoot + 1 == value;
    }


            /**
             *  Повертає рядкове представлення числа Фібоначчі.
             *
             * Рядкове представлення включає індекс та значення числа Фібоначчі.
             * Формат рядка: "Індекс: [index], Значення: [value]"
             *
             * @return Рядкове представлення числа Фібоначчі з його індексом
             */
    @Override
    public String toString() {
        return "Індекс: " + index + ", Значення: " + value;
    }
}


        /**
         *  Клас для обчислення чисел Фібоначчі до вказаної кількості та перевірки, чи є вони квадратом плюс 1.
         *  Включає методи для генерації чисел Фібоначчі та виведення тих, чкі можна подати у вигляді (w^2+1)
         */
class FibonacciSqrtPlusOneCalculator {

    private int N;  // Кількість чисел Фібоначчі

         /**
          *  Конструктор, який встановлює кількість чисел Фібоначчі для обчислення.
          *
          * @param N Кількість чисел Фібоначчі для обчислення
          * @throws IllegalArgumentException Якщо N менше ніж 1
          */
    public FibonacciSqrtPlusOneCalculator(int N) {
        if(N < 1){
            throw new IllegalArgumentException("Кількість чисел Фібоначчі повинна бути більше або дорівнювати 1");
        }
        this.N = N;
    }


            /**
             *  Метод для обчислення чисел Фібоначчі та виведення тих, які є квадратами плюс 1.
             * Генерує числа Фібоначчі до N включно, перевіряє кожне число чи можна записати у вигляді (w^2+1) та виводить.
             * Також виводить індекс та значення чисел, які є квадратами плюс 1.
             */
    public void printFibonacciSqrtPlusOne() {
        long prev1 = 0;  // перше число Фібоначчі
        long prev2 = 1;  // друге число Фібоначчі

        for (int i = 0; i < N; i++) {
            FibonacciNumber fibNumber;
            if (i == 0) {
                fibNumber = new FibonacciNumber(i, prev1);  // перше число Фібоначчі
            } else if (i == 1) {
                fibNumber = new FibonacciNumber(i, prev2);  // друге число Фібоначчі
            } else {
                long current = prev1 + prev2;  // обчислюємо наступне число
                fibNumber = new FibonacciNumber(i, current);
                prev1 = prev2;  // оновлюємо попередні два числа
                prev2 = current;
            }

            // Перевіряємо, чи є число кубом
            if (fibNumber.isSqrtPlusOne()) {
                System.out.println("Число Фібоначчі, яке є квадратом плюс один: Індекс: " + fibNumber.getIndex() + ", Значення: " + fibNumber.getValue());
            }
        }
    }
}


        /**
         * Головний клас програми для запуску обчислення чисел Фібоначчі.
         * Включає метод `main`, який зчитує кількість чисел Фібоначчі (N) з консолі
         * та викликає метод для виведення чисел, які можна подати у вигляді (w^2+1).
         */
public class FibonacciSqrtPlusOneApp {

    /**
     * Основний метод програми, що запускає процес обчислення чисел Фібоначчі.
     *
     * @param args Аргументи командного рядка (не використовується)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Фібоначчі (N): ");
        int N = scanner.nextInt();

        FibonacciSqrtPlusOneCalculator calculator = new FibonacciSqrtPlusOneCalculator(N);
        // Виклик методу для виведення чисел, які можна записати у вигляді (w^2+1)
        calculator.printFibonacciSqrtPlusOne();
    }
}