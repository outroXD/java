package common;

public enum ChapterEnum {
    ChapTwo(2),
    ChapThree(3);

    private int chapter;

    private ChapterEnum(int chapter) {
        this.chapter = chapter;
    }
}
