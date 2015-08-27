package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class PozivNaModel_66 implements IPozivNaBroj {
    private String msgErrorCode ="poziv.fail.default";
    private Integer nOfParts=1;
    private IsNumeric num = new IsNumeric();
    String prvih8Nexta;
    private String pozivNB;
    private boolean valid = true;
    public String getPozivNB() {
        return pozivNB;
    }
    public void setPozivNB(String pozivNB) {
        this.pozivNB = pozivNB;
    }

    @Override
    public boolean validatePoziv(String kod) {
        PozivValidateMOD11 algMOD11 = new PozivValidateMOD11();
        //check ako je poziv predug
        if (kod.length() > 22) {
            valid = false;
            msgErrorCode = "poziv.duzina.veca.max";
            return valid;
        }

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                if (next.equals("") || !num.isNumeric(next)){
                    valid= false;
                    msgErrorCode="poziv.fail.default";
                    return valid;
                }
                //check za prvi podatak
                if (nOfParts == 1 ){
                    if (next.length() != 4 || !algMOD11.checkKBR(next)) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                        return valid;
                    }
                }
                if (nOfParts == 2 ){
                    if (next.length() > 8) {
                        prvih8Nexta = next.substring(0,8);
                    } else {
                        valid=false;
                        msgErrorCode="poziv.podatak.drugi.neispravan";
                        return valid;
                    }
                    System.out.println("Prvih 8 je : " + prvih8Nexta);
                    if (next.length() != 12 || !algMOD11.checkKBR(prvih8Nexta)) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                        return valid;
                    }
                }

                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";return valid;}
            if (nOfParts == 2 ){
                if (kod.length() > 8) {
                    prvih8Nexta = kod.substring(0,8);
                } else {
                    valid=false;
                    msgErrorCode="poziv.podatak.drugi.neispravan";
                    return valid;
                }
                if (kod.length() != 12 || !algMOD11.checkKBR(prvih8Nexta)) {
                    valid = false;
                    msgErrorCode = "poziv.modul11.fail";
                    return valid;
                }
            }
            if ( nOfParts == 3 && kod.length()!=4){
                valid = false;
                msgErrorCode = "poziv.podatak.treci.neispravan";
                return valid;
            }
            if ( nOfParts > 4){
                valid=false;
                msgErrorCode="poziv.previse.dijelova";
                return valid;
            }
            if ( nOfParts < 2 ){
                valid=false;
                msgErrorCode="poziv.premalo.podataka";
                return valid;
            }
        }
        else {
            if (kod.equals("") || !num.isNumeric(kod)){
                valid= false;
                msgErrorCode="poziv.fail.default";
                return valid;
            } else {
                valid = false;
                msgErrorCode = "poziv.required.parts";
                return valid;
            }
        }
        return valid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_66 poz = new PozivNaModel_66();
        String test = "3117-121212182771";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
