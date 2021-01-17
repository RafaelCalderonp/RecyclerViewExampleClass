package com.example.recyclerviewexampleclass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerviewexampleclass.databinding.FragmentFirstBinding;
import com.example.recyclerviewexampleclass.databinding.WordItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements WordAdapter.InterfacePasarElemento {
    private FragmentFirstBinding mBinding;
    private List<String> dataList = new ArrayList<>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Instanciamos el adapter y le pasamos el listado de datos con el metodo setData
        WordAdapter adapter = new WordAdapter(setData(), this );
        //le pasamos el adapter al recycler View
        mBinding.recycleView.setAdapter(adapter);
        //le Indicamos a RV como mostrar los elementos, podria ser GridLayaut o StaggerredLayaut.
        mBinding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Añado una Palabra
                dataList.add("Palabra   :" + dataList.size());
                //Notificar al adaptador que insertamos datos
                mBinding.recycleView.getAdapter().notifyItemInserted(dataList.size());
                //Scroll al final de la lista.
                mBinding.recycleView.smoothScrollToPosition(dataList.size());
            }
        });

    }
    private List<String> setData(){

        for (int i = 0; i < 100; i++) {
            dataList.add("Palabra   :" + i);
        }
        return dataList;
    }

    @Override
    public void passElement(String item) {

        //Toast.makeText(getContext(), item, Toast.LENGTH_SHORT).show();
        Bundle mBundle = new Bundle();
        mBundle.putString("item", item);
        Navigation.findNavController(mBinding.getRoot())
                .navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle);
    }
}