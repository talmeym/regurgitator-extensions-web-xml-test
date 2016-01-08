package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.QueryParamProcessorXmlLoader;
import org.junit.Test;

public class QueryParamProcessorXmlLoaderTest extends XmlLoaderTest {
	public QueryParamProcessorXmlLoaderTest() {
		super(new QueryParamProcessorXmlLoader());
	}

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/QueryParamProcessor.xml", "com.emarte.regurgitator.extensions.web.QueryParamProcessor:['value']");
	}
}
