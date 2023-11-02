package com.example.wattpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.wattpad.databinding.ActivityMainBinding
import com.example.wattpad.fragmentos.Buscar
import com.example.wattpad.fragmentos.biblioteca
import com.example.wattpad.fragmentos.escribir
import com.example.wattpad.fragmentos.home
import com.example.wattpad.fragmentos.notificaciones

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            botonnavegationview.menu.findItem(R.id.menu_home2).setOnMenuItemClickListener {
                findNavigation(home.newInstance("",""))
                it.isCheckable=true
                return@setOnMenuItemClickListener true
            }
            botonnavegationview.menu.findItem(R.id.menu_buscar).setOnMenuItemClickListener {
                findNavigation(Buscar.newInstance("",""))
                it.isCheckable=true
                return@setOnMenuItemClickListener true
            }
            botonnavegationview.menu.findItem(R.id.menu_libros).setOnMenuItemClickListener {
                findNavigation(biblioteca.newInstance("",""))
                it.isCheckable=true
                return@setOnMenuItemClickListener true
            }
            botonnavegationview.menu.findItem(R.id.menu_lapiz).setOnMenuItemClickListener {
                findNavigation(escribir.newInstance("",""))
                it.isCheckable=true
                return@setOnMenuItemClickListener true
            }
            botonnavegationview.menu.findItem(R.id.menu_noti).setOnMenuItemClickListener {
                findNavigation(notificaciones.newInstance("",""))
                it.isCheckable=true
                return@setOnMenuItemClickListener true
            }
            }
        }

    private fun findNavigation(fragment: Fragment) {
       supportFragmentManager.beginTransaction()
           .replace(R.id.fragmentContainerView,fragment)
           .addToBackStack(null)
           .commit()

    }
}