package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.HttpCallXmlLoader;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class HttpCallXmlLoaderTest extends XmlBaseTest {
	private HttpCallXmlLoader toTest = new HttpCallXmlLoader();

	@Test
	public void testMin() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall_min.xml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234],null]");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/HttpCall_min.xml");
	}

	private void assertExpectation(String filePath, String expected) throws RegurgitatorException, SAXException, DocumentException, IOException {
		assertEquals(expected, toTest.load(getElement(filePath), new HashSet<Object>()).toString());
	}
}
