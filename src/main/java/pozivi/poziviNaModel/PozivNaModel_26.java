package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_26 extends PozivNaModel{

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid ==true && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() != 4) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                    }
                }
                //check za drugi podatak
                if (isValid ==true && nOfParts == 2) {
                    if (next.length() <= 10){
                        if (!validateMOD11(next)){
                            isValid = false;
                            msgErrorCode="poziv.podatak.drugi.neispravan";
                        }
                    } else if (next.length() == 11 ){
                        if (!validateISO7064(next)){
                            isValid = false;
                            msgErrorCode="poziv.podatak.drugi.neispravan";
                        }
                    } else {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.predug";
                    }
                }
                if (isValid ==true &&  nOfParts == 3) {
                 if ( next.length() <=10){
                     if (!validateMOD11(next)){
                         isValid = false;
                         msgErrorCode="poziv.podatak.treci.neispravan";
                     }
                 } else if (next.length() == 11 ){
                     if (!validateISO7064(next)){
                         isValid = false;
                         msgErrorCode="poziv.podatak.treci.neispravan";
                     }
                 } else if (next.length() == 13){
                     if (!validateMOD11MBG(next)){
                         isValid = false;
                         msgErrorCode="poziv.podatak.treci.neispravan";
                     }
                 } else {
                     isValid = false;
                     msgErrorCode = "poziv.podatak.predug";
                 }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            emptyOrCharactersCheck(kod);
            //check ponovo za treci podatak, ako ima samo 3
            if (isValid ==true &&  nOfParts == 3) {
                if ( kod.length() <=10){
                    if (!validateMOD11(kod)){
                        isValid = false;
                        msgErrorCode="poziv.podatak.treci.neispravan";
                    }
                } else if (kod.length() == 11 ){
                    if (!validateISO7064(kod)){
                        isValid = false;
                        msgErrorCode="poziv.podatak.treci.neispravan";
                    }
                } else if (kod.length() == 13){
                    if (!validateMOD11MBG(kod)){
                        isValid = false;
                        msgErrorCode="poziv.podatak.treci.neispravan";
                    }
                } else {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.predug";
                }
            }
            if (isValid =true && nOfParts == 4){
             if (kod.length() > 13) {
                 isValid = false;
                 msgErrorCode= "poziv.podatak.predug";
             }
            }
            if (isValid ==true && nOfParts < 3){
                isValid =false;
                msgErrorCode="poziv.premalo.podataka";
            }
            if (isValid ==true && nOfParts>4 ){
                isValid =false;
                msgErrorCode="poziv.previse.dijelova";
            }
        }
        else {
                isValid = false;
                msgErrorCode = "poziv.premalo.podatak";
                return isValid;
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_26 poz = new PozivNaModel_26();
        String test = "3127-1214-123412311123-12";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
