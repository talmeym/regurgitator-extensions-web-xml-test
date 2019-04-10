/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.CreateFileResponseXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.CreateFileResponse;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.CreateFileResponse_prefixed;

public class CreateFileResponseXmlLoaderTest extends XmlLoaderTest {
    public CreateFileResponseXmlLoaderTest() {
        super(new CreateFileResponseXmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/CreateFileResponse.xml", CreateFileResponse);
    }

    @Test
    public void testPrefixed() throws Exception {
        assertExpectation("classpath:/CreateFileResponse_prefixed.xml", CreateFileResponse_prefixed);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/CreateFileResponse_fullLoad.xml");
    }
}
