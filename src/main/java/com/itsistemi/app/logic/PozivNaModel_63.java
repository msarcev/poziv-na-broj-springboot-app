package com.itsistemi.app.logic;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class PozivNaModel_63 extends PozivNaModel {

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
                if (isValid && nOfParts == 1 ){
                    if (next.length() != 4 || !validateMOD11(next)) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                if (isValid &&  nOfParts == 2  ){
                    if (next.substring(0,1).equals("0")){
                        isValid=false;
                        msgErrorCode="poziv.podatak.prvi.nula";
                    }
                    if(next.length() > 5 || !validateISO7064(next)) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.drugi.neispravan";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid &&  nOfParts == 3 && (kod.length() > 12 || !validateMOD11(kod))){
                isValid=false;
                msgErrorCode="poziv.podatak.treci.neispravan";
            }
            if (isValid &&  nOfParts < 3){
                isValid=false;
                msgErrorCode="poziv.required.parts";
            }
            if (isValid &&  nOfParts > 3){
                isValid=false;
                msgErrorCode="poziv.previse.dijelova";
            }
        }
        else {
                isValid = false;
                msgErrorCode = "poziv.required.parts";
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_63 poz = new PozivNaModel_63();
        String test = "3116-123-127";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
