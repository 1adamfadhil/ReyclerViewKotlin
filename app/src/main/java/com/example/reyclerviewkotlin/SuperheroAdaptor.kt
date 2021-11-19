package com.example.reyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdaptor(private val context: Context, private val superhero: Unit, val listener: (Superhero) -> Unit)
    : RecyclerView.Adapter<SuperheroAdaptor.SuperheroViewolder>(){

    class SuperheroViewolder(view: View): RecyclerView.ViewHolder(view) {

        val imgSuperhero = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameSuperhero = view.findViewById<TextView>(R.id.tv_item_name)
        val descriptionSuperhero = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(superhero: Superhero, listener: (Superhero) -> Unit) {
            imgSuperhero.setImageResource(superhero.imgSuperhero)
            nameSuperhero.text = superhero.nameSuperhero
            descriptionSuperhero.text = superhero.descriptionSuperhero
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewolder {
        return SuperheroViewolder(
            LayoutInflater.from(context).inflate(R.layout.item_tugas, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperheroViewolder, position: Int) {
       holder.bindView(superhero[position], listener)
    }

    override fun getItemCount(): Int = superhero.size
    }

