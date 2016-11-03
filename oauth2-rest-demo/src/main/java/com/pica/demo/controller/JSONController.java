package com.pica.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pica.demo.model.Message;

@Controller
@RequestMapping("/test")
public class JSONController {

	@RequestMapping(value="{text}", method = RequestMethod.GET)
	public @ResponseBody Message getMessageInJSON(@PathVariable String text) {

		Message message = new Message();
		message.setText(text);
		
		return message;
	}
}
