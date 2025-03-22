import java.util.*;

/**
 * eine Klasse ListTester mit folgenden Methoden.
 * Alle Methoden übernehmen zumindest eine List<Integer>
 * als Parameter (da List ein Interface ist, verwenden diese Methoden daher alle Vererbungspolymorphie)
 * @author danielofosuhene
 * @versions 2025-22-03
 */
public class ListTester {
    private static Random rand = new Random();

    // fugt zufallsl zahl am ende
    public static void  addEnd(List<Integer> list, int anzahl) {
        if(anzahl < 0) return;
        for(int i = 0;i < anzahl; i++) {
            list.add(rand.nextInt(0,100));
        }
    }

    // zufallszahl zur ersten stelle
    public static void addFirst(List<Integer> list, int anzahl) {
        if(anzahl < 0) return;
        for(int i = 0;i < anzahl; i++) {
            list.add(0,rand.nextInt(0,100));
        }
    }

    // löscht hälte aller elemente in der liste
    public static void deleteHalf(List<Integer> list) {
        if(list.isEmpty()) return;
        ListIterator<Integer> lit = list.listIterator();
        boolean remove = false;
        while(lit.hasNext()) {
            lit.next();
            if(remove) {
                lit.remove();
            }
            remove = !remove;
        }
    }
    //summe aller elemente berechen mit ite
    public static int summeIterator(List<Integer> list) {
        if(list.isEmpty()) return -1;
        ListIterator<Integer> lit = list.listIterator();
        int summe = 0;
        while(lit.hasNext()) {
            summe += lit.next();
        }
        return summe;
    }
    //summe aller elemente berechen mitindex
    public static int summeIndex(List<Integer> list) {
        if(list.isEmpty()) return -1;
        int summe = 0;
        for(int i = 0; i < list.size();i++){
            if(list.get(i)!= null ) {
                summe += list.get(i);
            }

        }
        return summe;
    }

    //elemente in string zusammen mit ite
    public static String listeIterator(List<Integer> list) {
        if(list.isEmpty()) return "";
        ListIterator<Integer> lit = list.listIterator();
        String liste = " ";
        while(lit.hasNext()) {
            liste += lit.next() + ",";
        }
        return liste;
    }
    //elemente in string zusammen mit index
    public static String listeIndex(List<Integer> list) {
        if(list.isEmpty()) return "";
        String liste = " ";
        for(int i = 0; i < list.size();i++) {
            liste += list.get(i) + ",";
        }
        return liste;
    }

    public static void main(String[] args) {
        List<Integer> linked = new LinkedList<>();
        List<Integer> array = new ArrayList<>();
        int anzahl = 100000;
        long start, ende;

        System.out.println("Testlauf Daniel Ofosuhene - Anzahl der Elemente: " + anzahl);

        System.out.println("Füllen für die Listen (Anfügen am Ende)");
        start = System.currentTimeMillis();
        addEnd(linked, anzahl);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms): " + (ende-start));
        start = System.currentTimeMillis();
        addEnd(array, anzahl);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms): " + (ende-start));
        System.out.println("");

        //löschen

        System.out.println("Löschen der Hälfte der Elemente");
        start = System.currentTimeMillis();
        deleteHalf(linked);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms): " + (ende-start));
        start = System.currentTimeMillis();
        deleteHalf(array);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms): " + (ende-start));
        System.out.println("");
        //füllen

        System.out.println("Füllen für die Listen (Anfügen am Beginn)");
        start = System.currentTimeMillis();
        addFirst(linked, anzahl);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms): " + (ende-start));
        start = System.currentTimeMillis();
        addFirst(array, anzahl);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms): " + (ende-start));
        System.out.println("");

        //summieren

        System.out.println("Aufsummieren mit Hilfe des Index");
        int summe = 0;
        start = System.currentTimeMillis();
        summe = summeIndex(linked);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms, Summe = " + summe +"): " + (ende-start));
        start = System.currentTimeMillis();
        summe = summeIndex(array);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms, Summe = " + summe +"): " + (ende-start));
        System.out.println("");

        System.out.println("Aufsummieren mit Hilfe des Iterators");
        start = System.currentTimeMillis();
        summe = summeIterator(linked);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms, Summe = " + summe +"): " + (ende-start));
        start = System.currentTimeMillis();
        summe = summeIterator(array);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms, Summe = " + summe +"): " + (ende-start));
        System.out.println("");

        System.out.println("Auflisten mit Hilfe des Index");
        String liste = "";
        start = System.currentTimeMillis();
        liste = listeIndex(linked);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms): " + (ende-start));
        start = System.currentTimeMillis();
        liste = listeIndex(array);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms): " + (ende-start));
        System.out.println("");

        System.out.println("Auflisten mit Hilfe des Iterators");
        start = System.currentTimeMillis();
        liste = listeIterator(linked);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die LinkedList (ms): " + (ende-start));
        start = System.currentTimeMillis();
        liste = listeIterator(array);
        ende = System.currentTimeMillis();
        System.out.println("Zeit für die ArrayList (ms): " + (ende-start));
        System.out.println("");



    }
}
