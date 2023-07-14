package com.URL.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.URL.model.UrlModel;
import java.util.List;
import java.util.Optional;



@Repository
public interface UrlRepository extends JpaRepository<UrlModel, Long>{
	
  UrlModel findByOriginalUrl(String originalUrl);
//  boolean findByShortUrl(String shortUrl);
  List<UrlModel> findByShortUrl(String shortUrl);

}
