package br.com.seniorSistemas.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.seniorSistemas.entities.Orders;

public class WriteJSon {

	public static void printJson(Orders order) {

		ObjectMapper Obj = new ObjectMapper();

		try {

			// get Oraganisation object as a json string
			String jsonStr = Obj.writeValueAsString(order);

			// Displaying JSON String
			System.out.println(jsonStr);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
