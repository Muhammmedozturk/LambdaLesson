import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilimi", "guvec", "kokorec", "kusleme",
                "arapAsı", "waffle", "kunefex","guvec"));
        alfBykTekrsz(menu);
        System.out.println();
        karakterSayisiTersSirali(menu);
        System.out.println();
        karakterSayisiKucuktenBuyuge(menu);
        System.out.println();
        harfSayisi7denazkontrol(menu);
        System.out.println();
        wileBaslayanKontrol(menu);
        System.out.println();
        xileBiten(menu);
        System.out.println();
        karakterSayisiEnBuyuk(menu);
        System.out.println();
        ilkElemanHaricSonHarfSiraliPrint(menu);

    }
//list elemanlarını alfabetik büyük harf ve tekrarsız print ediniz
    public static void alfBykTekrsz(List<String> yemek){
        yemek.stream().//akış başladı
                map(String::toUpperCase).//buyuk harf
                sorted().//doğal sıralama
                distinct().//elemanların tekrarsız olmasını sağladı
                forEach(t-> System.out.print(t+" "));
    }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karakterSayisiTersSirali(List<String> yemek){
        yemek.stream().
                map(String::length).//akışı kelime uzunluğu olarak güncelledim
                sorted(Comparator.reverseOrder()).//kelime uzunluğunu ters sıralı yaptım
                distinct().//tekrarsız olanları al
                forEach(t-> System.out.print(t+" "));
    }
    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..
    public static void karakterSayisiKucuktenBuyuge(List<String> yemek){
        yemek.stream().
                sorted(Comparator.comparing(String::length)).//string ifadeleri karakter sayısına göre sıralar
                forEach(Lambda01::yazdirString);
    }
    // ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin hepsini karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denazkontrol(List<String> yemek){
        System.out.println(yemek.stream().allMatch(t-> t.length()<=7) ? "list elemanları 7 ve daha az harften oluşur" :
                "list elemanları 7 harften büyük");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wileBaslayanKontrol(List<String> yemek){
        System.out.println(yemek.stream().noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                " w ile yemek icad ettik");
    }
    //Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xileBiten(List<String> yemek){
        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten var" : "x ile biten yemek ismi yok");
    }
    //karakter sayısı en buyuk elemanı yzdırınız
    public static void karakterSayisiEnBuyuk(List<String> yemek) {
        Stream<String> sonisim = yemek.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).//karakter sayısına göre tersten sıralandı
                limit(1);//limit metodu kullanılarak sadece ilk eleman çağrıldı
        //limit():metodunun ddönen değeri Stream<String> yapıdadır

        System.out.println(Arrays.toString(sonisim.toArray()));
        //sonisim.toArray()--> stream olan akış arraya çevrildi
        //Arrays.toString(sonisim.toArray())--> arrayı string yapıya çeviriyor
    }
    //task :List elemanlarını son harfine göre sıralayıp ilk eleman hariç kalan elemanları print ediniz
    public static void ilkElemanHaricSonHarfSiraliPrint(List<String> yemek){
        yemek.stream().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).//son harfine göre alfabetik sıralandı
                skip(1).//akıştaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdirString);//yazdır metodu kullanıldı
    }

}
