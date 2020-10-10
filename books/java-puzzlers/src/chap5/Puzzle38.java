package chap5;

import common.AbstractPuzzle;

public class Puzzle38 extends AbstractPuzzle {

//    public static final long GUEST_USER_ID = -1;
//    private static final long USER_ID;
//    static {
//        try {
//            USER_ID = getUserIdFromEnvironment();
//        } catch (IdUnavailableException e) {
//            USER_ID = GUEST_USER_ID;
//            System.out.println("logging in as guest");
//        }
//    }

    public Puzzle38() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
//        System.out.println("User ID : " + USER_ID);
    }

    private static long getUserIdFromEnvironment() throws IdUnavailableException {
        throw new IdUnavailableException();
    }

    static class IdUnavailableException extends Exception {}

    @Override
    public void showCorrect() {
    }
}
