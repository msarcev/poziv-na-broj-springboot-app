package Test;

import pozivi.poziviNaModel.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mario on 30.8.2015..
 */

/* TEST
true :
MOD11 :    len2 "24"  |  len5 "01235"       |       len8 "01235588"      |         len11 "23412311120"           |           len13 "2341231112410"
MOD11MBG : len2 "27"  |  len5 "01228"       |       len8 "01235591"      |         len11 "23412311124"           |           len13 "2341231112412"
ISO7064 :  len2 "27"  |  len5 "01220"       |       len8 "01235586"      |         len11 "23412311124"           |           len13 "2341231112415"


            String MOD11_len2= "24", MOD11_len5 ="01235", MOD11_len8 ="01235588", MOD11_len11= "23412311120" ,MOD11_len13= "2341231112410";
            String MOD11MBG_len2 = "27",MOD11MBG_len5 ="01228" , MOD11MBG_len8 ="01235591", MOD11MBG_len11 ="23412311124" , MOD11MBG_len13 ="2341231112412";
            String ISO7064_len2 = "27" , ISO7064_len5 ="01220" , ISO7064_len8 ="01235586" , ISO7064_len11 ="23412311124" , ISO7064_len13 ="2341231112415";
            String slova_len2  = "as" , slova_len5 =  "asdfe",slova_len8= "asdfeass",slova_len11= "asdfeassert",slova_len13 ="asdfeassertah";

slova : len2 "as"  |  len5 "asdfe"       |       len8 "asdfeass"      |         len11 "asdfeassert"           |           len13 "asdfeassertah"
test1 = "asdas";
 */

public class Test {

    public static void main(String[] args) {
        Validacije val = new Validacije();
//        val.allTests("6789");
        val.test_Poziv_05();
        val.test_Poziv_11();
        val.test_Poziv_12();
        val.test_Poziv_21();
        val.test_Poziv_22();
        val.test_Poziv_23();
        val.test_Poziv_24();
        val.test_Poziv_25();
        val.test_Poziv_26();
        val.test_Poziv_27();
        val.test_Poziv_28();
        val.test_Poziv_29();
    }

