package com.codingdojo.EventFree.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	 	@Size(min=2,max=20,message="FIRST LETTER MUST BE CAPITALIZED!")
	 	private String FirstName;
	 	private String LastName;
	 	private int Birthday;
	    @Size(min=2,max=20)
	    private String email;
	    private String password;
	    
	    @Transient
	    private boolean duplicate;
	    
	    @Transient
	    private String passwordConfirmation;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
	    private List<Event> created_events;
	
	    public User() {
	    }

		public User(@Size(min = 2, max = 20, message = "FIRST LETTER MUST BE CAPITALIZED!") String firstName,
				String lastName, int birthday, @Size(min = 2, max = 20) String email, String password,
				boolean duplicate, String passwordConfirmation) {
			super();
			FirstName = firstName;
			LastName = lastName;
			Birthday = birthday;
			this.email = email;
			this.password = password;
			this.duplicate = duplicate;
			this.passwordConfirmation = passwordConfirmation;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public int getBirthday() {
			return Birthday;
		}

		public void setBirthday(int birthday) {
			Birthday = birthday;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isDuplicate() {
			return duplicate;
		}

		public void setDuplicate(boolean duplicate) {
			this.duplicate = duplicate;
		}

		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}

		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public List<Event> getCreated_events() {
			return created_events;
		}

		public void setCreated_events(List<Event> created_events) {
			this.created_events = created_events;
		}
	    
}
