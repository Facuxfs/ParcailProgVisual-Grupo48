package ar.edu.unju.fi.html.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.html.model.Candidato;


@Component
public class listaCandidatos {

	public ArrayList<Candidato> listaCandidatos ;
	
	public listaCandidatos(){
		listaCandidatos = new ArrayList<Candidato>();
		Candidato unCandidato1 = new Candidato(40001, "Bud bunny", "Urbano Latino","budbunny.jpg" ,"Benito Antonio Martínez Ocasio, mejor conocido como Bad Bunny, es un rapero, cantante y compositor puertorriqueño.​​ Su estilo de música es generalmente definido como trap latino y reguetón, pero también ha interpretado otros géneros como rock, kizomba y soul." , 0);
		Candidato unCandidato2 = new Candidato(40002, "Emilia", "Urbano Latino", "emilia.jpg", "María Emilia Mernes Rueda, conocida como Emilia Mernes o simplemente Emilia, es una cantante, compositora, modelo y actriz argentina. Se hizo conocida por haber formado parte del grupo uruguayo Rombai.​Comenzó su carrera como cantante solista en 2019, con el lanzamiento de su primer sencillo", 0);
		Candidato unCandidato3 = new Candidato(40003, "Lit Killah", "Urbano Latino", "lit.jpg", "Mauro Román Monzón Herrera, conocido artísticamente como Lit Killah, es un cantante, rapero, compositor y streamer argentino.​", 0);
		Candidato unCandidato4 = new Candidato(40004, "Ninguno", "ninguno", "anonimo.jpg","sin informacion disponible", 0);
		
		listaCandidatos.add(unCandidato1);
		listaCandidatos.add(unCandidato2);
		listaCandidatos.add(unCandidato3);
		listaCandidatos.add(unCandidato4);
	}

	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}

	public void setListaCandidatos(ArrayList<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
	
	
}
