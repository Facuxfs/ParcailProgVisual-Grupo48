package ar.edu.unju.fi.html.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.servicee.ICandidatosService;
import ar.edu.unju.fi.html.util.listaCandidatos;

@Service("CandidatosServiceImp")
public class ICandidatoImp implements ICandidatosService {
	
	@Autowired
	private listaCandidatos listacandidatos;

	@Override
	public Candidato getCandidato() {
		// TODO Auto-generated method stub
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		return listacandidatos.getListaCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		for(Candidato cand : listacandidatos.getListaCandidatos()) {
			if(cand.getCodigo() == candidato.getCodigo()) {	
				cand.setNombre(candidato.getNombre());
				cand.setGeneroMusical(candidato.getGeneroMusical());
			}
		}

	}

	@Override
	public void eliminarCandidato(int codigo) {
		int eliminar = 0;
		for(Candidato cand : listacandidatos.getListaCandidatos()) {
			if(cand.getCodigo() == codigo) {
				eliminar = listacandidatos.getListaCandidatos().indexOf(cand);
			}
		}
		listacandidatos.getListaCandidatos().remove(eliminar);
	}

	@Override
	public listaCandidatos getListaCandidatos() {
		// TODO Auto-generated method stub
		return listacandidatos;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		Optional<Candidato> candidato = listacandidatos.getListaCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return candidato.get();
	}

}
