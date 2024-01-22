/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.extensions.web.HttpCallXmlLoader;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.HttpCall;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.HttpCall_max;

public class HttpCallXmlLoaderTest extends XmlLoaderTest {
    public HttpCallXmlLoaderTest() {
        super(new HttpCallXmlLoader());
    }

    @Test
    public void testLoader() throws Exception {
        assertExpectation("classpath:/HttpCall_min.xml", HttpCall);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/HttpCall_max.xml", HttpCall_max);
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
