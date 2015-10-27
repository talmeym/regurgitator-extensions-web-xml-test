package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.HttpCallThroughXmlLoader;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class HttpCallThroughXmlLoaderTest extends XmlBaseTest {
	private HttpCallThroughXmlLoader toTest = new HttpCallThroughXmlLoader();

	@Test
	public void testMin() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCallThrough_min.xml", "com.emarte.regurgitator.extensions.web.HttpCallThrough:['http-call-through-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234],null]");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/HttpCallThrough_min.xml");
	}

	private void assertExpectation(String filePath, String expected) throws RegurgitatorException, SAXException, DocumentException, IOException {
		assertEquals(expected, toTest.load(getElement(filePath), new HashSet<Object>()).toString());
	}
}
