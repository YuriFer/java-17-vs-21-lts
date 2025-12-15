import java.util.ArrayList;
import java.util.List;

public class SequencedCollections {

    // SequencedCollection, SequencedSet e SequencedMap são novas interfaces introduzidas no Java 21
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(){
            {
                add("Banana");
                add("Uva");
                add("Laranja");
            }
        };

        // Antes - Java 17
        String lastElementBefore = arrayList.get( arrayList.size() - 1 );
        // Depois - Java 21
        String lastElementAfter = arrayList.getLast();
        List<String> reversedList = arrayList.reversed();

        System.out.println("Último elemento java 17: " + lastElementBefore);
        System.out.println("Último elemento java 21: " + lastElementAfter);

        System.out.println(reversedList);
        
        /* Principais operações adicionadas: 
            getFirst(), 
            getLast(), 
            reversed(), 
            addFirst(E element), 
            addLast(E element),
            removeFirst(),
            removeLast() 
        */
    }    
}