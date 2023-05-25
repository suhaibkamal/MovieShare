package com.sk.movieshare.base

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sk.movieshare.ui.theme.MovieShareTheme
import javax.inject.Inject

abstract class BaseActivity< V : ViewDataBinding>:AppCompatActivity() {


    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        binding.lifecycleOwner = this




    }

    @LayoutRes
    abstract fun getLayout(): Int




    fun handleError(throwable: Throwable) =
        Toast.makeText(this, throwable.toString(), Toast.LENGTH_SHORT).show()


    }

