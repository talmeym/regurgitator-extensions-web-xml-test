package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.QueryParamProcessorXmlLoader;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class QueryParamProcessorXmlLoaderTest extends XmlBaseTest {
	private final QueryParamProcessorXmlLoader toTest = new QueryParamProcessorXmlLoader();

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/QueryParamProcessor.xml", "com.emarte.regurgitator.extensions.web.QueryParamProcessor:['value']");
	}

	private void assertExpectation(String filePath, String expected) throws RegurgitatorException, SAXException, DocumentException, IOException {
		assertEquals(expected, toTest.load(getElement(filePath), new HashSet<Object>()).toString());
	}
}
