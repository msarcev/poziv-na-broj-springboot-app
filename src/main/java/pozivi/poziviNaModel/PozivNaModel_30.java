package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_30 extends PozivNaModel {

    @Override
    public boolean validatePoziv(String kod) {
        isValid= true;
        nOfParts = 1;
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1 && next.length() != 10) {
                    isValid =false;
                    msgErrorCode="poziv.podatak.prvi.neispravan";
                }
                if (isValid && nOfParts == 2 && next.length() != 4) {
                    isValid =false;
                    msgErrorCode="poziv.podatak.drugi.neispravan";
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 3 && kod.length() > 6) {
                isValid =false;
                msgErrorCode="poziv.podatak.treci.neispravan";
            }
            if (isValid && nOfParts < 3 || nOfParts > 3) {
                isValid =false;
                msgErrorCode="poziv.broj.podataka.fail";
            }
        }
        else {
                isValid = false;
                msgErrorCode = "poziv.premalo.podataka";
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_30 poz = new PozivNaModel_30();
        String test = "3117112345-121";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
