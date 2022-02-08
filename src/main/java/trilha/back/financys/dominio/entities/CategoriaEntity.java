package trilha.back.financys.dominio.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tab_categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaEntity implements Serializable {
	private static final Long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty(message= "O nome nao pode ser nulo")
	@Size(min = 3, max = 15, message = "o nome deve ter no minimo{min} e o maximo{max} de caracter")
	private String name;

	@NotEmpty(message= "A descricao nao pode ser nulo")
	@Size(min = 15, max = 30, message = "o nome deve ter no minimo{min} e o maximo{max} de caracter")
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<LancamentoEntity> lancamentoEntity;
}

