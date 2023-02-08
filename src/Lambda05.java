import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz.
        System.out.println(topla(5));
        System.out.println(toplam(5));
        System.out.println(ciftleriTopla(6));
        System.out.println(xciftleriTopla(5));
        System.out.println(xtekleriTopla(5));
        ikininxKuvvetiniYazdir(5);
        System.out.println();
        sayininilkXKuvvetiniYazdır(2,4);
        System.out.println();
        System.out.println(faktoriyel(5));
    }//structured

    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam = toplam + i;
        }
        return toplam;
    }

    //functional
    public static int toplam(int x) {
        return IntStream.//integer değerlerde bir kış sağlar
                range(1, x + 1).//range (a,b) -->> a dan b ye kadar (b dahil değil) int değerler akışa alındı
                sum();//akıştan gelen değerler toplandı
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftleriTopla(int x) {
        return IntStream.rangeClosed(1, x).//rangeClosed x i dahil eder
                filter(t -> t % 2 == 0).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int xciftleriTopla(int x) {
        return IntStream.iterate(2, t -> t + 2).// 2 den sonsuza kadar elemaları 2 arttırarak akışa alır
                limit(x).sum();// x ile sınırlıyoruz
    }

    //ilk x pozitif tek tamsayıyı toplayan programı yazınız
    public static int xtekleriTopla(int x) {
        return IntStream.iterate(1, t -> t + 2).// 1 den sonsuza kadar elemaları 2 arttırarak akışa alır
                limit(x).sum();// x ile sınırlıyoruz
    }
    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininxKuvvetiniYazdir(int x){
         IntStream.iterate(2,t-> t*2).limit(x).forEach(Lambda01::yazdir);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void sayininilkXKuvvetiniYazdır(int x,int istenenSayi){
        IntStream.iterate(istenenSayi,t-> t*istenenSayi).limit(x).forEach(Lambda01::yazdir);
    }
    //istenilen bir sayının faktöriyelini hesaplayan programı yazınız
    public static int faktoriyel(int x){
       return IntStream.rangeClosed(1,x).// akışı bir den başlat x e kadar devam et
               reduce(1,(t,u)->t*u);//
    }
}