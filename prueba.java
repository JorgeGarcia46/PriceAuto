import java.util.LinkedList;

public class prueba {

    

    public static void main(String[] args) {
        LinkedList<Coches> inventario = new LinkedList<>();
        Coches coche1 = new Coches(123, "Nissan", "altima", 125000,2013,2);
        Coches coche2 = new Coches(111, "Nissan", "Ultimate", 125000,2013,2);
        Coches coche3 = new Coches(1, "Dodge", "Challenger", 125000,2013,2);

        inventario.add(coche1);
        inventario.add(coche2);
        inventario.add(coche3);

        for (Coches coches : inventario) {
            System.out.println(coches.getClave());
        }
        
        quicksort(inventario, 0, inventario.size()-1);

        for (Coches coches : inventario) {
            System.out.println(coches.getClave());
        }
    }

    public static <E extends Comparable<E>> void mergeSort(LinkedList<E> lista) {
        if (lista.size() > 1) {
            int mitad = lista.size() / 2;
            LinkedList<E> izquierda = new LinkedList<>(lista.subList(0, mitad));
            LinkedList<E> derecha = new LinkedList<>(lista.subList(mitad, lista.size()));
            
            mergeSort(izquierda);
            mergeSort(derecha);
            
            merge(izquierda, derecha, lista);
        }
    }

    private static <E extends Comparable<E>> void merge(LinkedList<E> izquierda, LinkedList<E> derecha, LinkedList<E> mezclado) {
        int i = 0, j = 0, k = 0;
        
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).compareTo(derecha.get(j)) < 0) {
                mezclado.set(k++, izquierda.get(i++));
            } else {
                mezclado.set(k++, derecha.get(j++));
            }
        }
        
        while (i < izquierda.size()) {
            mezclado.set(k++, izquierda.get(i++));
        }
        
        while (j < derecha.size()) {
            mezclado.set(k++, derecha.get(j++));
        }
    }

    private static <E extends Comparable<E>> void quicksort(LinkedList<Coches> a, int primero, int ultimo){
        int central = (primero + ultimo) / 2;
        Coches pivote = a.get(central);
        int i = primero;
        int j = ultimo;
        do {
            while (a.get(i).compareTo(pivote) < 0)
                i++;
            while (a.get(j).compareTo(pivote) > 0)
                j--;
            if (i <= j) {
                Coches aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j)
            quicksort(a, primero, j); // mismo proceso con sublista izquierda
        if (i < ultimo)
            quicksort(a, i, ultimo); // mismo proceso con sublista derecha
    }


    

}
