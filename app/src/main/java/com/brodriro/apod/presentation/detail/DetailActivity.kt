package com.brodriro.apod.presentation.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brodriro.apod.databinding.ActivityDetailBinding
import com.brodriro.apod.presentation.apods.viewobject.PostVO
import com.squareup.picasso.Picasso
import android.transition.Fade
import android.view.View


class DetailActivity : AppCompatActivity() {

    companion object {
        private const val DATA = "PostVO"
        fun getIntent(postVO: PostVO, context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DATA, postVO)
            return intent
        }
    }

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       starAnimation()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.extras?.getParcelable<PostVO>(DATA)?.let { it -> setupViews(it) }

    }

    private fun starAnimation() {
        val fade = Fade()
        val decor: View = window.decorView
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)

        window.enterTransition = fade
        window.exitTransition = fade
    }

    private fun setupViews(postVO: PostVO) {
        binding.tvTitle.text = postVO.title
        binding.tvDate.text = postVO.date
        binding.tvParagraph.text = postVO.explanation

        if (postVO.url.isEmpty()) return

        Picasso.get()
            .load(postVO.url)
            .into(binding.ivPictureDetail);
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition()
    }
}