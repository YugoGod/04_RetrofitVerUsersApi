package com.example.a04_retrofitverusersapi.modelos;

public class Usuario{

	// ATRIBUTOS
	private String lastName;
	private int id;
	private String avatar;
	private String firstName;
	private String email;

	// GETTERS AND SETTERS
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}

	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	public String getAvatar(){
		return avatar;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}

	// MÉTODOS GENÉRICOS O PROPIOS
	@Override
 	public String toString(){
		return 
			"Usuario{" + 
			"last_name = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
