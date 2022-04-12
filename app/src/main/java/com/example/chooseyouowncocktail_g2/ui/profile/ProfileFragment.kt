package com.example.chooseyouowncocktail_g2.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.chooseyouowncocktail_g2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProfileFragment()
    }

    //private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        //val viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.contactUs.setOnClickListener {
            Toast.makeText(context, "LET ME KNOW !! ;)", Toast.LENGTH_LONG).show()
        }
        binding.settings.setOnClickListener {
            Toast.makeText(context, "LET'S MAKE UP TOGHETHER;)", Toast.LENGTH_LONG).show()
        }
        binding.logOut.setOnClickListener {
            Toast.makeText(context, "SEE YOU SOON :)", Toast.LENGTH_LONG).show()
        }
    }

}