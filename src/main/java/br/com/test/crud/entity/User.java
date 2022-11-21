package br.com.test.crud.entity;

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

@Data
@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "birthday", nullable = false)
	private String birthday;

	@Lob
	@Column(name = "photography", columnDefinition = "LONGBLOB", nullable = false)
	private byte[] photography;

	public User(Long id, String code, String name, String birthday, byte[] photography) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.birthday = birthday;
		this.photography = photography;
	}

}
