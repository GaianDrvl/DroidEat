package fr.isen.dourville.androiderestaurant.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.isen.dourville.androiderestaurant.databinding.LoginFragmentBinding


private lateinit var binding: LoginFragmentBinding


class LoginFragment : Fragment() {


    var delegate: LoginActivityFragmentInteraction? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is LoginActivityFragmentInteraction) {
            delegate = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logButton.setOnClickListener {
            delegate?.makeRequest(
                binding.email.text.toString(),
                binding.password.text.toString(),
                null,
                null,
                true
            )
        }

        binding.registerButton.setOnClickListener {
            delegate?.showRegister()
        }
    }
}
