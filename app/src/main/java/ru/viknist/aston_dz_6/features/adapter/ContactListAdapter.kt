package ru.viknist.aston_dz_6.features.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.viknist.aston_dz_6.R
import ru.viknist.aston_dz_6.model.Contact

class ContactListAdapter(
    Context: Context,
    private val contacts: List<Contact>,
    private val onClickAction: (Contact) -> Unit
) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(Context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
        holder.itemView.rootView.setOnClickListener { onClickAction(contact) }
    }

    override fun getItemCount(): Int = contacts.size

    private fun getItem(position: Int): Contact = contacts[position]

    class ViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val imageContact = itemView.findViewById<ImageView>(R.id.imageContact)
        val firstName = itemView.findViewById<TextView>(R.id.firstName)
        val lastName = itemView.findViewById<TextView>(R.id.lastName)
        val phoneNumber = itemView.findViewById<TextView>(R.id.phoneNumber)

        fun bind(contact: Contact) {
            firstName.text = contact.firstName
            lastName.text = contact.lastName
            phoneNumber.text = contact.phone
            imageContact.load(contact.imageURI)
        }
    }

}