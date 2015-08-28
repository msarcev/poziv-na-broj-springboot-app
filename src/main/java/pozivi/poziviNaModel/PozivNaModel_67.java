package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class PozivNaModel_67 extends PozivNaModel {

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1) {
                    if ( next.length() != 11 || !validateISO7064(next)){
                        isValid=false;
                        msgErrorCode="poziv.modul11.fail";
                    }
                }
                if (isValid && nOfParts == 2 && next.length() > 10){
                    isValid=false;
                    msgErrorCode="poziv.podatak.drugi.neispravan";
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 2 && kod.length() > 10){
                isValid=false;
                msgErrorCode="poziv.podatak.drugi.neispravan";
            }
            if (isValid &&  nOfParts == 3 && kod.length() > 8){
                isValid=false;
                msgErrorCode="poziv.podatak.treci.neispravan";
            }
            if (isValid &&  nOfParts > 3){
                isValid=false;
                msgErrorCode="poziv.previse.dijelova";
            }
        }
        else {
            emptyOrCharactersCheck(kod);
            if (isValid && (kod.length() != 11 || !validateISO7064(kod))) {
                isValid = false;
                msgErrorCode = "poziv.modul11.fail";
                return isValid;
            }
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_67 poz = new PozivNaModel_67();
        String test = "31171233220-11-123123";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
