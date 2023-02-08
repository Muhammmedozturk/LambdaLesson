import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
     Pojo(Plain Old Java Object) Class nedir
1)Variable ları private olan (Encapsulation yapılmış olan)
2)Bir parametresiz birde parametreli Constructor olan
3)Getter ve Setter methodlar olan
4)toString() methodu olan
 Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
     */
    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */
    public static void main(String[] args) {
        Universite u01=new Universite("Aksaray","Matematik",571,93);
        Universite u02=new Universite("Boğaziçi","Edebiyat",600,81);
        Universite u03=new Universite("Marmara","Hukuk",841,76);
        Universite u04=new Universite("Dumlupınar","Sosyal Bilgiler",1080,77);
        Universite u05=new Universite("Odtü","Gemi Müh.",333,74);

        List<Universite> unv=new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matematikHerhangi(unv));
        System.out.println();
        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println();
        System.out.println(matBolumSayisi(unv));
        System.out.println();
        System.out.println(ogrsayisi550BykMaxNotOrt(unv));
        System.out.println();
        System.out.println(ogrsayisi550BykMinNotOrt(unv));

    }
    //bütün üniversitelerin not ortalamalarının 74' den büyük olanları kontrol eden kodu yazınız
    public static boolean notOrt74BykUnv(List<Universite> unv){
        return  unv.stream().
                allMatch(t-> t.getNotOrt()>70);//
    }
    //üniversitelerde herhangi birinde matematik olup olmadığını kontrol eden kodu yazınız
    public static boolean matematikHerhangi(List<Universite> unv){
       return unv.stream().anyMatch(t-> t.getBolum().contains("Matematik"));
    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                // universiteler öğrenci sayısına göre terden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv){
        return (int) unv.
                stream(). //akış sağladım
                        filter(t->t.getBolum().contains("mat")). // matematik bölümü olan ünv. seçtim
                        count(); // seçilen unv. sayısını aldım
    }
    //ogr sayıları 550 den fazla olan universitelerin en büyük not ort bulunuz
public static OptionalInt ogrsayisi550BykMaxNotOrt(List<Universite> unv){
       return unv.stream().filter(t->t.getOgrSayisi()>550).mapToInt(t->t.getNotOrt()).max();
}
//öğrenci sayıları 1050 den az olan universitelerin en küçük not ort bulunuz
public static OptionalInt ogrsayisi550BykMinNotOrt(List<Universite> unv){
        return unv.stream().filter(t->t.getOgrSayisi()<1050).mapToInt(t->t.getNotOrt()).min();
}
}
