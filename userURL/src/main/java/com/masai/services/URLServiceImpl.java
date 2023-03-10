package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.beans.URL;
import com.masai.exception.URLExpiredException;
import com.masai.exception.URLInvalidException;
import com.masai.repo.URLRepo;

@Service
public class URLServiceImpl implements URLService{

	@Autowired
	private URLRepo urlRepo;
	
	@Override
	public URL createURL(URL url) {
		return urlRepo.save(url);
	}

	@Override
	public URL getURL(Integer id, String shortURL) throws URLExpiredException, URLInvalidException {
		
		Optional<URL> op = urlRepo.findById(id);
		if(op.isPresent()) {
			URL url = op.get();
			if(DateChecker.checkDate(url.getExpiry())) {
				return url;
			}else {
				throw new URLExpiredException("URL is expired");
			}
		}else {
			throw new URLInvalidException("URL is invalid");
		}
		
	}

}
