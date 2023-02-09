package tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        hepsiniYazdir(list);
        System.out.println();
        negatifYaz(list);
        System.out.println();
        ciftYaz(list);
        System.out.println();
        pozVeCift(list);
        System.out.println();
        pozVeyaCift(list);
        System.out.println();
        karelerini(list);
        System.out.println();
        ciftlerinKupleri(list);
        System.out.println();
        kareTekrarsiz(list);
        System.out.println();
        kucuktenBuyuge(list);
        System.out.println();
        tersSirala(list);
        System.out.println();
        System.out.println(pozKup5List(list));
        System.out.println();
        System.out.println(pozKareSon5Degil(list));
        System.out.println();
        System.out.println(elToplam(list));
        System.out.println();
        System.out.println(elToplam1(list));
        System.out.println();
        System.out.println(elToplam2(list));
        System.out.println();

        pozToplam(list);

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
// Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir
// (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    //listi yazdır
    public static void hepsiniYazdir(List<Integer> l) {
        l.stream().forEach(t -> System.out.print(t + " "));
    }

    //listte negatif olanları yazdır
    public static void negatifYaz(List<Integer> l) {
        l.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));
    }

    //cift olanları yazdırınız
    public static void ciftYaz(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));

    }

    //pozitif ve çift olanları yazdırınız
    public static void pozVeCift(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));
    }

    //pozitif veya çift olanları yazdırınız
    public static void pozVeyaCift(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0 || t > 0).forEach(t -> System.out.print(t + " "));
    }

    //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
//ıslem yapmak ıcın (update) kullanılır
    /// S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    public static void karelerini(List<Integer> l) {
        l.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));
    }

    ////S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void ciftlerinKupleri(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım
    public static void kareTekrarsiz(List<Integer> l) {//distict gelen akışı benzersiz hale getiriyor yani iki adet 5 varsa birini yazdır
        l.stream().map(t -> t * t).distinct().forEach(t -> System.out.print(t + " "));
    }

    ////S9: listin elemanlarini kucukten buyuge siralayalim
    public static void kucuktenBuyuge(List<Integer> l) {
        l.stream().sorted().forEach(t -> System.out.print(t + " "));
    }

    //s10:listi büyükten küçüğe sıralayınız
    public static void tersSirala(List<Integer> l) {
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }

    //listin pozitif elemanları için küplerini bulup birler basamağı 5 olanlardan yeni bir list oluşturalım
    public static List<Integer> pozKup5List(List<Integer> l) {
        return l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
    }

    ////S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKareSon5Degil(List<Integer> l) {
        List<Integer> list = l.stream().filter(t -> t > 0).map(t -> t * t).filter(t -> t % 10 != 5).collect(Collectors.toList());
        return list;
    }
    //s13:List elemanlarının toplamını bulma
    /*
reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

*/

    public static int elToplam(List<Integer> l) {
        int i = l.stream().reduce(0, (x, y) -> x + y);
        return i;
    }//2. yol

    public static int elToplam1(List<Integer> l) {
        int i = l.stream().reduce(0, Math::addExact);
        return i;
    }

    public static int elToplam2(List<Integer> l) {
        int i = l.stream().reduce(0, Integer::sum);
        return i;
    }

    //listin pozitif eleman toplamını bulalım
    public static void pozToplam(List<Integer> l) {
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Math::addExact));
    }
}