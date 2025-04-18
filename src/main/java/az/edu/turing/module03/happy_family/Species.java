package az.edu.turing.module03.happy_family;

public enum Species {
    DOG(true, 4, true),
    CAT(true, 4, true),
    FISH(false, 0, false),
    ROBOCAT(false, 4, false),
    UNKNOWN(false, 0, false);

    public final boolean canFly;
    public final int numberOfLegs;
    public final boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
}
