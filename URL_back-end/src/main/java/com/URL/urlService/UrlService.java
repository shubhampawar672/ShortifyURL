package com.URL.urlService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.URL.dao.UrlRepository;
import com.URL.model.UrlModel;

@Service
public class UrlService {
 @Autowired
 private UrlRepository urlRepository;
	
 public String addUrl(String originalUrl)
	{
	    String shortUrl=getShortUrl(originalUrl);
	    System.out.println(shortUrl);
	 	UrlModel um=new UrlModel(shortUrl,originalUrl);		
	 	urlRepository.save(um);
	 	return shortUrl;
	}
 
 public String getShortUrl(String originalUrl)
 {
	 StringBuilder shortUrl=new StringBuilder();
	 String source="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
	 Random random=new Random();
	 for(int i=0;i<7;i++)
	 {
		 int idx=random.nextInt(71);
		 shortUrl.append(source.charAt(idx));
	 }
	 if(checkDuplicate(shortUrl.toString())==false)
	 {
		 return shortUrl.toString();
	 }
	 else
	 {
		 System.out.println("Duplicate found -> "+shortUrl.toString());
		 return getShortUrl(originalUrl);
	 }		 
 }
 
 public boolean checkDuplicate(String shortUrl)
 {
	 List<UrlModel>ul=new ArrayList<>();
	 
	 ul= urlRepository.findByShortUrl(shortUrl);
	 if(ul.size()==0)
		 return false;
	 else
		 return true;
	  
 }
 public String getUrl(String origialUrl)
 {
	 UrlModel u=new UrlModel();
	 u=urlRepository.findByOriginalUrl(origialUrl);
	 if(u==null)
		 return null;
	 else
	 return u.getShortUrl();
 }
}
