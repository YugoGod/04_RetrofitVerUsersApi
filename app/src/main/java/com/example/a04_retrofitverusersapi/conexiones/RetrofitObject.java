package com.example.a04_retrofitverusersapi.conexiones;

import com.example.a04_retrofitverusersapi.configuraciones.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    public static Retrofit getConnection() {
        return new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL) // Atributo 'BASE_URL' de la clase 'Constantes'.
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
