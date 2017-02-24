package test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.IspitnaPrijava;

public class Test {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		IspitnaPrijava prijava = mapper.readValue(new File("prijava.json"), IspitnaPrijava.class);
		
		System.out.println(prijava.getStudent().getIme());
		
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String jsonString = mapper.writeValueAsString(prijava);
		System.out.println(jsonString);
	}

}
