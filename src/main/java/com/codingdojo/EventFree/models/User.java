package com.codingdojo.EventFree.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="users")
public class User {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	 	@Size(min=2,max=20,message="FIRST LETTER MUST BE CAPITALIZED!")
	 	private String FirstName;
	 	@Size(min=2,max=20,message="FIRST LETTER MUST BE CAPITALIZED!")
	 	private String LastName;
	 	private int Birthday;
	 	@Email(message = "EMAIL FORMATS PLEASE")
		@NotBlank(message = "Please Enter A Valid Email")
	 	private String email;
		@Size(min = 8, message = "PW Needs to be 8 Char. Min.")
	 	private String password;
	    
	    @Transient
	    private boolean duplicate;
	    
		@NotBlank(message = "Please Confirm Password")
	    @Transient
	    private String passwordConfirmation;
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @Column(updatable=true)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
	    private List<Event> created_events;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    name = "events_attendees", 
	    joinColumns = @JoinColumn(name = "user_id"), 
	    inverseJoinColumns = @JoinColumn(name = "event_id")
	    )
	    private List<Event> events_attending;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    name = "friendships", 
	    joinColumns = @JoinColumn(name = "user_id"), 
	    inverseJoinColumns = @JoinColumn(name = "friend_id")
	    )
	    private List<User> friends;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    name = "friendships", 
	    joinColumns = @JoinColumn(name = "friend_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<User> userFriends;
	    
	
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

		public List<Event> getEvents_attending() {
			return events_attending;
		}

		public void setEvents_attending(List<Event> events_attending) {
			this.events_attending = events_attending;
		}

		public List<User> getFriends() {
			return friends;
		}
		
		public void setFriends(List<User> friends) {
			this.friends = friends;
		}

		public List<User> getUserFriends() {
			return userFriends;
		}

		public void setUserFriends(List<User> userFriends) {
			this.userFriends = userFriends;
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
