import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/
        List<Integer> sayi=new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));
        //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
        // aralarında bosluk olacak sekilde print ediniz.

            printElStructured(sayi);
            printElFunctional(sayi);
        System.out.println();
        printElFunctional1(sayi);
        System.out.println();
        printElFunctional2(sayi);
        System.out.println();
        printciftElemanFunctional(sayi);
        System.out.println();
        printciftElemanStructural(sayi);
        System.out.println();
        printciftOtcKck(sayi);
        System.out.println();
        printciftOtzBuyukFunctional(sayi);

    }
    public static void printElStructured(List<Integer>sayi){
        for (Integer w:sayi) {
            System.out.print(w+" ");
        }
    }
    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer>sayi){
        System.out.println();//yukardaki ile arasında boşluk bırakır
        sayi.stream().forEach((t) -> System.out.print(t+" "));//lambda expression
    }
    public static void printElFunctional1(List<Integer>sayi){
        System.out.println();//yukardaki ile arasında boşluk bırakır
        sayi.stream().forEach(System.out::print);//metod referance
    }
    //kendimiz bir metod oluşturalım
    public static void yazdir(int a){
        System.out.print(a+" ");
    }
    public static void yazdirString(String a){
        System.out.print(a+" ");
    }
    public static void printElFunctional2(List<Integer>sayi){
        System.out.println();//yukardaki ile arasında boşluk bırakır
        sayi.stream().forEach(Lambda01::yazdir);//metod referance
    }
    //TASK functional programing ile list elemanlarının çift olanlarını aynı satırda aralarına boşluk bırakarak print ediniz
    public static void printciftElemanFunctional(List<Integer>sayi){
        sayi.
                stream().
                    filter(t->t%2==0).//lambda expression
                        forEach(t-> System.out.println(t+" "));
    }
    // yukardaki Task'i filter() kısmını method referance ile yapalım
    public static boolean ciftBul(int a) {
        return a % 2 == 0; // = =
    }
    public static void printCiftElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).  // method refrance
                forEach(Lambda01::yazdir);

    }
    //TASK structural programing ile list elemanlarının çift olanlarını aynı satırda aralarına boşluk bırakarak print ediniz
    public static void printciftElemanStructural(List<Integer>sayi){
        for (Integer w: sayi){
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }
    //Task: functional programming ile list elemanlarının 34 ten küçük çift olanlarını aynı satırda aralarında boşluk bırakarak
    // yazdırınız
    public static void printciftOtcKck(List<Integer>sayi){
        sayi.stream().filter(t->t%2==0 && t<34).forEach(Lambda01::yazdir);

    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda
    // aralarina bosluk birakarak print ediniz.
    public static void printciftOtzBuyukFunctional(List<Integer>sayi){
     sayi.stream().filter(t->t%2==0 || t>34).forEach(Lambda01::yazdir);

        }
    }

