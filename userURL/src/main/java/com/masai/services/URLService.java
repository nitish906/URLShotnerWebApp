package com.masai.services;

import com.masai.beans.URL;
import com.masai.exception.URLExpiredException;
import com.masai.exception.URLInvalidException;

public interface URLService {

	public URL createURL(URL url);
	
	public URL getURL(Integer id, String shortURL) throws URLExpiredException, URLInvalidException;
	
}
