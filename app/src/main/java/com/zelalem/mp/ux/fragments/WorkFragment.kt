package com.zelalem.mp.ux.fragments

import com.zelalem.mp.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zelalem.mp.data.Work
import com.zelalem.mp.adapter.WorkAdapter
import com.zelalem.mp.ux.dialog.WorkDialog

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    getString(R.string.thermofisher),
                    getString(R.string.tm_job_title),
                    getString(R.string._2021_present),
                    R.drawable.kforce
                ),
                Work(
                    getString(R.string.custor),
                    getString(R.string.net_core_developer),
                    getString(R.string._2018_2021),
                    R.drawable.arba_minch_university
                ),
                Work(
                    getString(R.string.addis_ababa_university),
                    getString(R.string.addis_ababa_university),
                    getString(R.string._2014_2016),
                    R.drawable.addis_ababa_university_logo
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkDialog()
        dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}