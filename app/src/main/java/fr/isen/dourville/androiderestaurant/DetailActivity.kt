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

        val list = dish?.getAllPictures()?.toList()

        val adapter = ViewPagerAdapter(supportFragmentManager)

        val basePrice: Double = dish!!.getPrice()

        binding.price.text = basePrice.toString()

        var quantity: Int = 1


        binding.plusBtn.setOnClickListener {
            quantity++
            var price = quantity * basePrice
            binding.price.text = price.toString()
        }

        binding.minusBtn.setOnClickListener {
            if (quantity > 1) {
                quantity--
            }
            var price = quantity * basePrice
            binding.price.text = price.toString()
        }

        if (!list.isNullOrEmpty()){
            for (i in 1..list!!.size) {
                val fragment = DetailFragment.newInstance(list[i - 1])
                adapter.addFragment(fragment)
            }
        }

        binding.carroussel.adapter = adapter
    }
}