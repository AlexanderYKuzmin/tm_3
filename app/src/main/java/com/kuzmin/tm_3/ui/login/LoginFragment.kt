package com.kuzmin.tm_3.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.kuzmin.tm_3.R
import com.kuzmin.tm_3.TmApp
import com.kuzmin.tm_3.databinding.FragmentLoginBinding
import com.kuzmin.tm_3.domain.model.AuthUser
import com.kuzmin.tm_3.ui.ViewModelFactory
import com.kuzmin.tm_3.ui.util.AuthValidation
import javax.inject.Inject

const val AUTH_USER = "auth_user"

class LoginFragment : Fragment(), OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    //val args: LoginFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val loginFragmentViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[LoginFragmentViewModel::class.java]
    }

    private val loginComponent by lazy {
        (requireActivity().application as TmApp).component.getLoginSubComponent()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginComponent.inject(this)

        with(binding) {
            btnLogin.setOnClickListener(this@LoginFragment)
            btnLoginCancel.setOnClickListener(this@LoginFragment)
        }

        with(loginFragmentViewModel) {
            readAuthUser()
            authUserData.observe(requireActivity()){
                if (AuthValidation.isTokenValid(it.token, it.dateToken)) loginSucceed()
                else showAuthUser(it)
            }
        }
    }

    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LoginListener) {
            loginListener = context
        } else {
            throw RuntimeException("Activity must implement OnDeviceItemClickListener")
        }
    }*/

    override fun onClick(v: View) {
        with(binding) {
            when(v) {
                btnLogin -> sendLoginData()
                btnLoginCancel -> cancelLogin()
                else -> {throw RuntimeException("Unknown case")}
            }
        }
    }

    private fun showAuthUser(authUser: AuthUser) {
        with(binding) {
            etUsername.setText(authUser.username)
        }
    }

    private fun sendLoginData() {
        with(binding) {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            with(loginFragmentViewModel) {
                if (AuthValidation.isPasswordConsistent(password)) getUser(username, password)
                //else //TODO message invalid password
            }
        }
    }

    private fun cancelLogin() {
        //TODO message about cansel
        popBackStack()
    }

    private fun loginSucceed() {
        //TODO message of successful login
        popBackStack()
    }

    private fun popBackStack() {
        requireActivity().findNavController(R.id.nav_host_fragment_activity_main).popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}