package com.URL.urlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.URL.model.UrlModel;
import com.URL.urlService.UrlService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Api")
public class UrlController {
	@Autowired
	private UrlService urlService;
	
	@PostMapping("/url")
	UrlModel addUrl(@RequestBody UrlModel um)
	{
		String originalUrl=um.getOriginalUrl();
		System.out.println(originalUrl);
		String url=urlService.getUrl(originalUrl);
		UrlModel response=new UrlModel();
		if(url!=null)
		{
			response.setShortUrl("bit.ly/"+url);
			return response;
		}
		else
		{
			response.setShortUrl("bit.ly/"+urlService.addUrl(originalUrl));
			return response;
			
		}
	}

	

}
