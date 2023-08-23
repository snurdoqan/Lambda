package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> meyveler=new ArrayList<>(Arrays.asList("Elma","Portakal","Uzum","Cilek","Greyfurt","Nar","Mandalina","Armut","Elma","Keciboynuzu","Elma"));
        ilkHarfEVeyaC(meyveler);//
        System.out.println("\n  *****");
        basinaVeSonunaYildiz(meyveler);//*Elma* *Portakal* *Uzum* *Cilek* *Greyfurt* *Nar* *Mandalina* *Armut* *Elma* *Keciboynuzu* *Elma*
        System.out.println("\n  *****");
        lHarfiniSil(meyveler);//Ema Portaka Uzum Ciek Greyfurt Nar Mandaina Armut Ema Keciboynuzu Ema
        System.out.println("\n  *****");
        karakterSayisinaGoreKucuktenBuyugeLambdaEv(meyveler);//Nar Elma Uzum Elma Elma Cilek Armut Portakal Greyfurt Mandalina Keciboynuzu
        System.out.println("\n  *****");
        karakterSayisinaGoreKucuktenBuyugeLambdaEv2(meyveler);//Keciboynuzu Mandalina Portakal Greyfurt Cilek Armut Elma Uzum Elma Elma Nar
        System.out.println("\n  *****");
        karakterSayisinaGoreBuyuktenKucugeLambdaEv(meyveler);//Keciboynuzu Mandalina Portakal Greyfurt Cilek Armut Elma Uzum Elma Elma Nar
    }
    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari, Method References ile aralarında bosluk bırakarak yazdıralım
    public static void ilkHarfEVeyaC(List<String> meyveler){
        meyveler.stream().filter(t->t.startsWith("e")|| t.startsWith("c")).forEach(Utils::yazdir);
    }

    //SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basinaVeSonunaYildiz(List<String> meyveler){
        meyveler.stream().map(t->"*"+t+"*").forEach(Utils::yazdir);
    }
    // SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın
    public static void  icindeEHarfiOlanlar(List<String> meyveler){
        meyveler.stream().filter(t->t.contains("e")).forEach(Utils::yazdir);
    }
    // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız
    public static void lHarfiniSil(List<String> meyveler){
        meyveler.stream().map(t->t.replace("l","")).forEach(Utils::yazdir);
    }
// SORU5 : List elemanlarini, Lambda Expression kullanarak // karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreKucuktenBuyugeLambdaEv(List<String> meyveler) {
        meyveler.stream().sorted(Comparator.comparing(t -> t.length())).forEach(Utils::yazdir);
    }
 // SORU5 Version 2 : List elemanlarini, Lambda Expression kullanarak // karakter sayisina göre buyukten küçüğe dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreKucuktenBuyugeLambdaEv2(List<String> meyveler) {
     meyveler.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).forEach(Utils::yazdir);
}
// SORU6 : List elemanlarini, Method References kullanarak//karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreBuyuktenKucugeLambdaEv(List<String> meyveler) {
        meyveler.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::yazdir);
/* diğer yol
List<String> sonuc1 = meyve.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).collect(Collectors.toList());
System.out.println(sonuc1);
 */
    }

}
