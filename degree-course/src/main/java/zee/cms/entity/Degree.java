package zee.cms.entity;

import javax.persistence.*;

@Entity
@Table(name="degree")
public class Degree{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name", unique=true)
	private String name;

	public Degree() { }
	public Degree(String name) { this.name = name; }

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Override
	public String toString() { return "Degree [id=" + id + ", name=" + name + "]"; }
	
}
