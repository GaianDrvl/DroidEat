package fr.isen.dourville.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.dourville.androiderestaurant.databinding.ActivityHomeBinding


private lateinit var binding: ActivityHomeBinding

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntree.setOnClickListener {
            val entree =  Intent(applicationContext, DishActivity::class.java)
            val key = "category"

            entree.putExtra(key, "Entrées");
            startActivity(entree)

        }

        binding.btnPlat.setOnClickListener {
            val entree =  Intent(applicationContext, DishActivity::class.java)
            val key = "category"

            entree.putExtra(key, "Plats");
            startActivity(entree)

        }

        binding.btnDessert.setOnClickListener {
            val entree =  Intent(applicationContext, DishActivity::class.java)
            val key = "category"

            entree.putExtra(key, "Desserts");
            startActivity(entree)

        }
    }

}