package com.example.a04_retrofitverusersapi;

import android.os.Bundle;

import com.example.a04_retrofitverusersapi.adapters.UsuarioAdapter;
import com.example.a04_retrofitverusersapi.conexiones.ApiConexiones;
import com.example.a04_retrofitverusersapi.conexiones.RetrofitObject;
import com.example.a04_retrofitverusersapi.modelos.General;
import com.example.a04_retrofitverusersapi.modelos.Usuario;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.a04_retrofitverusersapi.databinding.ActivityMainBinding;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<Usuario> usersList;
    private UsuarioAdapter adapter;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usersList = new ArrayList<>();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        adapter = new UsuarioAdapter(usersList, MainActivity.this, R.layout.usuario_view_model);
        lm = new LinearLayoutManager(this); // El 'context'  puede ser tanto 'MainActivity.this' como 'this'.

        binding.contentMain.contenedor.setAdapter(adapter);
        binding.contentMain.contenedor.setLayoutManager(lm);

        doGetUsers();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void doGetUsers() {
        Retrofit retrofit = RetrofitObject.getConnection();
        ApiConexiones api = retrofit.create(ApiConexiones.class);

        Call<General> getUsuarios = api.getUsuarios();

        getUsuarios.enqueue(new Callback<General>() {
            @Override
            public void onResponse(Call<General> call, Response<General> response) {
                if (response.isSuccessful()){
                    if (response.code() == HttpURLConnection.HTTP_OK){
                        Toast.makeText(MainActivity.this, "Funciona.", Toast.LENGTH_SHORT).show();
                        if (response.body() != null){
                            usersList.addAll(response.body().getData());
                            adapter.notifyItemRangeInserted(0, usersList.size());
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Algo ha fallado." + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Azucar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<General> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión.", Toast.LENGTH_SHORT).show();
                Log.e("Failure", t.getMessage());
            }
        });
    }
}