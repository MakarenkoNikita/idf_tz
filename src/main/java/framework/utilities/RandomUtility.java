package framework.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import static structure.constant.NumberConstant.*;

public class RandomUtility {

    private RandomUtility() {
        throw new InstantiationError("Should not instantiate static class");
    }

    public static String getRandomAlphabeticString() {
        return RandomStringUtils.randomAlphabetic(MEDIUM_LINE);
    }

    public static String getRandomCorrectPassword() {
        String specialChar = RandomStringUtils.random(1, 35, 38, false, false);
        String alphaLow = RandomStringUtils.randomAlphabetic(SHORT_LINE).toLowerCase();
        String alphaUp = RandomStringUtils.randomAlphabetic(SHORT_LINE).toUpperCase();
        String numeric = RandomStringUtils.randomNumeric(SHORT_LINE);
        return alphaLow + alphaUp + numeric + specialChar;
    }
}
