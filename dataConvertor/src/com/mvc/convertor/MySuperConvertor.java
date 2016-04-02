package com.mvc.convertor;

import org.springframework.core.convert.converter.Converter;

import com.mvc.model.SuperUser;
import com.mvc.model.User;

public class MySuperConvertor implements Converter<String, SuperUser>{

	@Override
	public SuperUser convert(String source) {
		String[] values = source.split(",");
		Integer id = Integer.valueOf(values[0]);
		SuperUser superUser = new SuperUser(values[3],  new User(id,values[1],values[2]));
		return superUser;
	}
}
