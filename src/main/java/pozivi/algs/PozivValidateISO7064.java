package pozivi.algs;

/**
 * Created by msarcevic on 18.8.2015..
 */
public class PozivValidateISO7064 {
    private Integer ponder = 2, KBU,KBR;
    private Integer sum = 0;
    private String kod;
    private Integer znamenka;
    public boolean checkKBR(String pozivPart){
        kod="";sum=0;znamenka=0;
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
    public static void main(String[] args){
        String poz = "34001";
        PozivValidateISO7064 valTest = new PozivValidateISO7064();
        System.out.println("Test je " + valTest.checkKBR(poz));
    }
}
