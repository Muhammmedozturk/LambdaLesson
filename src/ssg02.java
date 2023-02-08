import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ssg02 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");
        for (String w:list){
            System.out.print(w+" ");
        }
        System.out.println();
       listele(list);
        System.out.println(harfeGoreListele(list));
        System.out.println();
        yildizEkle(list);
        System.out.println(alfabetikSirala(list));
        System.out.println();
  leleriSil(list);
        System.out.println();
        System.out.println(eolanlariListele(list));
    }
    public static void listele(List<String>list){
        list.stream().forEach(Utils2::printSameLine);
    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static List<String> harfeGoreListele(List<String>list){
        return list.stream().filter(t-> t.startsWith("D") || t.startsWith("C")).collect(Collectors.toList());
    }
    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildizEkle (List<String>list){
        list.stream().map(t-> "*"+t+"*").forEach(t-> System.out.println(t+" "));
    }
    //elemanları alfabetik olarak sıralayalım
    public static List<String> alfabetikSirala(List<String>list){
        return list.stream().sorted().collect(Collectors.toList());
    }
    //S4: tum ‘l’ leri silelim yazdiralim
    public static void leleriSil (List<String>list){
        list.stream().map(t-> t.replaceAll("l","")).forEach(Utils2::printSameLine);
    }
    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eolanlariListele(List<String>list){
        return list.stream().filter(t-> t.toLowerCase().contains("e")).collect(Collectors.toList());
    }

}
