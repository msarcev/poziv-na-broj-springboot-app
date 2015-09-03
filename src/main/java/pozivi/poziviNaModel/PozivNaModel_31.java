package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 25.8.2015..
 */
public class PozivNaModel_31 extends PozivNaModel{

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
                if (isValid && nOfParts == 1 && (next.length() > 6 || !validateISO7064(next))) {
                    isValid =false;
                    msgErrorCode="Prvi podatak je neispravan";
                }
                if (isValid && nOfParts>1 && (next.length() > 12)){
                    isValid =false;
                    msgErrorCode="poziv.podatak.predug";
                }

                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 4 && kod.length()>12){
                isValid =false;
                msgErrorCode="poziv.podatak.predug";
            }
            if (isValid && nOfParts>4){
                isValid =false;
                msgErrorCode="poziv.previse.dijelova";
            }
        }
        else {
            emptyOrCharactersCheck(kod);
            if (isValid && (kod.length() > 6 || !validateISO7064(kod))) {
                isValid =false;
                msgErrorCode="poziv.podatak.prvi.neispravan";
            }
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_31 poz = new PozivNaModel_31();
        String test = "3113-1-112-1";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
