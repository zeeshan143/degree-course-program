package zee.cms.entity;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="title", unique=true)
	private String title;

	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="degree_id")
	private Degree degree;

	public Course() { }
	public Course(String title) { this.title = title; }

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public Degree getDegree() { return degree; }
	public void setDegree(Degree degree) { this.degree = degree; }

	@Override
	public String toString() { return "Course [id=" + id + ", title=" + title + "]"; }

}
