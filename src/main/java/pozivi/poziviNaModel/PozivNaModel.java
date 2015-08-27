package pozivi.poziviNaModel;

import pozivi.IPozivNaBroj;
import pozivi.IsNumeric;

/**
 * Created by msarcevic on 27.8.2015..
 */
public abstract class PozivNaModel {

    protected String msgErrorCode ="poziv.fail.default";
    protected Integer nOfParts=1;
    protected boolean valid = true;

    protected void sveukupnaDuzinaCheck (String kod){
        if (kod.length()>22) {
            valid = false;
            msgErrorCode ="poziv.duzina.veca.max";
        }
    }
    protected void emptyOrCharactersCheck (String kod){
        //if za ako je crtica zadnja
        if (kod.equals("")|| !isNumeric(kod))
        {
            valid=false;
            msgErrorCode="poziv.fail.default";
        }
    }
    protected boolean isNumeric(String str) {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
    protected boolean validateMOD11(String pozivPart){
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
            System.out.println("KBR je " + KBR + " a treba bit " + sum);
            if (sum == KBR) return true;
            else return false;
        }
        else return false;
    }
    protected boolean validateMOD11MBG(String pozivPart){
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
    protected boolean validateISO7064(String pozivPart){
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

    public boolean validatePoziv(String kod){
        return valid;
    };
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
}
