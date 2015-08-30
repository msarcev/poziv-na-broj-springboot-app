package Test;

import pozivi.PozivFactory;
import java.util.TreeMap;

/**
 * Created by Mario on 30.8.2015..
 */

/* TEST
true :
MOD11 :    len2 "24"  |  len5 "01235"       |       len8 "01235588"      |         len11 "23412311120"           |           len13 "2341231112410"
MOD11MBG : len2 "27"  |  len5 "01228"       |       len8 "01235591"      |         len11 "23412311124"           |           len13 "2341231112412"
ISO7064 :  len2 "27"  |  len5 "01220"       |       len8 "01235586"      |         len11 "23412311124"           |           len13 "2341231112415"

slova : len2 "as"  |  len5 "asdfe"       |       len8 "asdfeass"      |         len11 "asdfeassert"           |           len13 "asdfeassertah"
test1 = "asdas";
 */

public class Test {
    public static void main(String[] args) {
        Validacije val = new Validacije();
        PozivFactory fact = new PozivFactory();

        // ALL MOD11 5 - 5 - 5 - 2
        String test1 = "01235-01235-01235-24";
        // ALL MOD11 5 - 5
        String test2 = "01235-01235";

     //   val.allTestaString(test1);
        val.generateString();

        for (int i = 5; i < 70; i++) {
            String model = Integer.toString(i);
            try {
               /* PozivNaModel poz = fact.odaberiPoziv(model);
                boolean result = poz.validatePoziv(test1);    //<-------- TEST
                String error = poz.getMsgErrorCode();
                if (result) {
                    System.out.println("Test Result  za MODEL            " + model +  "            : " + result );
                    System.out.println("");
                } else {
                    System.out.println("Test Result  za MODEL            " + model +  " er: *" + error + " *"  );
                    System.out.println("");
                }*/


            } catch (NullPointerException e){
//                System.out.println("Exception : *" + e.getMessage() + "*  za MODEL:" + model);
            }
        }
    }

    public static class Validacije {

        public void generateString(){
            String MOD11_len2 = "24", MOD11_len5 ="01235", MOD11_len8 ="01235588", MOD11_len11= "23412311120" ,MOD11_len13= "2341231112410";
            String MOD11MBG_len2 = "27",MOD11MBG_len5 ="01228" , MOD11MBG_len8 ="01235591", MOD11MBG_len11 ="23412311124" , MOD11MBG_len13 ="2341231112412";
            String ISO7064_len2 = "27" , ISO7064_len5 ="01220" , ISO7064_len8 ="01235586" , ISO7064_len11 ="23412311124" , ISO7064_len13 ="2341231112415";
            String slova_len2  = "as" , slova_len5 =  "asdfe",slova_len8= "asdfeass",slova_len11= "asdfeassert",slova_len13 ="asdfeassertah";
            TreeMap<Integer, String> mOD11 = new TreeMap<Integer,String>();
            TreeMap<Integer, String> mOD11MBG = new TreeMap<Integer,String>();
            TreeMap<Integer, String> iSO7064 = new TreeMap<Integer,String>();
            TreeMap<Integer, String> slova = new TreeMap<Integer,String>();
            mOD11.put(2,"24"); mOD11.put(5,"01235");mOD11.put(8,"01235588"); mOD11.put(11,"23412311120"); mOD11.put(13,"2341231112410");
            mOD11MBG.put(2,"27"); mOD11MBG.put(5,"01228");mOD11MBG.put(8,"01235591");mOD11MBG.put(11,"23412311124");mOD11MBG.put(13,"2341231112412");
            iSO7064.put(2,"27"); iSO7064.put(5,"01220");iSO7064.put(8,"01235586"); iSO7064.put(11,"23412311124"); iSO7064.put(13,"2341231112415");
            slova.put(2,"as"); slova.put(5,"asdfe");slova.put(8,"asdfeass"); slova.put(11,"asdfeassert"); slova.put(13,"asdfeassertah");

            for (Integer i : mOD11.keySet()){

            }


        }

        public void allTestaString (String s){
            boolean mod11_test=validateMOD11(s);
            boolean mod11MBG_test= validateMOD11MBG(s);
            boolean ISO7064_test= validateISO7064(s);
            System.out.println("String *" + s + "* + mod11test =" + mod11_test);
            System.out.println("String *" + s + "* + mod11MBG_test =" + mod11MBG_test);
            System.out.println("String *" + s + "* + ISO7064_test =" + ISO7064_test);
        }

        public boolean validateMOD11(String pozivPart){
            Integer ponder = 2;
            Integer KBR;
            Integer sum = 0;
            String kod="";
            if (pozivPart.length()>=1) {
                kod = pozivPart.substring(0, pozivPart.length() - 1);
                KBR = Integer.parseInt(pozivPart.substring(pozivPart.length() - 1, pozivPart.length()));
                for (int i = kod.length(); i > 0; i--) {
                    Integer znamenka = Integer.parseInt(kod.substring(i - 1, i));
                    sum = sum + (ponder * znamenka);
                    ponder++;
                }
                sum = sum % 11;
                if (sum == 0 || sum == 1) sum = 0;
                System.out.println("KBR je " + KBR + " a treba biti : " + sum);
                if (sum == KBR) return true;
                else return false;
            }
            else return false;
        }
        public boolean validateMOD11MBG(String pozivPart){
            Integer ponder = 1;
            Integer ponderCheck=0;
            Integer sum = 0;
            for (int i = pozivPart.length(); i > 0; i--){
                Integer znamenka = Integer.parseInt(pozivPart.substring(i - 1, i));
                if (ponder > 7 && ponderCheck == 0 ){
                    ponder =2;
                    ponderCheck=1;
                }
                sum = sum + (ponder * znamenka);
                ponder++;
            }
            sum = sum % 11;
            System.out.println("Sum je " + sum + "   (treba biti 0)");
            if (sum == 0) return true;
            else return false;
        }
        public boolean validateISO7064(String pozivPart){
            Integer ponder = 2;
            Integer KBU;
            Integer KBR=0;
            String kod;
            Integer znamenka=0;
            kod = pozivPart.substring(0, pozivPart.length()-1);
            KBU = Integer.parseInt(pozivPart.substring(pozivPart.length()-1 ,pozivPart.length()));
            for (int i = 1; i <= kod.length(); i++){
                if (i == 1) {
                    znamenka = Integer.parseInt(kod.substring(i-1, i));
                    if (znamenka==0)znamenka =10;
                    znamenka *= ponder;
                }
                if (i != kod.length()){
                    znamenka %= 11;
                    Integer next = Integer.parseInt(kod.substring(i,i+1));
                    znamenka += next;
                    znamenka %= 10;
                    znamenka *= 2;}
                else if (i == kod.length()){
                    KBR = znamenka % 11;
                }
            }
            if (KBR == 0) KBR = 1;
            else if (KBR == 1) KBR = 0;
            else KBR = 11 - KBR;
            System.out.println(" KBR je : " + KBU  + "... a treba biti : "+ KBR);
            if (KBR == KBU) return true;
            else return false;
        }
    }

}
