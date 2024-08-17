package com.pet.repository;

import java.io.IOException;
import org.springframework.stereotype.Repository;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pet.config.FirebaseConfig;
import com.pet.model.Pet;

@Repository
public class PetRepository  {
	
	private DatabaseReference referencia;
	
	public PetRepository(FirebaseConfig firebaseConfig) throws IOException {
		FirebaseApp app = firebaseConfig.inicializando();
        this.referencia = FirebaseDatabase.getInstance(app).getReference("pets");
	}

	public void salvar(Pet pet) {
		this.referencia.child(pet.getCpf()).setValueAsync(pet);
	}
	
	public void deletarPorCpf(String cpf) {
		this.referencia.child(cpf).removeValueAsync();
    }
	
}
