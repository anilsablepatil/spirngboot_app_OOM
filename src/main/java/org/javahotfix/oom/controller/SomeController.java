package org.javahotfix.oom.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.javahotfix.oom.config.SomeSingletonInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/somecontroller")
public class SomeController {
	
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> putMyImageToList(
			@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("File Upload Started");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(file.getInputStream(), baos);
		SomeSingletonInstance.getInstance().addObjectToList(baos);
		
		System.out.println("File Upload Completed");
		return new ResponseEntity<String>("File Uploaded", HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<String> getCount() {
		return new ResponseEntity<String>(
				"Current Count is : " + SomeSingletonInstance.getInstance().getCount(),
				HttpStatus.OK);
	}
}
