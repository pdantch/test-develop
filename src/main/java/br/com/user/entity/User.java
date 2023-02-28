package br.com.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe representa um usuário do sistema.
 */
 
@Table // Especifica que a classe está mapeada para uma tabela no banco de dados (usando JPA)
@Entity // Indica que a classe é uma entidade (usando JPA)
@Data // Adiciona getters, setters, toString(), equals() e hashCode() automaticamente (usando Lombok)
@Getter // Adiciona getters automaticamente (usando Lombok)
@Setter // Adiciona setters automaticamente (usando Lombok)
@NoArgsConstructor // Adiciona um construtor sem argumentos (usando Lombok)
public class User implements Serializable {

	// Define um número de versão para serialização/desserialização da classe
	private static final long serialVersionUID = 1L;

	@Id // Indica que o campo é uma chave primária (usando JPA)
	@GeneratedValue(strategy = GenerationType.AUTO) // Especifica como a chave primária é gerada automaticamente (usando JPA)
	private Long id; // Campo que armazena o ID do usuário

	@Column(name = "code", nullable = false) // Especifica o nome da coluna no banco de dados e que ela não pode ser nula (usando JPA)
	private String code; // Campo que armazena o código do usuário

	@Column(name = "name", nullable = false) // Especifica o nome da coluna no banco de dados e que ela não pode ser nula (usando JPA)
	private String name; // Campo que armazena o nome do usuário

	@Column(name = "birthday", nullable = false) // Especifica o nome da coluna no banco de dados e que ela não pode ser nula (usando JPA)
	private String birthday; // Campo que armazena a data de aniversário do usuário

	@Lob // Indica que o campo é um objeto grande (usando JPA)
	@Column(name = "photography", columnDefinition = "LONGBLOB", nullable = false) // Especifica o nome da coluna no banco de dados, que ela não pode ser nula e sua definição de coluna (usando JPA)
	private byte[] photography; // Campo que armazena a fotografia do usuário (como um array de bytes)

	public User(Long id, String code, String name, String birthday, byte[] photography) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.birthday = birthday;
		this.photography = photography;
	}

}
