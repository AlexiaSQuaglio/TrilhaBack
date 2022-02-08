package trilha.back.financys.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trilha.back.financys.enums.TypeEnum;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
@Table(name = "tb_lancamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoEntity implements Serializable{
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private CategoriaEntity categoryId;

	@NotEmpty(message = "O nome nao pode ser nulo")
	@Size(min = 3, max = 45, message = "o nome deve ter no minimo 3 e o maximo 45 de caracteres")
	private String name;

	@NotEmpty(message = "A descricao nao pode ser nulo")
	@Size(min = 15, max = 150, message = "a descricao deve ter no minimo 15 e o maximo 150 de caracteres")
	private String description;

	@NotNull(message = "Amount nao pode ser nulo")
	@Min(value = 0, message = "valor deve ser maior que 0")
	private Double amount;

	@NotEmpty(message = "A data nao pode ser nulo")
	private String date;

	@NotNull(message = "Type nao pode ser nulo ou vazio")
	@Enumerated(value = EnumType.STRING)
	private TypeEnum type;

	@NotNull(message = "Paid nao pode ser nulo")
	private Boolean paid;

	@ManyToOne
	@JoinColumn(name = "categoria", referencedColumnName = "id")
	private CategoriaEntity categoria;

}