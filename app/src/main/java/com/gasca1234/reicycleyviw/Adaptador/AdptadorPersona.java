package com.gasca1234.reicycleyviw.Adaptador;

import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.reicycleyviw.Modelos.persona;
import com.gasca1234.reicycleyviw.R;
import android.content.Context;


import java.util.ArrayList;
import java.util.List;

public class AdptadorPersona extends RecyclerView.Adapter <AdptadorPersona.viewHolder>  {

    List<persona> lp;
    private ArrayList<persona> userList;



    public AdptadorPersona(ArrayList<persona> userList)
    {
        this.userList=userList;
    }
    public AdptadorPersona(List<persona> lp) {

        this.lp = lp;
    }


        @NonNull
        @Override
        public AdptadorPersona.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            //Aqui se agrega para que se relacione la informacion y el holder, crear vista y despues enviarlo al view holder
            //el holder recibe una vista, cuando reciba una vista lo va a volver un holder

            //primero declaro mi variable donde voy a guardar mi vista
            //inflador de layouts
            //inflate =  que es lo que voy a inflar (aqui tengo que pasar mi layout)
            //tienes que especificar so va a ser raiz
            //en v esta el diseno que se hizo
            //este metodo tiene que devolver un viewHolder

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);

//el metodo inflater necesita 3 tipos de datos con eso yo tengo una vista y esa se la paso al cnstructor del view holder
            //envio un view holder atraves del inflate y creo una lista



            //se le conoce como inflar a vista

            //retornamos la vista hecha viewHolder que tiene adentro una vista que es el diseno
            //cada cuadrito es una vista que tiene un diseno, con esto ya tengo el diseno
            //
            return new viewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull AdptadorPersona.viewHolder holder, int position) {
            //recibe un holder y una posicion, la posicion me va a representar a mi un elemento
//cargar el diseño ,genra una vista
          //  String name=userList.get(position).getNombre();
            holder.setData(lp.get(position));
         //   holder.txtNombre.setText(name);
         //   String telefono=userList.get(position).getTelefono();
           // holder.txtTelefono.setText(telefono);


        }

        @Override
        public int getItemCount() {
            return lp.size();
        }


        //clase con un constructor
        public class viewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

            TextView txtNombre;
            TextView txtTelefono;
            persona personaholder;


            public viewHolder(@NonNull View itemView) {
                super(itemView); //itemview es la vista
                txtNombre = itemView.findViewById(R.id.dos);
                txtTelefono = itemView.findViewById(R.id.tres);
                //vas a escuchar los click
                //declaro un escuchador
                txtTelefono.setOnClickListener(this);
                //itemView.setOnClickListener(this);

            }

            public void setData(persona p) {
                personaholder=p;
                txtNombre.setText(p.getNombre());
                txtTelefono.setText(p.getTelefono());

            }

            @Override
            public void onClick(View view) {
                personaholder.getNombre();
                personaholder.getTelefono();
                //Uri es un texto con fromato
                //existen mas de 2 fromas de poner intent esta sobre cargado 
                Intent abri=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+personaholder.getTelefono()));
                //todos los groupview teine contecto que es una
                //el contexto es coomo un activity es como un navegador
                //contexto en que pagina estoy  donde estoy
                view.getContext().startActivity(abri);
            }
        }}

