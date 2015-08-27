package pozivi.algs;

/**
 * Created by msarcevic on 18.8.2015..
 */
public class PozivValidateMOD11MBG {
    private Integer ponder = 1, ponderCheck=0;
    private Integer sum = 0;
    private String kod;
    public boolean checkKBR(String pozivPart){
        ponder=1;sum=0;kod="";
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

    public static void main(String[] args){
        String poz = "2004940339319";
        PozivValidateMOD11MBG valTest = new PozivValidateMOD11MBG();
        System.out.println("Test MOD11MBG je " + valTest.checkKBR(poz));
    }
}
