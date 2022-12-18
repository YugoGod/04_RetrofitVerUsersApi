package com.example.a04_retrofitverusersapi.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class General{

	@SerializedName("data")
	private List<Usuario> users;

	@SerializedName("data")
	public void setData(List<Usuario> data){
		this.users = data;
	}

	@SerializedName("data")
	public List<Usuario> getData(){
		return users;
	}

	@Override
 	public String toString(){
		return 
			"General{ data = '" + users + '\'' + "}";
		}
}