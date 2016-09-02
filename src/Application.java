import utils.AlgorithmUtils;

import static constants.ApplicationConstants.CODE_SIZE;
import static constants.ApplicationConstants.INPUT_PREFIX;

/**
 * Created by Alexadner Dadukin on 02.09.2016.
 */

public class Application {

    public static void main(String[] args) {

        AlgorithmUtils
                .getAlgorithm(System.out::println)
                .start(INPUT_PREFIX, CODE_SIZE);
    }


}
