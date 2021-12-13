package com.example.ret2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ret2.AddForm;
import com.example.ret2.Contac;
import com.example.ret2.R;
import com.example.ret2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setHasOptionsMenu(true); //linea para colocar una acción personalizada en los 3 puntos

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contactenos:
                Intent intent = new Intent(getContext(), Contac.class);
                intent.putExtra("title", "Home");
                startActivity(intent);
                Toast.makeText(getContext(), "contactar desde home", Toast.LENGTH_SHORT).show(); //para que salga el mensaje abajo
                return true;
            case R.id.action_saludar:
                Intent intent2 = new Intent(getActivity(), AddForm.class);
                intent2.putExtra("titulo", "Home");
                startActivity(intent2);
                        Toast.makeText(getContext(), "saludar desde home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cerrar:
                Toast.makeText(getContext(), "cerrar APP ", Toast.LENGTH_SHORT).show();
                getActivity().finish(); //para cerrar la aplicación
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}