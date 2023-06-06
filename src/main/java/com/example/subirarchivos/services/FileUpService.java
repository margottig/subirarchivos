package com.example.subirarchivos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.subirarchivos.models.FileUp;
import com.example.subirarchivos.repositories.FileUpRepo;

@Service
public class FileUpService {
	
	@Autowired
	private FileUpRepo fileupRepo;
	
	public String subirBD(MultipartFile archivo) {
		FileUp nuevoArchivo = FileUp.builder()
				.nombre(archivo.getOriginalFilename())
				.filetype(archivo.getContentType())
				.rutaArchivo("/src/main/resources/static/images/"+archivo.getOriginalFilename())
				.build();
		
		 fileupRepo.save(nuevoArchivo);
		 
		 if(nuevoArchivo != null) {
			 System.out.println(archivo.getOriginalFilename());
			 return " Archivo subido exitosamente "+ archivo.getOriginalFilename();
		 }

		return null;
		
	}

}
