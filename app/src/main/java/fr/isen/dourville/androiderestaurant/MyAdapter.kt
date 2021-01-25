package fr.isen.dourville.androiderestaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.isen.dourville.androiderestaurant.databinding.DishTemplateBinding
import java.util.*

class MyAdapter(private val categories: List<String>): RecyclerView.Adapter<MyAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val itemBinding = DishTemplateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.title.text = categories[position]
    }

    override fun getItemCount(): Int = categories.size

    class CategoryHolder(binding: DishTemplateBinding) : RecyclerView.ViewHolder(binding.root){
        val title = binding.dishName
    }
}