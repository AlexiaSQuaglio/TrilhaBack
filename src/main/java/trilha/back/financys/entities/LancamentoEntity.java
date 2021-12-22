package trilha.back.financys.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class LancamentoEntity implements Serializable, Comparable<LancamentoEntity>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long categoryId;
	private String name;
	private String description;
	private String amount;
	private Date date;
	private String type;
	private boolean paid;

	public LancamentoEntity() { }
	
	public LancamentoEntity(Long id, Long categoryId, String name, String description, String amount,
							Date date, String type, boolean paid) {
			this.id = id;
			this.categoryId = categoryId; 
			this.name = name;
			this.description = description;
			this.amount = amount;
			this.date = date;
			this.type = type;
			this.paid = paid;
		}
	@Override
	public int compareTo(LancamentoEntity outroLancamento) {
		return this.date.compareTo(outroLancamento.getDate());
	}
		

		public boolean isPaid() {
			return paid;
		}

		public void setPaid(boolean paid) {
			this.paid = paid;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public Long getCategoryId () {
			return categoryId;
		}
		
		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
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

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
		
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}




}