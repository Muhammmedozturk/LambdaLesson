import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice02 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println("ilkHarfBuyukDigerleriKucuk(list) = " + ilkHarfBuyukDigerleriKucuk(list));
        System.out.println();
        System.out.println("ilkHarfevece(list) = " + ilkHarfevece(list));
        System.out.println();
        basaVeSonaYildizEkle(list);
        System.out.println();
        icindeEOlanlar(list);
        System.out.println();
        leleriSil(list);
        System.out.println();
        ikinciHarfeGoreSirL(list);
    }
    //list elemanlarını ilk harf gerisi küçük şekilde listeleyelim
    public static List<String> ilkHarfBuyukDigerleriKucuk(List<String> l){
     return   l.stream().map(t-> t.substring(0,1).toUpperCase()+t.substring(1).
             toLowerCase()).collect(Collectors.toList());
    }
    //ilk harfi e ve ya c olanları listeleyelim
    public static List<String> ilkHarfevece(List<String> l){
      return  l.stream().filter(t-> t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
              collect(Collectors.toList());
    }
    ////S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basaVeSonaYildizEkle(List<String> l){
        l.stream().map(t->  "*"+t+"*").forEach(utils::yazString);
    }

    //içinde e harfi olanlardan yei bir list oluşturalım
    public static List<String> icindeEOlanlar(List<String> l){
      return   l.stream().filter(t-> t.toLowerCase().contains("e")).collect(Collectors.toList());
    }
    //S5: tum 'l' leri silelim yazdiralim
    public static void leleriSil(List<String> l){
        l.stream().map(t->t.replaceAll("l","")).forEach(utils::yazString);
    }
    //S6: List elemanarını 2.harfe gore sıralayıp
//ilk 5 elemandan char sayısı en buyuk elemanı print
    public static void ikinciHarfeGoreSirL(List<String> l){
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(1))).//list elemanlarını 2. harfe göre sıraladım
                limit(5).//sıralamadan ilk 5 elemanı aldım
                sorted(Comparator.comparing(String::length).//akıştan gelen 5 elemanı uzunluklarına göre ters sıraladık
                reversed()).
                findFirst());//akıştan gelen ilk elemanı aldık
    }

}
