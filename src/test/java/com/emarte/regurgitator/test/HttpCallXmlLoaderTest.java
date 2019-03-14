/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.HttpCallXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class HttpCallXmlLoaderTest extends XmlLoaderTest {
    public HttpCallXmlLoaderTest() {
        super(new HttpCallXmlLoader());
    }

    @Test
    public void testMin() throws Exception {
        assertExpectation("classpath:/HttpCall_min.xml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:[com.emarte.regurgitator.extensions.web.HttpClientWrapper:['http','something.com',1234,null,null]],[]]");
    }

    @Test
    public void testMax() throws Exception {
        assertExpectation("classpath:/HttpCall_max.xml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:[com.emarte.regurgitator.extensions.web.HttpClientWrapper:['http','something.com',1234,'username','password']],[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2']]]");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingUsername() throws Exception {
        loadFromFile("classpath:/HttpCall_missingUsername.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingPassword() throws Exception {
        loadFromFile("classpath:/HttpCall_missingPassword.xml");
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/HttpCall_min.xml");
    }
}
