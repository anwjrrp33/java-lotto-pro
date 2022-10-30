package step2;

public class SplitNumber {

    public static final int ZERO = 0;

    private final int splitNumber;

    public SplitNumber(String splitNumber) {
        this.splitNumber = validation(splitNumber);
    }

    private int validation(final String splitNumber) {
        checkNegative(splitNumber);
        return Integer.parseInt(splitNumber);
    }

    private void checkNegative(final String splitNumber) {
        if (Integer.parseInt(splitNumber) < ZERO) {
            throw new IllegalArgumentException("덧셈에 음수는 허용되지 않습니다.");
        }
    }

    public int getSplitNumber() {
        return splitNumber;
    }
}
