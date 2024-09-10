import java.util.Scanner;

class FibSqrtPlusOneCalculator {
    private int N;

    public FibSqrtPlusOneCalculator(int N) {
        this.N = N;
    }

    private boolean isSqrt(long number) {
        long sqrtRoot = Math.round(Math.sqrt(number));
        return sqrtRoot * sqrtRoot == number;
    }

    public long[] getFibNumbers() {
        long[] fibNumbers = new long[N];
        if (N > 0) fibNumbers[0] = 1;
        if (N > 1) fibNumbers[1] = 1;
        for (int i = 2; i < N; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }
        return fibNumbers;
    }

    public long[] getFibSqrt() {
        long[] fibNumbers = getFibNumbers();
        long[] sqrt = new long[N];
        int sqrtCount = 0;
        for (long num : fibNumbers) {
            if (isSqrt(num-1)) {
                sqrt[sqrtCount++] = num;
            }
        }

        long[] result = new long[sqrtCount];
        System.arraycopy(sqrt, 0, result, 0, sqrtCount);
        return result;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input count number Fibonacci (N): ");
        int N = scanner.nextInt();
        scanner.close();

        FibSqrtPlusOneCalculator calculate = new FibSqrtPlusOneCalculator(N);

        long[] fibNumbers = calculate.getFibNumbers();
        System.out.println("First " + N + " number Fibonacci:");
        for(long num : fibNumbers){
            System.out.println(num);
        }

        long[] sqrts = calculate.getFibSqrt();
        System.out.println("\nNumber fibonacci while is sqrt + 1:");
        for(long sqrt : sqrts){
            System.out.println(sqrt);
        }
    }
}
