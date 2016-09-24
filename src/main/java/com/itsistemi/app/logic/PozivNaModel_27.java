package com.itsistemi.app.logic;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_27 extends PozivNaModel{

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
                    if ( next.length() != 4 || !validateMOD11(next) ) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 2){
                if (kod.length() > 12 || !validateMOD11(kod)){
                    isValid = false;
                    msgErrorCode="poziv.modul11.fail";
                }
            }
            if (isValid && nOfParts > 2){
                isValid =false;
                msgErrorCode="poziv.previse.dijelova";
            }
        } else
        {
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
        PozivNaModel_27 poz = new PozivNaModel_27();
        String test = "3117-12121218";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
