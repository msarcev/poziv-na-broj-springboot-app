package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class PozivNaModel_33 extends PozivNaModel{

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid &&  nOfParts == 1 && (next.length() > 6 || !validateISO7064(next))) {
                    isValid = false;
                    msgErrorCode="poziv.podatak.prvi.neispravan";
                }
                if (isValid &&  nOfParts == 2 && (next.length() > 7 || !validateISO7064(next))) {
                    isValid = false;
                    msgErrorCode="poziv.podatak.drugi.neispravan";
                }

                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 3 && kod.length() > 7) {
                isValid = false;
                msgErrorCode="poziv.podatak.treci.neispravan";
            }
            if (isValid &&  nOfParts < 3){
                isValid =false;
                msgErrorCode="poziv.required.parts";
            }
            if (isValid &&   nOfParts > 3){
                isValid =false;
                msgErrorCode="poziv.previse.dijelova";
            }
        }
        else {
                isValid = false;
                msgErrorCode = "poziv.required.parts";
                return isValid;
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_33 poz = new PozivNaModel_33();
        String test = "3115-12127-123121";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
