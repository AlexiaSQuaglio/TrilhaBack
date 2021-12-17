package trilha.back.financys.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	private String description;
	
	public Categoria(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		
	}
	
	public Categoria() { }

	public long getId() {
		return id;
}

	public void setId(long id) {
		this.id = id;
}
	public String getName() {
		return name;
}

	public void setName(String name) {
		this.name = name;
}
	public String getDescription() {
		return description;
}

	public void setDescription(String description) {
		this.description = description;
}
	
}
