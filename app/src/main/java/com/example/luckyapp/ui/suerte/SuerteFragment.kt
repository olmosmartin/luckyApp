package com.example.luckyapp.ui.suerte

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.luckyapp.R
import com.example.luckyapp.databinding.FragmentSuerteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuerteFragment : Fragment() {

    private val suerteViewModel by viewModels<SuerteViewModel>()
    private var _binding: FragmentSuerteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuerteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        binding.ivRuleta.setOnClickListener {
            Log.i("lucky", "click ruleta")
            spinAnimation(it)
        }
    }

    private fun spinAnimation(view: View) {
        /*
        * la parte de cancelar la animacion y de reestablecer la vista a su estado inicial es necesaria
        * porque si no se hace la imagen se rompe con un press antes de que termine la animacion ya que
        * la animacion se inicia sin antes terminar y el estado final queda
        * con 360 grados de vuelta pero desde una cantidad de grados ya aplicada sobre el view
        */

        // Cancelar la animación anterior si está en curso
        view.animate().cancel()
        // Restablecer la vista a su estado inicial
        view.rotation = 0f

        // Iniciar la nueva animación
        view.animate().apply {
            duration = 2000
            interpolator = DecelerateInterpolator()//va cada vez mas lento la animacion
            rotation(360f)
            // Acá dice qué ejecuta cuando la animación termina
            withEndAction({ slideCard() })
            start()
        }
    }

    private fun slideCard() {
        //uso una forma diferente de animación llamando un xml que está en la carpeta res/anim
        //tambien podría hacerse de la forma q está hecho slideCard
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
                binding.ivCardBack.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        binding.ivCardBack.startAnimation(slideUpAnimation)
    }

    private fun growCard() {
        /*
            otra forma diferente de hacer animacion esta vez con el ObjectAnimator,
            es diferente a la de spinAnimation y la de slideCard
            tambien se podría usar cualquier de las otras dos
         */
        val targetScale = 3.0f // Escala deseada (puedes ajustarla según tus necesidades)

        // Escala en el eje X
        val scaleXAnimator = ObjectAnimator.ofFloat(binding.ivCardBack, View.SCALE_X, targetScale)
        scaleXAnimator.duration = 500
        scaleXAnimator.interpolator = LinearInterpolator()
        scaleXAnimator.start()

        // Escala en el eje Y
        val scaleYAnimator = ObjectAnimator.ofFloat(binding.ivCardBack, View.SCALE_Y, targetScale)
        scaleYAnimator.duration = 500
        scaleYAnimator.interpolator = LinearInterpolator()
        scaleYAnimator.doOnEnd {
            //binding.ivCardBack.visibility = View.GONE
            //binding.ivRuleta.visibility = View.GONE
            showPremonition()
        } //asi se pone qué hace cuanto termina con ObjectAnimator
        scaleYAnimator.start()

    }

    private fun showPremonition() {
        //animacion para desaparecer la vista de la ruleta con un fade out de 300ms
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 300

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                //hago aparecer la vista de la prediccion
                appearAnimation()
                //hago desaparecer la vista de la ruleta
                binding.clPreview.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.clPreview.startAnimation(disappearAnimation)

    }

    private fun appearAnimation() {
        //animacion para aparecer la vista de la prediccion con un fade in de 1000ms
        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        appearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                //hago aparecer la vista de la prediccion
                binding.clPrediction.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.clPrediction.startAnimation(appearAnimation)
    }

}