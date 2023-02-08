import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ssg01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5,5, 6, 9, 15, 8));
for (Integer w:list){
    System.out.print(w+" ");
}
        System.out.println();
hepsiniYazdir(list);
        System.out.println();
negatifleriYazdır(list);
        System.out.println();
        System.out.println(kareListe(list));
        System.out.println();
        System.out.println(birlerBasamagiBesOLanlar(list));
        System.out.println();
        System.out.println(toplam(list));
    }
//listi aralarında boşluk bırakarak yazdırınız
    public static void hepsiniYazdir(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t+" "));

    }
    //negatifleri yzdırınız
    public static void negatifleriYazdır(List<Integer> list){
        list.stream().filter(t-> t<0).forEach(t-> System.out.print(t+" "));
    }
    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> kareListe(List<Integer> list){
        return list.stream().map(t-> t*t).collect(Collectors.toList());
    }
    //S6: listin elemanlarini kucukten buyuge tekrarsız siralayalim
    public static void sirala(List<Integer>list){
        list.stream().sorted().distinct().forEach(Utils2::printSameLine);
    }
    //S6: listin elemanlarini kucukten buyuge tekrarsız siralayalim
    public static void tersSırala(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.println(t+" "));
    }
    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> birlerBasamagiBesOLanlar(List<Integer>list){
       return list.stream().filter(t-> t>0).map(t-> t*t*t).filter(t-> t%10==5).collect(Collectors.toList());
    }
    // S10 :list elemanlarini toplamini bulalim
    public static int toplam(List<Integer>list){
        return list.stream().reduce(0,(a,b)-> a+b);
    }
}
