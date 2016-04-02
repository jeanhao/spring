package com.mvc.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.mvc.model.User;

public class MyConvertorFactory implements ConverterFactory<String, User>{

	@Override
	public <T extends User> Converter<String, T> getConverter(
			Class<T> targetType) {
		if(targetType == User.class){
			return  (Converter<String, T>) new MyConvertor();
		}else{
			return (Converter<String, T>) new MySuperConvertor();
		}
	}

}
