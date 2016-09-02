package utils;

/**
 * Created by Alexadner Dadukin on 02.09.2016.
 */

import com.sun.istack.internal.NotNull;
import events.OnCortegeFormedListener;

import static constants.AlgorithmConstants.ONE_SIGN;
import static constants.AlgorithmConstants.ZERO_SIGN;

public class AlgorithmUtils {

    private OnCortegeFormedListener listener;

    private AlgorithmUtils(@NotNull OnCortegeFormedListener listener) {
        this.listener = listener;
    }

    public static AlgorithmUtils getAlgorithm(@NotNull OnCortegeFormedListener listener) {
        return new AlgorithmUtils(listener);
    }

    public void start(String prefix, int n) {
        deepDirect(prefix, n);
    }

    private void deepDirect(String prefix, int n) {
        if (n == 0) {
            listener.onFormed(prefix);
            return;
        }

        deepDirect(prefix.concat(ZERO_SIGN), n - 1);
        deepInverse(prefix.concat(ONE_SIGN), n - 1);
    }

    private void deepInverse(String prefix, int n) {
        if (n == 0) {
            listener.onFormed(prefix);
            return;
        }

        deepDirect(prefix.concat(ONE_SIGN), n - 1);
        deepInverse(prefix.concat(ZERO_SIGN), n - 1);
    }
}