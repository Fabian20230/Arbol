package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   1. mvn compile
 *   2. java -cp target/classes umg.edu.progra.arboles.Principal
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // Arbol base del ejemplo
        //               50
        //              /  \
        //            30    70
        //           /  \   / \
        //          20  40 60  80
        //         /
        //        10
        // -------------------------------------------------------
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();
        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();
        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();
        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());

       
        ArbolBinarioBusqueda bst = new ArbolBinarioBusqueda();
        for (int v : valores) {
            bst.insertar(v);
        }

        // PROBLEMA 1 — contarNodos recursivo
   
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 1 — contarNodos recursivo");
        System.out.println("========================================");
        System.out.println("tamanio() (campo interno):  " + bst.tamanio());
        System.out.println("contarNodos() (recursivo):  " + bst.contarNodos());
        System.out.println("¿Coinciden? " + (bst.tamanio() == bst.contarNodos()));

        bst.insertar(5);
        System.out.println("\nDespues de insertar 5:");
        System.out.println("tamanio():    " + bst.tamanio());
        System.out.println("contarNodos(): " + bst.contarNodos());
        System.out.println("¿Coinciden? " + (bst.tamanio() == bst.contarNodos()));

        bst.eliminar(5);
        System.out.println("\nDespues de eliminar 5:");
        System.out.println("tamanio():    " + bst.tamanio());
        System.out.println("contarNodos(): " + bst.contarNodos());
        System.out.println("¿Coinciden? " + (bst.tamanio() == bst.contarNodos()));

        // PROBLEMA 2 — esBalanceado
     
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 2 — esBalanceado");
        System.out.println("========================================");
        System.out.println("Arbol original (balanceado esperado):");
        bst.imprimirArbol();
        System.out.println("¿Esta balanceado? " + bst.esBalanceado());  
        ArbolBinarioBusqueda desbalanceado = new ArbolBinarioBusqueda();
        desbalanceado.insertar(1);
        desbalanceado.insertar(2);
        desbalanceado.insertar(3);
        desbalanceado.insertar(4);
        desbalanceado.insertar(5);
        System.out.println("\nArbol desbalanceado (1,2,3,4,5 en orden):");
        desbalanceado.imprimirArbol();
        System.out.println("¿Esta balanceado? " + desbalanceado.esBalanceado());  

         // PROBLEMA 3 — esBSTValido
      
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 3 — esBSTValido");
        System.out.println("========================================");
        System.out.println("Arbol generado por insertar (BST correcto):");
        System.out.println("¿Es BST valido? " + bst.esBSTValido());  

        ArbolBinarioBusqueda roto = new ArbolBinarioBusqueda();
        roto.insertar(50);
        roto.getRaiz().izquierdo = new Nodo(80); 
        roto.getRaiz().derecho   = new Nodo(30); 
        System.out.println("\nArbol 'roto' (80 a la izquierda de 50, 30 a la derecha de 50):");
        roto.imprimirArbol();
        System.out.println("¿Es BST valido? " + roto.esBSTValido()); 

        // PROBLEMA 4 — ancestroComunMasBajo (LCA)
       
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 4 — ancestroComunMasBajo (LCA)");
        System.out.println("========================================");
        System.out.println("Arbol:");
        bst.imprimirArbol();
        System.out.println("LCA(10, 40) = " + bst.ancestroComunMasBajo(10, 40) + "  (esperado: 30)");
        System.out.println("LCA(10, 80) = " + bst.ancestroComunMasBajo(10, 80) + "  (esperado: 50)");
        System.out.println("LCA(60, 80) = " + bst.ancestroComunMasBajo(60, 80) + "  (esperado: 70)");
        System.out.println("LCA(10, 10) = " + bst.ancestroComunMasBajo(10, 10) + "  (mismo nodo)");

        System.out.println("\nIntentando LCA con valor que no existe (99)...");
        try {
            bst.ancestroComunMasBajo(10, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }

        // PROBLEMA 5 — invertir (espejo)
        
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 5 — invertir (espejo)");
        System.out.println("========================================");
        System.out.println("Arbol ANTES de invertir:");
        bst.imprimirArbol();
        System.out.print("InOrden antes (ascendente): ");
        bst.inOrden();

        bst.invertir();

        System.out.println("\nArbol DESPUES de invertir:");
        bst.imprimirArbol();
        System.out.print("InOrden despues (descendente): ");
        bst.inOrden();

        System.out.println("¿Es BST valido tras invertir? " + bst.esBSTValido()
            + "  (esperado: false, porque se espejeo)");

        bst.invertir();
        System.out.print("\nInOrden tras doble inversion (debe volver al original): ");
        bst.inOrden();

         // EXTRA — kEsimoMenor
        
        System.out.println("\n========================================");
        System.out.println("EXTRA — kEsimoMenor");
        System.out.println("========================================");
        System.out.print("InOrden del arbol: ");
        bst.inOrden();
        for (int k = 1; k <= bst.tamanio(); k++) {
            System.out.println("El " + k + "er menor = " + bst.kEsimoMenor(k));
        }
        System.out.println("\nIntentando k=0 (invalido)...");
        try {
            bst.kEsimoMenor(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        }

       
        // EXTRA — imprimirRangoOrdenado
        System.out.println("\n========================================");
        System.out.println("EXTRA — imprimirRangoOrdenado");
        System.out.println("========================================");
        System.out.print("Valores en rango [20, 60]: ");
        bst.imprimirRangoOrdenado(20, 60);
        System.out.print("Valores en rango [1, 100]: ");
        bst.imprimirRangoOrdenado(1, 100);
        System.out.print("Valores en rango [35, 55]: ");
        bst.imprimirRangoOrdenado(35, 55);

        // EXTRA — diametro
        System.out.println("\n========================================");
        System.out.println("EXTRA — diametro");
        System.out.println("========================================");
        System.out.println("Arbol:");
        bst.imprimirArbol();
        System.out.println("Diametro del arbol: " + bst.diametro()
            + "  (camino mas largo en aristas entre dos nodos cualesquiera)");

        ArbolBinarioBusqueda unNodo = new ArbolBinarioBusqueda();
        unNodo.insertar(42);
        System.out.println("Diametro de un arbol con un solo nodo: " + unNodo.diametro()
            + "  (esperado: 0)");
    }
}
