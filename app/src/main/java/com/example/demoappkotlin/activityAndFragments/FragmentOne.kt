package com.example.demoappkotlin.activityAndFragments

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demoappkotlin.R
import com.example.demoappkotlin.utils.Tag

class FragmentOne() : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(Tag, "OnAttached")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag, "OnCreated")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(Tag, "OnViewCreated")
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(Tag, "OnActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(Tag, "OnStarted")
        super.onStart()
    }

    override fun onResume() {
        Log.d(Tag, "OnResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(Tag, "OnPaused")
        super.onPause()
    }

    override fun onStop() {
        Log.d(Tag, "OnStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(Tag, "OnDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d(Tag, "OnDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d(Tag, "OnDetached")
        super.onDetach()
    }
}