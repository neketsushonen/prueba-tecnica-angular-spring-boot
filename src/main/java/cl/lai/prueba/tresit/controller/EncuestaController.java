package cl.lai.prueba.tresit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cl.lai.prueba.tresit.dto.AbstractResponseDto;
import cl.lai.prueba.tresit.service.EncuestaService;
import cl.lai.prueba.tresit.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EncuestaController {

    @Autowired
    private EncuestaService service;
    
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @RequestMapping(value = "/encuesta", method = RequestMethod.POST)
    public ResponseEntity<AbstractResponseDto> agregarEcuestas(  @RequestParam(required = true, name = "id") final Integer id, @RequestParam(required = true, name = "correo") final String correo){
        try{
            this.service.addEncuesta(id, correo);
            return ResponseUtil.success().message("Encuesta agregada exitosamente").send(HttpStatus.OK);
        }catch(RuntimeException e){
            
            return ResponseUtil.error().message(e.getMessage()).send(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
    }
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @RequestMapping(value = "/encuesta", method = RequestMethod.GET)
    public ResponseEntity<AbstractResponseDto> obtenerEncuestas( ){
        return ResponseUtil.success().body(this.service.getEncuestas()).message("Encuestas obtenidas exitosamente").send(HttpStatus.OK);
    }
    
    
}
