import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int ARRAY_SIZE = 5;

    public static void main(String[] args) {
        int[] array = generateRandomArray();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printArray(array);

            System.out.print("Inserisci un numero (0 per uscire): ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }

            System.out.print("Inserisci la posizione (da 1 a " + ARRAY_SIZE + "): ");
            int posizione = scanner.nextInt();

            try {
                updateArray(array, numero, posizione);
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.err.println("Errore: " + e.getMessage());
            }
        }
    }

    private static int[] generateRandomArray() {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        return array;
    }

    private static void printArray(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
    }

    private static void updateArray(int[] array, int numero, int posizione) {
        if (posizione < 1 || posizione > ARRAY_SIZE) {
            throw new IllegalArgumentException("Posizione non valida");
        }

        array[posizione - 1] = numero;
    }
}