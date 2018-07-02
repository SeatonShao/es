package com.shendu.es;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shendu.es.utils.OCRHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void ocr() {
		try {
			OCRHelper.recognizeText("d:\\tesseract", "C:\\Users\\bluem\\Pictures");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
