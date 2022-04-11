package com.zelalem.mp.ux.fragments

import com.zelalem.mp.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.zelalem.mp.ux.activity.WebActivity

class ContactFragment : Fragment(R.layout.fragment_contact) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<LinearLayout>(R.id.phone).setOnClickListener { onPhoneClicked() }
        view.findViewById<LinearLayout>(R.id.email).setOnClickListener { onEmailClicked() }
        view.findViewById<LinearLayout>(R.id.linkedIn).setOnClickListener { onLinkedInClicked() }
    }

    private fun onPhoneClicked() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(getString(R.string.my_phone))
        startActivity(intent)
    }

    private fun onEmailClicked() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse(getString(R.string.intent_filter))
        intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.my_email))
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body))
        startActivity(intent)
    }

    private fun onLinkedInClicked() {
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra(getString(R.string.intent_key), getString(R.string.my_linkedin))
        startActivity(intent)
    }
}