package com.mvc.convertor;

import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.Converter;

import com.mvc.model.User;

public class MyGenricConvertor implements ConditionalGenericConverter{

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType,
			TypeDescriptor targetType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return false;
	}

}
