package com.example.examplemvvm.tasks


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examplemvvm.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TasksFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }

    private fun setupFab(){
        activity?.findViewById<FloatingActionButton>(R.id.fab_add_task)?.let {
            it.setOnClickListener {

            }
        }
    }

    companion object{
        fun newInstance() = TasksFragment()
    }

}
