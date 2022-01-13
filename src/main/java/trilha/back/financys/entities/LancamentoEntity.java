package trilha.back.financys.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import trilha.back.financys.enums.TypeEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

	@NotBlank(message = "O nome nao pode ser nulo")
	@Length(min = 3, max = 45, message = "o nome deve ter no minimo{min} e o maximo{max} de caracteres")
	private String name;

	@NotBlank(message = "A descricao nao pode ser nulo")
	@Length(min = 15, max = 150, message = "a descricao deve ter no minimo{min} e o maximo{max} de caracteres")
	private String description;

	@NotNull(message = "Amount nao pode ser nulo")
	@Min(value = 0, message = "valor deve ser maior que 0")
	private double amount;

	@NotBlank(message = "A data nao pode ser nulo")
	private String date;

	@NotNull(message = "Type nao pode ser nulo ou vazio")
	@Enumerated(EnumType.STRING)
	private TypeEnum type;

	@NotNull(message = "Paid nao pode ser nulo")
	private boolean paid;

}