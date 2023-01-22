
package com.docsconsole.tutorials.jpa.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR1")
@Getter
@Setter
@AllArgsConstructor
public class Author {

	public Author() {
	}

	public Author(String authorName) {
		this.authorName = authorName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHOR_ID")
	private long authorId;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@OneToMany(mappedBy="author")
	List<Book> books;





}
