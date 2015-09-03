package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_25 extends PozivNaModel{

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
                if (isValid && nOfParts == 1) {
                    if ( next.length() != 3) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 2) {
                if (kod.length() != 7) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.drugi.neispravan";
                }
            }
            if (isValid && nOfParts > 2) {
                    isValid = false;
                    msgErrorCode = "poziv.previse.dijelova";
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
        PozivNaModel_25 poz = new PozivNaModel_25();
        String test = "311-1212121";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
