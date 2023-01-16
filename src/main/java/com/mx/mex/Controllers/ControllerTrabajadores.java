package com.mx.mex.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mx.mex.Dto.Trabajadores;
import com.mx.mex.Services.ITrabajadores;

@Controller
@RequestMapping("Trabajadores")
public class ControllerTrabajadores {

	
	@Autowired  //INYECCI�N DE DEPENDENCIAS 
	private ITrabajadores iTrabajadores;
	// get UNICAMENTE RETORNA VALORES
	// POST RECIBE Y RETORNA VALORES
	// PUT RECIBE Y RETORNA UNA RESPUESTA
	// DELETE RECIBE Y RETORNA UNA RESPUESTA
	
	
	//JSON :
	
/*	 {
 *  	idTrabajador: 1
		nombre :  "Alexis"
		edad :  1
		salarion: 12.12
	 	fechaIngreso 12/12/12
	 }
*/
	
	/* CODIGOS DE RESPUESTA HTTP
	 * 200 = PETICI�N EXITOSA
	 * 202 = PETICI�N REALIZADA CORRECTAMENTE
	 * 404 = NO SE ENCONTRO EL SERVICIO
	 * 500 = EXCEPCI�N INTERNA (SE REVISA EN EL CODIGO)
	 * 503 = PERMISOS DENEGADOS (SE REVISA EN EL CODIGO)
	 * 404 = BAD REQUEST (PETICI�N INCORRECTA) (QUIERE DECIR QUE TE EQUIVOCASTE EN EL FORMATO DE LA PETICI�N, A LO MEJOR MANDASTE
	 * UNA PETICI�N DE TIPO GET, CUANDO TU SERVICIO ES DE TIPO POST)
	 * 
	 * */
	
	
	@ResponseBody  // NOS PERMITE RETORNAR UNICAMENTE VALORES
	@RequestMapping(value="/getTrabajadores", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity <  List<Trabajadores> >  getTrabajadores() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Trabajadores> lista = iTrabajadores.getTrabjadores();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <List<Trabajadores>> (lista, httpHeaders, HttpStatus.OK);	
	}
	
	@ResponseBody  // NOS PERMITE RETORNAR UNICAMENTE VALORES
	@RequestMapping(value="/insertTrabajadores", method=RequestMethod.POST,produces="application/json")
	public ResponseEntity < String >  insertTrabajadores(@RequestBody Trabajadores nuevoTrabajador) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = iTrabajadores.insertTrabajadores(nuevoTrabajador);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	 //CODIGO 202
	}
	
}
