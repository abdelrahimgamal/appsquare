package myapp.appsquare.appsquare.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import myapp.appsquare.appsquare.data.adapter.ProductsAdapter
import myapp.appsquare.appsquare.data.models.Product
import myapp.appsquare.appsquare.data.models.Status
import myapp.appsquare.appsquare.databinding.FragmentHomeBinding
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()

    private val args by navArgs<HomeFragmentArgs>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        args.address?.let {
            Toast.makeText(
                requireContext(),
                "your picked address is ${it.country}  ${it.city}  ${it.street}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.submitLocation.setOnClickListener {
            goToMap()

        }

    }


    private fun setupObservers() {
        viewModel.products.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressCircular.visibility = View.GONE
                    it.data?.let { data ->
                        binding.productsRv.adapter = ProductsAdapter(data)
                    }
                }

                Status.ERROR -> {
                    binding.progressCircular.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }

                Status.LOADING -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun goToMap() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMapFragment())
    }

}