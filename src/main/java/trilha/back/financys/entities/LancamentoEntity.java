package trilha.back.financys.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
	private Long categoryId;
	private String name;
	private String description;
	private String amount;
	private String date;
	private String type;
	private boolean paid;




}