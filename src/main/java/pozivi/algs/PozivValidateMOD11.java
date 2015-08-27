package pozivi.algs;

/**
 * Created by msarcevic on 18.8.2015..
 */
public class PozivValidateMOD11 {
    private Integer ponder = 2, KBR;
    private Integer sum = 0;
    private String kod;
    public boolean checkKBR(String pozivPart ){
        sum=0;
        kod="";
        ponder=2;
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
            System.out.println("KBR je " + KBR + " a treba bit " + sum);
            if (sum == KBR) return true;
            else return false;
        }
        else return false;
    }

    public static void main(String[] args){
        String poz = "1235";
        PozivValidateMOD11 valTest = new PozivValidateMOD11();
        System.out.println("Test je " + valTest.checkKBR(poz));
    }
}
