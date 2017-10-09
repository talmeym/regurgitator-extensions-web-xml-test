/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.CreateFileResponseXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class CreateFileResponseXmlLoaderTest extends XmlLoaderTest {
    public CreateFileResponseXmlLoaderTest() {
        super(new CreateFileResponseXmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/CreateFileResponse.xml", "com.emarte.regurgitator.extensions.web.CreateFileResponse:['create-file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],null]");
    }

    @Test
    public void testPrefixed() throws Exception {
        assertExpectation("classpath:/CreateFileResponse_prefixed.xml", "com.emarte.regurgitator.extensions.web.CreateFileResponse:['create-file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],'/assets']");
    }

    @Test
    public void testFullLoadXml() throws RegurgitatorException {
        loadFile("classpath:/CreateFileResponse_fullLoad.xml");
    }
}
