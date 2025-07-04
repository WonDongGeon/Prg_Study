package school2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student implements Serializable {
	@Id
	@SequenceGenerator
	(name = "student_seq",sequenceName ="student_seq",allocationSize = 1 )
	@GeneratedValue
	(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	@Column(name="sid", unique = true, nullable = false, length = 8)
	private String sid;

	private String name;

	private String hp;

}