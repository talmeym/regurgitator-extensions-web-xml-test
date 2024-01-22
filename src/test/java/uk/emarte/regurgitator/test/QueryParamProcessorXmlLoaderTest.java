/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.extensions.web.QueryParamProcessorXmlLoader;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.QueryParamProcessor;

public class QueryParamProcessorXmlLoaderTest extends XmlLoaderTest {
    public QueryParamProcessorXmlLoaderTest() {
        super(new QueryParamProcessorXmlLoader());
    }

    @Test
    public void testLoader() throws Exception {
        assertExpectation("classpath:/QueryParamProcessor.xml", QueryParamProcessor);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/QueryParamProcessor_fullLoad.xml");
    }
}
