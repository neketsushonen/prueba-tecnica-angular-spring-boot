package cl.lai.prueba.tresit;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import static java.util.Map.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class EncuestaControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/encuesta").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message", is("Encuestas obtenidas exitosamente")))
				.andExpect(jsonPath("$.data", is( empty()) ));

 	}

	 @Test
	 public void test2() throws Exception {
		String idTipo="1";
		String correo="chunhaulai@gmail.com";

		 mvc.perform(MockMvcRequestBuilders.post("/encuesta").
		 	param("correo",correo).
			param("id",idTipo).
			accept(MediaType.APPLICATION_JSON))
				 .andExpect(status().isOk())
				 .andExpect(jsonPath("$.message", is("Encuesta agregada exitosamente")));
 
	  }

	  @Test
	 public void test3() throws Exception {
		String idTipo="1";
		String correo="fdsfdsfds";

		 mvc.perform(MockMvcRequestBuilders.post("/encuesta").
		 	param("correo",correo).
			param("id",idTipo).
			accept(MediaType.APPLICATION_JSON))
				 .andExpect(status().isInternalServerError() )
				 .andExpect(jsonPath("$.message", is("Correo introducido no es válido")));
 
	  }

	  @Test
	  public void test4() throws Exception {
		 String idTipo="1";
		 String correo="chunhaulai@gmail.com";
 
		  mvc.perform(MockMvcRequestBuilders.post("/encuesta").
			  param("correo",correo).
			 param("id",idTipo).
			 accept(MediaType.APPLICATION_JSON))
				  .andExpect(status().isInternalServerError() )
				  .andExpect(jsonPath("$.message", is("El Correo introducido ["+correo+"] ya ha respondido la encuesta, favor introducir otro correo")));
  
	   }
}