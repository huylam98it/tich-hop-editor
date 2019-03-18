package com.huylam98it.tichhoptexteditor.controller;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;

	@GetMapping(value = "/")
	public String homePage() throws FileNotFoundException {
		File fi=new File(context.getRealPath("/imageupload/imagesss"));
		if(fi.exists()==false) {
			fi.mkdirs();
		}
		File file = ResourceUtils.getFile("classpath:static/imageupload/images");
		System.out.println(file.exists());
		for(File f:file.listFiles()) {
			System.out.println(f.getName());
		}
		return "home";
	}
}
