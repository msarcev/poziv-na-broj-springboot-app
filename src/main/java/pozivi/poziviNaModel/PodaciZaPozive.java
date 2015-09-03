package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 3.9.2015..
 */
public enum PodaciZaPozive {
    DASH("-"),
    MOD11_len2("24"),
    MOD11_len5("01235"),
    MOD11_len8("01235588"),
    MOD11_len11("23412311120"),
    MOD11_len13("2341231112410"),
    MOD11MBG_len2("27"),
    MOD11MBG_len5("01228"),
    MOD11MBG_len8("01235591"),
    MOD11MBG_len11("23412311124"),
    MOD11MBG_len13("2341231112412"),
    ISO7064_len2("27"),
    ISO7064_len5("01220"),
    ISO7064_len8("01235586"),
    ISO7064_len11("23412311124"),
    ISO7064_len13("2341231112415"),
    slova_len2("as"),
    slova_len5("asdfe"),
    slova_len8("asdfeass"),
    slova_len11("asdfeassert"),
    slova_len13("asdfeassertah");

    private final String podatak;
    PodaciZaPozive(String podatak){
        this.podatak = podatak;
    }

}
