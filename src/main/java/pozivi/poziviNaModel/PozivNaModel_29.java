package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_29 extends PozivNaModel{

    @Override
    public boolean validatePoziv(String kod) {
        //check ako je poziv predug
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1 && (next.length() != 4 || !validateMOD11(next))) {
                    isValid =false;
                    msgErrorCode="Prvi podatak je neispravan";
                }
                if (isValid && nOfParts== 2 && (next.length() > 12 || !validateMOD11(next))){
                    isValid =false;
                    msgErrorCode="Drugi podatak je neispravan";
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid &&  nOfParts == 3 && (kod.length() > 12 || !validateMOD11(kod))){
                isValid =false;
                msgErrorCode="poziv.podatak.treci.neispravan";
            }
            if (isValid && (nOfParts < 3 || nOfParts > 3)){
                isValid =false;
                msgErrorCode= "poziv.broj.podataka.fail";
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
        PozivNaModel_29 poz = new PozivNaModel_29();
        String test = "3116-1212131216-1210";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
