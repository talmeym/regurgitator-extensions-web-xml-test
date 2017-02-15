package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.FileResponseXmlLoader;
import org.junit.Test;

public class FileResponseXmlLoaderTest extends XmlLoaderTest {
	public FileResponseXmlLoaderTest() {
		super(new FileResponseXmlLoader());
	}

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/FileResponse.xml", "com.emarte.regurgitator.extensions.web.FileResponse:['file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],null]");
	}

	@Test
	public void testPrefixed() throws Exception {
		assertExpectation("classpath:/FileResponse_prefixed.xml", "com.emarte.regurgitator.extensions.web.FileResponse:['file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],'/assets']");
	}
}
