package alkemy.challenge.Challenge.Alkemy.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	/*
	 * mala practica: no se crea los getters y setters 
	  tampoco se crea el contructor
	 */
	
    private String menssage;

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

	public Message(String menssage) {
		super();
		this.menssage = menssage;
	}

	public Message() {
		super();
	}

}
