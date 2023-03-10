package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.beans.URL;
import com.masai.exception.URLExpiredException;
import com.masai.exception.URLInvalidException;
import com.masai.services.URLService;

@RestController
public class MainController {

	@Autowired
	private URLService urlService;
	
	@PostMapping("/short-url/create")
	public ResponseEntity<URL> createURL(@RequestBody URL url){
		
		URL crURL = urlService.createURL(url);
		
		return new ResponseEntity<URL>(crURL, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/url/:short_url/{id}/{short_url}")
	public ResponseEntity<URL> getURL(@PathVariable("id")Integer id, @PathVariable("short_url") String short_url) throws URLExpiredException, URLInvalidException{
		
		URL url = urlService.getURL(id, short_url);
		
		return new ResponseEntity<URL>(url, HttpStatus.OK);
		
	}
	
}
