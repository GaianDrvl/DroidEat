@file:JvmName("DishActivityKt")

package fr.isen.dourville.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.dourville.androiderestaurant.databinding.ActivityDishBinding

private lateinit var binding: ActivityDishBinding

class EntreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)

        binding = ActivityDishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Title
        binding.categoryTitle.text = intent.getStringExtra("category")

        //Recycler View
        val dishList = resources.getStringArray(R.array.dish_list).toList()
        val recycler : RecyclerView = binding.dishRecycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MyAdapter(dishList)

    }


}