    private static class Validacije {
        @org.junit.Test
        public void test_Poziv_05(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_05();
            String test1 = "01235-6789-01";
            String test2 = "23412311120-9875-777";
            String test3 = "01235";
            String test4 = "01235588-451756215874";

            String test5 = "486823487154-368542842-89247";
            String test6 = "012345-456461987";
            String test7 = "948517-84287";
            String test8 = "841789-184546-48465-8";
            String test9 = "841651-1546418";
            System.out.println("                |||        TEST POZIV_05        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");

                assertEquals(false, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");
                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }

        }
        @org.junit.Test
        public void test_Poziv_11(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_11();
            String test1 = "23412311120-01235588";
            String test2 = "01235-23412311120-77";
            String test3 = "01235588-01235588-878";
            String test4 = "01235-345349-515";
            String test5 = "01235588-01235-845878";

            String test6 = "486823487154-368542842-8924-87";
            String test7 = "012345-456461987";
            String test8 = "948517-84287";
            String test9 = "841789-184546-48465";
            String test10 = "23412311120";
            System.out.println("                |||        TEST POZIV_11        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_12(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_12();
            String test1 = "2341231112412-01235588";
            String test2 = "2341231112412-234123";
            String test3 = "2341231112412-2341";
            String test4 = "2341231112412-4846-515";
            String test5 = "2341231112412-01235591";

            String test6 = "23412311124-368542-8924-87";
            String test7 = "012345-456461987";
            String test8 = "01235591-84287";
            String test9 = "01228-184546-48465";
            String test10 = "234123111208742";
            System.out.println("                |||        TEST POZIV_12        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_21(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_21();
            String test1 = "1235-01235588";
            String test2 = "1235-01235588-77547821";
            String test3 = "4170-01235588-878";
            String test4 = "4170-01235588-515";
            String test5 = "4170-01235588";

            String test6 = "4170-36854284-8924";
            String test7 = "4170-01235588-297-84";
            String test8 = "9485-01235588";
            String test9 = "41700-01235588-48465";
            String test10 = "4170-23412311120";
            System.out.println("                |||        TEST POZIV_21        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
         public void test_Poziv_22(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_22();
            String test1 = "1235-2341231112412";
            String test2 = "1235-2341231112412-775";
            String test3 = "4170-2341231112412-878";
            String test4 = "4170-2341231112412-515";
            String test5 = "4170-2341231112412-854";

            String test6 = "41707-2341231112412-847";
            String test7 = "4170-23412311172412-964";
            String test8 = "4171-2341231112412-874";
            String test9 = "4170-2341231112418-965";
            String test10 = "4170-2341231112222";
            System.out.println("                |||        TEST POZIV_22        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_23(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_23();
            String test1 = "6178-2341231121";
            String test2 = "6178-23412311121-775";
            String test3 = "6178-23412312-878";
            String test4 = "6178-23411-515-875";
            String test5 = "6178-234112-854-9844";

            String test6 = "41707-2341231112412-847";
            String test7 = "4170-23412311172412-964";
            String test8 = "4171-2341231112-874";
            String test9 = "4170-234-965-78459685478569";
            String test10 = "4170-2341231112412";
            System.out.println("                |||        TEST POZIV_23        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_24(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_24();
            String test1 = "6178-2341231121";
            String test2 = "6178-23412311121-775";
            String test3 = "6178-23412312-878";
            String test4 = "6178-23411-515-875";
            String test5 = "6178-23411112-854-9844";

            String test6 = "6177-2341231112412-847";
            String test7 = "6178-23412311172412-964";
            String test8 = "6170-2341231112-874";
            String test9 = "6178-234-965-784596854789";
            String test10 = "6177-23412311124128-9877";
            System.out.println("                |||        TEST POZIV_24        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_25(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_25();
            String test1 = "123-2341231";
            String test2 = "183-1234567";
            String test3 = "817-9874585";
            String test4 = "427-7664892";
            String test5 = "417-8974512";

            String test6 = "417-28749674";
            String test7 = "136-8745125-96";
            String test8 = "41-1234567";
            String test9 = "410-7845125-01-01";
            String test10 = "617-2341";
            System.out.println("                |||        TEST POZIV_25        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_26(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_26();
            String test1 = "4170-01235588-01235588";
            String test2 = "4170-23412311124-01235";
            String test3 = "4170-243-2341231112412";
            String test4 = "1235-24-24-87451256";
            String test5 = "1235-24-2341231112412";

            String test6 = "4171-01235588-01235588";
            String test7 = "4170-23412311125-1235";
            String test8 = "4170-4170-2341231112413";
            String test9 = "4170-1234567-89454";
            String test10 = "4170-7845125-01-01111";
            System.out.println("                |||        TEST POZIV_26        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_27(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_27();
            String test1 = "4170-23412311120";
            String test2 = "4170-01235588";
            String test3 = "4170-01235";
            String test4 = "1235-24";
            String test5 = "1235-1235";

            String test6 = "4170-234123111207";
            String test7 = "4170-23412311121";
            String test8 = "4171-23412311121";
            String test9 = "4170-23412311121-414";
            String test10 = "410-23412311121";
            System.out.println("                |||        TEST POZIV_27        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_28(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_28();
            String test1 = "4170-243-345349";
            String test2 = "4170-450-345349-8874";
            String test3 = "4170-450-345349-4578";
            String test4 = "1235-450-347346";
            String test5 = "1235-243-347346";

            String test6 = "1235-243-34734699";
            String test7 = "1235-4170-347346";
            String test8 = "1235-243-347347";
            String test9 = "1235-242-347346";
            String test10 = "1233-243-347346";
            System.out.println("                |||        TEST POZIV_28        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }
        @org.junit.Test
        public void test_Poziv_29(){
            int count = 1;
            PozivNaModel poz = new PozivNaModel_29();
            String test1 = "4170-243-345349";
            String test2 = "4170-23412311120-8874";
            String test3 = "4170-450-01235588";
            String test4 = "1235-243-243";
            String test5 = "1235-24-243";

            String test6 = "1235-243-2341231112410";
            String test7 = "1235-4171-347346";
            String test8 = "1235-243";
            String test9 = "1235-242-347346-01";
            String test10 = "01235-01235-01235";
            System.out.println("                |||        TEST POZIV_29        |||");
            try {
                assertEquals(true, poz.validatePoziv(test1));
                System.out.println("Test " + count++ + "  " + test1 + "  = pass");
                assertEquals(true, poz.validatePoziv(test2));
                System.out.println("Test " + count++ + "  " + test2 + "  = pass");
                assertEquals(true, poz.validatePoziv(test3));
                System.out.println("Test " + count++ + "  " + test3 + "  = pass");
                assertEquals(true, poz.validatePoziv(test4));
                System.out.println("Test " + count++ + "  " + test4 + "  = pass");
                assertEquals(true, poz.validatePoziv(test5));
                System.out.println("Test " + count++ + "  " + test5 + "  = pass");

                assertEquals(false, poz.validatePoziv(test6));
                System.out.println("Test " + count++ + "  " + test6 + "  = pass");
                assertEquals(false, poz.validatePoziv(test7));
                System.out.println("Test " + count++ + "  " + test7 + "  = pass");
                assertEquals(false, poz.validatePoziv(test8));
                System.out.println("Test " + count++ + "  " + test8 + "  = pass");
                assertEquals(false, poz.validatePoziv(test9));
                System.out.println("Test " + count++ + "  " + test9 + "  = pass");
                assertEquals(false, poz.validatePoziv(test10));
                System.out.println("Test " + count++ + "  " + test10 + "  = pass");
            }
            catch (AssertionError e){
                System.out.println("String "+ count + " fail. Msg : " + poz.getMsgErrorCode());
            }
        }






        private void allTests(String s){
            boolean mod11_test=validateMOD11(s);
            boolean mod11MBG_test= validateMOD11MBG(s);
            boolean ISO7064_test= validateISO7064(s);
            System.out.println("String *" + s + "* + mod11test =" + mod11_test);
            System.out.println("String *" + s + "* + mod11MBG_test =" + mod11MBG_test);
            System.out.println("String *" + s + "* + ISO7064_test =" + ISO7064_test);
        }
        private boolean validateMOD11(String pozivPart){
            Integer ponder = 2;
            Integer KBR;
            Integer sum = 0;
            String kod;
            if (pozivPart.length()>=1) {
                kod = pozivPart.substring(0, pozivPart.length() - 1);
                KBR = Integer.parseInt(pozivPart.substring(pozivPart.length() - 1, pozivPart.length()));
                for (int i = kod.length(); i > 0; i--) {
                    Integer znamenka = Integer.parseInt(kod.substring(i - 1, i));
                    sum = sum + (ponder * znamenka);
                    ponder++;
                }
                sum = sum % 11;
                if (sum == 0 || sum == 1) sum = 0;
                System.out.println("KBR je " + KBR + " a treba biti : " + sum);
                return sum.equals(KBR);
            }
            else return false;
        }
        private boolean validateMOD11MBG(String pozivPart){
            Integer ponder = 1;
            Integer ponderCheck=0;
            Integer sum = 0;
            for (int i = pozivPart.length(); i > 0; i--){
                Integer znamenka = Integer.parseInt(pozivPart.substring(i - 1, i));
                if (ponder > 7 && ponderCheck == 0 ){
                    ponder =2;
                    ponderCheck=1;
                }
                sum = sum + (ponder * znamenka);
                ponder++;
            }
            sum = sum % 11;
            System.out.println("Sum je " + sum + "   (treba biti 0)");
            return sum == 0;
        }
        private boolean validateISO7064(String pozivPart){
            Integer ponder = 2;
            Integer KBU;
            Integer KBR=0;
            String kod;
            Integer znamenka=0;
            kod = pozivPart.substring(0, pozivPart.length()-1);
            KBU = Integer.parseInt(pozivPart.substring(pozivPart.length()-1 ,pozivPart.length()));
            for (int i = 1; i <= kod.length(); i++){
                if (i == 1) {
                    znamenka = Integer.parseInt(kod.substring(i-1, i));
                    if (znamenka==0)znamenka =10;
                    znamenka *= ponder;
                }
                if (i != kod.length()){
                    znamenka %= 11;
                    Integer next = Integer.parseInt(kod.substring(i,i+1));
                    znamenka += next;
                    znamenka %= 10;
                    znamenka *= 2;}
                else if (i == kod.length()){
                    KBR = znamenka % 11;
                }
            }
            if (KBR == 0) KBR = 1;
            else if (KBR == 1) KBR = 0;
            else KBR = 11 - KBR;
            System.out.println(" KBR je : " + KBU  + "... a treba biti : "+ KBR);
            return KBR.equals(KBU);
        }
    }

}
