package ru.viknist.aston_dz_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.viknist.aston_dz_6.ui.contact_list.ContactListFragment
import ru.viknist.aston_dz_6.ui.contact_list.ContactListFragment.Companion.CONTACT_LIST_FRAGMENT_TAG

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactListFragment =
            supportFragmentManager.findFragmentByTag(CONTACT_LIST_FRAGMENT_TAG)


        if (contactListFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContactListFragment(), CONTACT_LIST_FRAGMENT_TAG)
                .commit()
        }
    }
}