package ru.viknist.aston_dz_6.ui.contact_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import ru.viknist.aston_dz_6.R
import ru.viknist.aston_dz_6.features.ContactItemDecorator
import ru.viknist.aston_dz_6.features.ContactList.contactList
import ru.viknist.aston_dz_6.features.adapter.ContactListAdapter
import ru.viknist.aston_dz_6.getTag
import ru.viknist.aston_dz_6.ui.contact_details.ContactDetailsFragment
import ru.viknist.aston_dz_6.utils.*

class ContactListFragment : Fragment(R.layout.fragment_contact_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_contacts)
        recyclerView.adapter = ContactListAdapter(requireContext(), contactList) {
            val bundle = Bundle().apply {
                putInt(ID_KEY, it.id)
                putString(FIRST_NAME_KEY, it.firstName)
                putString(LAST_NAME_KEY, it.lastName)
                putString(PHONE_KEY, it.phone)
                putString(IMAGE_URI_KEY, it.imageURI)
            }
            setFragmentResult(CONTACT_LIST_FRAGMENT_RESULT_KEY, bundle)
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    ContactDetailsFragment(),
                    ContactDetailsFragment::class.getTag())
                .addToBackStack(ContactDetailsFragment::class.getTag())
                .commit()
        }

        recyclerView.addItemDecoration(ContactItemDecorator(requireContext()))

    }

    companion object {
        const val CONTACT_LIST_FRAGMENT_TAG = "CONTACT_LIST_FRAGMENT_TAG"
        const val CONTACT_LIST_FRAGMENT_RESULT_KEY = "CONTACT_LIST_FRAGMENT_RESULT_KEY"
    }
}