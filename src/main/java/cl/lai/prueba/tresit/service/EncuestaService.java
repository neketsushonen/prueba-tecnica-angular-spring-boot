package cl.lai.prueba.tresit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EncuestaService {
    private List<Map<String, Object>> encuestas;

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)  .matcher(emailAddress)  .matches();
    }

    public EncuestaService(){
        encuestas = new ArrayList<Map<String, Object>>();
    }

    public void addEncuesta(Integer idTipo, String correo) {
        if(!patternMatches(correo, "^(.+)@(\\S+)$")) throw new RuntimeException("Correo introducido no es válido");

        Long count = encuestas.stream().filter(f->{
            String mail = String.valueOf(f.get("correo"));
            return (mail.equalsIgnoreCase(correo));
        }).count();

        if(count > 0) throw new RuntimeException("El Correo introducido ["+correo+"] ya ha respondido la encuesta, favor introducir otro correo");

        HashMap<String,Object> map = new HashMap<>();
        map.put("id", idTipo);
        map.put("correo", correo);
        this.encuestas.add(map);

    }

    public List<Map<String, Object>> getEncuestas(){
        return this.encuestas;
    } 
}
