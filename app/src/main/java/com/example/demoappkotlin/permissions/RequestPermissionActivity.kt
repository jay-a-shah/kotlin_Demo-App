package com.example.demoappkotlin.permissions

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.demoappkotlin.R
import com.example.demoappkotlin.utils.ZERO

class RequestPermissionActivity : AppCompatActivity() {
    var REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_permission)
        checkPermission()
    }

    private fun checkPermission() {
        val result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (result == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, getString(R.string.toast_permission_granted), Toast.LENGTH_LONG).show()
        } else {
            requestPermission()
            Toast.makeText(this, getString(R.string.toast_permission_not_granted) , Toast.LENGTH_LONG).show()
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.isNotEmpty()) {
                    if (grantResults[ZERO] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, getString(R.string.toast_permission_granted), Toast.LENGTH_LONG).show()
                    } else
                        showPermissionDeniedDialog()

                }
            }
        }
    }

    private val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            checkPermission()
            if (result.resultCode != Activity.RESULT_OK) {
                Log.d("permission", getString(R.string.toast_permission_not_granted))
            }
        }

    fun showPermissionDeniedDialog() {
        val builder = AlertDialog.Builder(this)
        var alertDialog: AlertDialog? = null
              builder.apply {
                  setTitle(getString(R.string.title_alert_dialog))
                  setMessage(getString(R.string.message_dialog))
                  setPositiveButton(getString(R.string.btn_alert_positive_btn)) { _, _ ->
                      val intent = Intent()
                      intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                      val uri = Uri.fromParts("package", packageName, null)
                      intent.data = uri
                      alertDialog?.dismiss()
                      activityResultLauncher.launch(intent)
                  }
                  setNegativeButton(getString(R.string.btn_alert_negative), null)
              }
        alertDialog = builder.create()
        alertDialog.apply {
            show()
        }
    }
}

