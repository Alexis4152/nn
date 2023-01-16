package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Repository.IAspirantesRepository;

import com.mx.mex.Services.IAspirantes;

@Service
public class AspirantesServiceImpl implements IAspirantes{

	@Autowired
	private IAspirantesRepository aspirantesRepo;

	
	@Override
	public List<Aspirantes> getAspirantes() {
		return aspirantesRepo.getAspirantes();
	}

	@Override
	public String insertAspirantes(Aspirantes nuevoAspirante) {
		Integer respuesta = aspirantesRepo.insertAspirantes(nuevoAspirante);
		
		String respuestaInsert;
		
		if(respuesta==0) 
			respuestaInsert="�No se insert� correctamente!";
		
		else 
			respuestaInsert="�Se insert� correctamente!";
		
	
		return respuestaInsert;
	}

	@Override
	public String updateAspirantes(Aspirantes aspirante) {
		Integer respuesta =aspirantesRepo.updateAspirantes(aspirante);
		
		if(respuesta==0)
			return "�No se actualiz�!";
		else
			return "�Si se actualiz�";
	
	}

	@Override
	public String deleteAspirantes(Aspirantes aspirante) {
        Integer respuesta =aspirantesRepo.deleteAspirantes(aspirante);
		
        System.out.println("ddde: "+respuesta);
        
         String respuestaInsert;
		
		if(respuesta==0) 
			respuestaInsert="�No se elimin� correctamente!";
		
		else 
			respuestaInsert="�Se elimin� correctamente!";
		System.out.println("RFESPU: "+respuestaInsert);
	
		return respuestaInsert;
	}

	@Override
	public Aspirantes getAspiranteById(Aspirantes aspirante) {
		return aspirantesRepo.getAspiranteById(aspirante);
	}

}
