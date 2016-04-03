package com.mvc.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mvc.model.Person;
import com.mvc.model.User;

public class MyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] values = text.split(",");
		Person person = new Person();
		person.setName(values[0]);
		try {
			person.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(values[1]));//格式化字符串并解析成日期类型
		} catch (ParseException e) {
			e.printStackTrace();
		}
		person.setSalary(Long.valueOf(values[2].replace("k", "000")));//转换为工资格式
	    setValue(person);//调用setValue来将我们的Person对象设置为编辑器的属性值
		super.setAsText(text);
	}
}
