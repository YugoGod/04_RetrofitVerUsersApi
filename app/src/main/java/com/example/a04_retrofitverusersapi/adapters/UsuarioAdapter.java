package com.example.a04_retrofitverusersapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a04_retrofitverusersapi.R;
import com.example.a04_retrofitverusersapi.modelos.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioVH> {

    private List<Usuario> objects;
    private Context context;
    private int resource;

    public UsuarioAdapter(List<Usuario> objects, Context context, int resource) {
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public UsuarioAdapter.UsuarioVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View albumView = LayoutInflater.from(context).inflate(resource, null);
        albumView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return new UsuarioVH(albumView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioVH holder, int position) {
        Usuario user = objects.get(position);

        holder.lblNombreUser.setText(user.getFirstName() + " " + user.getLastName());
        holder.lblEmailUser.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class UsuarioVH extends RecyclerView.ViewHolder {

        private ImageView imgUser;
        private TextView lblNombreUser;
        private TextView lblEmailUser;


        public UsuarioVH(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.imgAvatarUsuarioModel);
            lblNombreUser = itemView.findViewById(R.id.lblNombreUsuarioModel);
            lblEmailUser = itemView.findViewById(R.id.lblGmailUsuarioModel);
        }
    }
}
