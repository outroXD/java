public class AssertStatements {
    public static void main(String args[]) {
        example91(10);
    }

    public static int example91(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("sqrt: negative arguments.");
        }
        int temp, y = 0, b = 0x800b, bshift = 15, v = x;
        do {
            if (v >= (temp = (y << 1)+b << bshift--)) {
                y += b;
                v -= temp;
            }
        } while ((b >>= 1) > 0);
        assert (long)y * y <= x && (long)(y+1)*(y+1) > x;
        return y;
    }
}
