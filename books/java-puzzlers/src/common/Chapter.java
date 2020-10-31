package common;

public enum Chapter {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10);

    private int chapter;

    Chapter(int chapter) {
        this.chapter = chapter;
    }

    public int getValue() {
        return this.chapter;
    }
}
