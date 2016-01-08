package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.HttpCallXmlLoader;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class HttpCallXmlLoaderTest extends XmlLoaderTest {
	public HttpCallXmlLoaderTest() {
		super(new HttpCallXmlLoader());
	}

	@Test
	public void testMin() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall_min.xml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234,null,null],null]");
	}

	@Test
	public void testMax() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall_max.xml", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234,'username','password'],null]");
	}

	@Test(expected = RegurgitatorException.class)
	public void testMissingUsername() throws DocumentException, SAXException, IOException, RegurgitatorException {
		loadFromFile("classpath:/HttpCall_missingUsername.xml");
	}

	@Test(expected = RegurgitatorException.class)
	public void testMissingPassword() throws DocumentException, SAXException, IOException, RegurgitatorException {
		loadFromFile("classpath:/HttpCall_missingPassword.xml");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		loadFile("classpath:/HttpCall_min.xml");
	}
}
