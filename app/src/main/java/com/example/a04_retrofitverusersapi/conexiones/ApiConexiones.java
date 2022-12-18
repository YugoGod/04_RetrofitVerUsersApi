package com.example.a04_retrofitverusersapi.conexiones;

import com.example.a04_retrofitverusersapi.modelos.General;
import com.example.a04_retrofitverusersapi.modelos.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {

    @GET("users") // EndPoint
    Call<General> getUsuarios();

}
