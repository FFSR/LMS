package com.web.lms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("serial")
public class MyJsonMapper extends ObjectMapper {
	public MyJsonMapper() {
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
}