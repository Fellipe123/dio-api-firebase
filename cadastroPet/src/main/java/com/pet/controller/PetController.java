package com.pet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.Pet;
import com.pet.repository.PetRepository;

@RestController
@RequestMapping("/api")
public class PetController {
	
	private final PetRepository petRepository;
	
	public PetController(PetRepository petRepository) {
       this.petRepository = petRepository;
    }
	
	@PostMapping
	public ResponseEntity<?> adicionarPet(@RequestBody Pet pet) {
		try {
            petRepository.salvar(pet);
            return ResponseEntity.ok("Pet salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao salvar o Pet");
        }
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> deletarIdPet(@PathVariable String cpf) {
		try {
            petRepository.deletarPorCpf(cpf);
            return ResponseEntity.ok("Deletado com Sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao deletar o Pet");
        }
	}

}
