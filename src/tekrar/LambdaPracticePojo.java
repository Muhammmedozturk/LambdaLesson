package tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPracticePojo {
    public static void main(String[] args) {
        Apartman daire1=new Apartman("dogu",4000,3);
        Apartman daire2=new Apartman("bati",2500,2);
        Apartman daire3=new Apartman("guney",3500,1);
        Apartman daire4=new Apartman("dogu",3000,5);

        List<Apartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));
        doguSirala(kiralikDaireler);
        System.out.println(kat2denCok(kiralikDaireler));
    }
    //doğu cephesindeki kiralık daireleri kiralarına göre sıralayınız
    public static void doguSirala(List<Apartman> daireler){

        daireler.
                stream().
                filter(t->t.getCephe().equals("dogu")).
                sorted(Comparator.comparing(t->t.getKira()));
    }
    //kat sayısı ikiden çok olan daireleri listeleyin
    public static List<Integer>kat2denCok(List<Apartman> daireler){
       return daireler.stream().filter(t-> t.getKatSayisi()>2).map(t->t.getKira()).collect(Collectors.toList());
    }
}
