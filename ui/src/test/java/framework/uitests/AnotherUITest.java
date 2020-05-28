package framework.uitests;

import org.junit.jupiter.api.Test;
import test.framework.StringUtils;

public class AnotherUITest extends BaseTestClass {


    @Test
    void dummyTest(){

        String randomString = StringUtils.generateRandomString(10);

        // use the string somehow
    }
}
