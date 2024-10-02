# Algoritmo de Ordenamiento por Inserción

## 1. **Algoritmo de Inserción**
El **algoritmo de ordenamiento por inserción** es un método sencillo y eficaz para ordenar pequeñas colecciones de datos. Funciona construyendo de manera progresiva una lista ordenada, elemento por elemento, tomando el siguiente valor no ordenado y ubicándolo en su posición correcta dentro de la parte ya ordenada del arreglo.

### Pasos del algoritmo:
1. Se asume que el primer elemento de la lista ya está ordenado.
2. Para cada nuevo elemento no ordenado, se compara con los elementos de la parte ya ordenada del arreglo, comenzando por el final.
3. Se desplazan los elementos más grandes hacia la derecha, hasta que se encuentre la posición correcta para el nuevo elemento.
4. Se inserta el nuevo elemento en su posición correspondiente.
5. El proceso se repite hasta que todos los elementos estén ordenados.

### Ejemplo de funcionamiento:
Considerando el arreglo `[3, 5, 1, 2, 4]`, el algoritmo de inserción procede de la siguiente manera:
- Primera iteración: `[3, 5]` (El 5 está en su lugar correcto)
- Segunda iteración: `[1, 3, 5]` (Se inserta el 1 antes del 3)
- Tercera iteración: `[1, 2, 3, 5]` (Se inserta el 2 en su lugar correcto)
- Cuarta iteración: `[1, 2, 3, 4, 5]` (Se inserta el 4 entre el 3 y el 5)

### Ventajas y Desventajas:
- **Ventajas**:
  - Es eficiente para listas pequeñas.
  - Es un algoritmo **en línea**, lo que significa que puede ordenar a medida que recibe los elementos.
  - Es **estable**, lo que significa que no cambia el orden de elementos iguales.
- **Desventajas**:
  - Su complejidad temporal es **O(n²)** en el peor de los casos, lo que lo hace ineficiente para grandes volúmenes de datos.

### Aplicaciones del Ordenamiento por Inserción:
El ordenamiento por inserción se utiliza comúnmente en:
- **Pequeñas colecciones** de datos donde el algoritmo es lo suficientemente rápido.
- Situaciones donde el arreglo ya está parcialmente ordenado, ya que en estos casos su eficiencia es mayor.
- Es utilizado en la implementación de algoritmos más avanzados como el ordenamiento por mezcla (merge sort) o el ordenamiento rápido (quick sort), cuando los subarreglos son suficientemente pequeños.

---

## 2. **Explicación del Código**

Este código en Java implementa el algoritmo de ordenamiento por inserción y lo acompaña de una funcionalidad de registro (logs) para mostrar los pasos que sigue el algoritmo durante la ordenación. A continuación se explican las partes clave del código:

### Clase `App`
```java
public class App {
    public static void main(String[] args) throws Exception {
        MetodoOrdenamiento ordenar = new MetodoOrdenamiento();
        int[] arreglo = { 3, 5, 1, 2, 4 };
        int[] arregloOrdenado = ordenar.sortInsertion(arreglo, true);
        ordenar.printArray(arregloOrdenado);
    }
}
```
- **Propósito**: Este es el punto de entrada principal del programa.
- **Funcionamiento**:
  - Se crea una instancia de la clase `MetodoOrdenamiento`.
  - Se define un arreglo de enteros desordenados.
  - Se llama al método `sortInsertion` para ordenar el arreglo y se indica que se desea ver el registro de los pasos (`logs = true`).
  - Finalmente, se imprime el arreglo ordenado utilizando el método `printArray`.

### Clase `MetodoOrdenamiento`
```java
public class MetodoOrdenamiento {
    public int[] sortInsertion(int[] arreglo, boolean logs) {
        if (logs) {
            System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        }
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            if (logs) {
                System.out.println("Pasada número " + i);
            }
            int actual = arreglo[i];
            int j = i - 1;
            if (logs) {
                System.out.println("\ti=" + i + " j=" + j + " [i]=" + arreglo[i] + " [j]=" + arreglo[j]);
            }
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
            arreglo[j + 1] = actual;
            if (logs) {
                System.out.println("\t--------" + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    public void printArray(int[] arreglo) {
        System.out.println("\nResultado");
        System.out.println(Arrays.toString(arreglo));
    }
}
```
- **Método `sortInsertion`**:
  - **Parámetros**:
    - `int[] arreglo`: El arreglo que será ordenado.
    - `boolean logs`: Un indicador de si se deben mostrar los pasos del algoritmo.
  - **Proceso**:
    - Se inicia el recorrido del arreglo desde el segundo elemento.
    - Se selecciona un elemento (`actual`) y se compara con los elementos anteriores.
    - Los elementos mayores que `actual` se desplazan a la derecha y, finalmente, se inserta `actual` en su posición correcta.
    - Si `logs` es verdadero, se muestran los pasos intermedios en la consola para ayudar a entender el proceso de ordenamiento.

- **Método `printArray`**:
  - Este método imprime el arreglo ordenado en la consola.

### Ejemplo de salida:
```bash
Arreglo original: [3, 5, 1, 2, 4]
Pasada número 1
    i=1 j=0 [i]=5 [j]=3
    --------[3, 5, 1, 2, 4]
Pasada número 2
    i=2 j=1 [i]=1 [j]=5
        Comparamos 1 con 5
        --------[3, 5, 5, 2, 4]
        Comparamos 1 con 3
        --------[3, 3, 5, 2, 4]
    --------[1, 3, 5, 2, 4]
Pasada número 3
    i=3 j=2 [i]=2 [j]=5
        Comparamos 2 con 5
        --------[1, 3, 5, 5, 4]
        Comparamos 2 con 3
        --------[1, 3, 3, 5, 4]
    --------[1, 2, 3, 5, 4]
Pasada número 4
    i=4 j=3 [i]=4 [j]=5
        Comparamos 4 con 5
        --------[1, 2, 3, 5, 5]
    --------[1, 2, 3, 4, 5]

Resultado
[1, 2, 3, 4, 5]
```
Este ejemplo muestra cómo se realiza cada iteración del algoritmo y cómo el arreglo va tomando su forma ordenada.


## Contribute

To contribute to this project, please create a fork and send a pull request, or simply open an issue with your comments and suggestions.

## Authors

- [PABLO TORRES] - Initial development