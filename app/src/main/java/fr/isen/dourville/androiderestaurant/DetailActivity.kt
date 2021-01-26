package fr.isen.dourville.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import fr.isen.dourville.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.dourville.androiderestaurant.model.Dish

private lateinit var binding: ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Title
        val dish = intent.getSerializableExtra("dish") as? Dish
        binding.dishTiltle.text = dish?.title

        binding.listIngredients.text = dish?.ingredients?.map { it.name_fr }?.joinToString(", ")

            val textView = findViewById<TextView>(R.id.dishTiltle)


    }
}