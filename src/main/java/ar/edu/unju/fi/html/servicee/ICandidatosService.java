package ar.edu.unju.fi.html.servicee;



import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.util.listaCandidatos;

public interface ICandidatosService {
	
	public Candidato getCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public boolean existeCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public listaCandidatos getListaCandidatos();
	public Candidato buscarCandidato(int codigo);
	public void contarVotoCandidato(Candidato candidato);
	public float calcularPorcentaje(Candidato candidato);

}
