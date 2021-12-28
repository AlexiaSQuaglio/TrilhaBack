package trilha.back.financys.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

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
	private String name;
	private String description;

}
