package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_28 extends PozivNaModel{

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid ==true && nOfParts == 1) {
                    if ( next.length() != 4 || !validateMOD11(next) ) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                    }
                }
                if (isValid ==true && nOfParts == 2) {
                    if ( next.length() != 3 || !validateMOD11(next) ) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.drugi.neispravan";
                    }
                }
                if (isValid ==true && nOfParts == 3) {
                    if ( next.length() != 6 || !validateMOD11(next) ) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.treci.neispravan";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            emptyOrCharactersCheck(kod);
            if (isValid ==true && nOfParts == 3) {
                if ( kod.length() != 6 || !validateMOD11(kod) ) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.treci.neispravan";
                }
            }
            if (isValid ==true && ( nOfParts ==4 && kod.length()>6)){
                isValid = false;
                msgErrorCode = "poziv.podatak.predug";
            }
            if (isValid ==true && nOfParts < 3){
                isValid =false;
                msgErrorCode="poziv.premalo.podataka";
            }
            if (isValid ==true &&  nOfParts > 4){
                isValid =false;
                msgErrorCode="poziv.previse.dijelova";
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
        PozivNaModel_28 poz = new PozivNaModel_28();
        String test = "3116-127-134235";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
