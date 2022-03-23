package domain;

public enum EyeColor {
    BROWN,
    BLUE,
    GREEN;

    public static EyeColor fromNumber(int i) {
        if (i == 0) return BROWN;
        if (i == 1) return BLUE;
        return GREEN;
    }
}
