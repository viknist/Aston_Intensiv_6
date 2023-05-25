package ru.viknist.aston_dz_6.ui.contact_details

import android.os.Bundle
import android.text.method.KeyListener
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.setFragmentResultListener
import coil.load
import ru.viknist.aston_dz_6.R
import ru.viknist.aston_dz_6.features.ContactList.contactList
import ru.viknist.aston_dz_6.model.Contact
import ru.viknist.aston_dz_6.ui.contact_list.ContactListFragment.Companion.CONTACT_LIST_FRAGMENT_RESULT_KEY
import ru.viknist.aston_dz_6.utils.*

class ContactDetailsFragment : Fragment(R.layout.fragment_contact_details) {

    private lateinit var imageUri: String
    var editState: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText = view.findViewById<EditText>(R.id.nameEditText)
            .apply {
                tag = keyListener
                keyListener = null
            }
        val phoneEditText = view.findViewById<EditText>(R.id.phoneEditText)
            .apply {
                tag = keyListener
                keyListener = null
            }
        val idEditText = view.findViewById<EditText>(R.id.idEditText)
            .apply {
                tag = keyListener
                keyListener = null
            }
        val lastNameEditText = view.findViewById<EditText>(R.id.lastNameEditText)
            .apply {
                tag = keyListener
                keyListener = null
            }
        val imageDetails = view.findViewById<ImageView>(R.id.imageDetails)
        val editButton = view.findViewById<Button>(R.id.editButton)

        if (savedInstanceState != null && !savedInstanceState.getString(SAVED_IMAGE_URI_KEY)
                .isNullOrBlank()
        ) {
            imageUri = savedInstanceState.getString(SAVED_IMAGE_URI_KEY).toString()
            imageDetails.load(imageUri)
        }

        setFragmentResultListener(CONTACT_LIST_FRAGMENT_RESULT_KEY) { _, bundle ->
            nameEditText.setText(bundle.getString(FIRST_NAME_KEY).toString())
            phoneEditText.setText(bundle.getString(PHONE_KEY).toString())
            idEditText.setText(bundle.getInt(ID_KEY).toString())
            lastNameEditText.setText(bundle.getString(LAST_NAME_KEY).toString())
            imageUri = bundle.getString(IMAGE_URI_KEY).toString()
            imageDetails.load(imageUri)
        }

        editButton.setOnClickListener {
            if (editState) {
                nameEditText.apply {
                    keyListener = null
                }

                phoneEditText.apply {
                    keyListener = null
                }

                lastNameEditText.apply {
                    keyListener = null
                }

                val contact = Contact(
                    idEditText.text.toString().toInt(),
                    phoneEditText.text.toString(),
                    nameEditText.text.toString().also { println(it) },
                    lastNameEditText.text.toString(),
                    imageUri
                )
                println("${contactList[contact.id].firstName}  --->  ${contact.firstName}")
                contactList[contact.id] = contact

                editButton.text = getString(R.string.edit)
                editState = false

            } else {
                nameEditText.apply {
                    keyListener = nameEditText.tag as KeyListener?
                }

                phoneEditText.apply {
                    keyListener = phoneEditText.tag as KeyListener?
                }

                lastNameEditText.apply {
                    keyListener = lastNameEditText.tag as KeyListener?
                }

                editButton.text = getString(R.string.save)
                editState = true

            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SAVED_IMAGE_URI_KEY, imageUri)
    }
}