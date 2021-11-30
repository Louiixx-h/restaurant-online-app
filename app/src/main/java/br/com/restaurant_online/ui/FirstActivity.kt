package br.com.restaurant_online.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.restaurant_online.databinding.ActivityFirstBinding
import com.restaurant_online.component_navigation.NavigationController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val context = this

        NavigationController.instance?.moduleNotification()?.createNotification(
            this,
            "Seu pedido foi enviado!",
            "Fique atento, seu pedido chegará em breve"
        )

        CoroutineScope(Dispatchers.Default).launch {
            delay(800)
            NavigationController.instance?.moduleMenu()?.goToMenu(context = context)
        }
    }
}