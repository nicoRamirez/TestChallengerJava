package alkemy.challenge.Challenge.Alkemy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;
    /*
     * mala practica: no realizar los getters y setters.
     * mala practica: no general los contructores por parametros y sin parametros.
     */
    private String author;

    private int edition;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;
/*---------------------------------------------------------------------------------------------------*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Book(Long id, @NotEmpty String title, String author, int edition, double price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.price = price;
		this.category = category;
	}

	public Book() {
		super();
	}
    
    
}
