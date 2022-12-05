package cl.lai.prueba.tresit.util;

import cl.lai.prueba.tresit.dto.ErrorResponseDto;
import cl.lai.prueba.tresit.dto.SuccessResponseDto;

/**
 * Clase utilitaria que realiza la instanciación del objeto SuccessResponseDto y ErrorResponseDto
 * @author chunhaulai
 *
 */
public class ResponseUtil {

	public static SuccessResponseDto<Object> success(){
		return new SuccessResponseDto<Object>();
	}
	
	public static ErrorResponseDto error(){
		return new ErrorResponseDto();
	}
}
