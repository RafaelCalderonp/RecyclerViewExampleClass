package com.example.recyclerviewexampleclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexampleclass.databinding.WordItemListBinding;

import java.util.List;
                                    //3.- Extender de Recycler.Adapter, pasar el ViewHolder creado
                                    //4.- Implementar los metodos. onCreate, onBind, getItem

public class WordAdapter   extends  RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    // 1.- Añadir una representación de los datos.
    private List<String> mWordList;
    // 8.- Crear contructor no vacio
    public WordAdapter(List<String> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //6.- Instanciamos ViewBinding para retornar nuestro ViewHolder con esa dependencia.
        WordItemListBinding mbinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        //7.- Creamos una variable de referencia de contenido de el listado y lo asignamos
        // al elemento visual que viene en el holder
        String element = mWordList.get(position);
        holder.textView.setText(element);
    }

    @Override
    public int getItemCount() {
        //5.- Indicar la cantidad de datos a mostrar
        return  mWordList.size();             // Lo original0;
    }

    // 2.- Crear clase interna ViewHolder
    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;
        }
    }

}
