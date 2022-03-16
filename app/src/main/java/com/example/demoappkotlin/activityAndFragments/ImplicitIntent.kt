package com.example.demoappkotlin.activityAndFragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.demoappkotlin.R

class ImplicitIntent : AppCompatActivity() {
    lateinit var btnTakePhoto: Button
    lateinit var ivphoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        btnTakePhoto = findViewById(R.id.btnTakePhoto)
        ivphoto = findViewById(R.id.ivPhoto)
        btnTakePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = getString(R.string.image_type)
                resultLauncher.launch((it))
            }
        }
        var imageUri = intent.getParcelableExtra<Parcelable>(getString(R.string.key_implicit_intent))
        ivphoto.setImageURI(imageUri as Uri?)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val uri: Uri? = data?.data
                ivphoto.setImageURI(uri)
            }
        }
}
