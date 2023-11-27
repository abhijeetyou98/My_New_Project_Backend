package com.ep.backend.entities;



import java.sql.Date;
import java.util.Collection;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements UserDetails{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String student_id;
	
	@Column(name = "Students_name")
	private String studentsName;
	
	@Column(nullable = false)
	private long students_number;
	 
	@Column(name = "Students_email_id")
	private String studentsEmailId;

	@Column(name = "Parents_name")
	private String parentsName;
	
	@Column(nullable = false)
	 private long parents_number;
	
	@Column(name = "Parents_email_id")
	private String parents_emailId;
	
	@CreationTimestamp
	private Date date;

//	 @Column(length = 20)
//	private String role;
	 
	private int grade;
	  
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		
		return this.studentsEmailId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
//	this method gets overriden by lombok hence we have to write again
	@Override
	public String getPassword() {
		
		return this.password;
	}
	
	
  //  private List<Course> courseList;
 
 /*@JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
    
  //@OneToOne(cascade = CascadeType.ALL)
  	 private Course course;*/
  	 
}

