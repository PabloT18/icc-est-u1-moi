import java.util.Arrays;

/**
 * Class that implements the insertion sort algorithm.
 * Developed by Pablo Torres.
 */
public class MetodoOrdenamiento {

    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param arreglo the array to be sorted
     * @param logs    if true, logs the sorting process to the console
     * @return the sorted array
     */
    public int[] sortInsertion(int[] arreglo, boolean logs) {
        if (logs) {
            System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        }
        // Longitud del arreglo
        int n = arreglo.length;

        // Comenzar desde el segundo elemento (el primer elemento ya está "ordenado")
        for (int i = 1; i < n; i++) {
            if (logs) {
                System.out.println("Pasada número " + i);
            }

            // Elemento actual que se va a insertar en la parte ordenada del arreglo
            int actual = arreglo[i];

            // Inicializar j para escanear la parte ordenada en busca de la posición
            // correcta de actual
            int j = i - 1;

            if (logs) {
                System.out.println("\ti=" + i + " j=" + j + " [i]=" + arreglo[i] + " [j]=" + arreglo[j]);
            }

            // Mover elementos de la parte ordenada que son mayores que el elemento actual a
            // una posición adelante
            // de su posición actual
            while (j >= 0 && arreglo[j] > actual) {
                if (logs) {
                    System.out.println("\t\tComparamos " + actual + " con " + arreglo[j]);
                }

                arreglo[j + 1] = arreglo[j];
                j--;

                if (logs) {
                    System.out.println("\t\t--------" + Arrays.toString(arreglo));
                }
            }

            // Insertar el elemento actual en su posición correcta
            arreglo[j + 1] = actual;

            if (logs) {
                System.out.println("\t--------" + Arrays.toString(arreglo));
            }
        }

        return arreglo;
    }

    /**
     * Prints the elements of the array to the console.
     *
     * @param arreglo the array to be printed
     */
    public void printArray(int[] arreglo) {
        System.out.println("\nResultado");
        System.out.println(Arrays.toString(arreglo));
    }
}
