package com.framework.uitests;

import com.testframework.StringUtils;
import org.junit.jupiter.api.Test;

public class AnotherUITest extends BaseTestClass {


    @Test
    void dummyTest(){

        String randomString = StringUtils.generateRandomString(10);

        // use the string somehow
    }
}
