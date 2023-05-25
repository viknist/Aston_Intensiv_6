package ru.viknist.aston_dz_6.features

import com.github.javafaker.Faker
import ru.viknist.aston_dz_6.model.Contact

object ContactList {
    val contactList: MutableList<Contact> by lazy { createListData() }
}

private fun createListData() :MutableList<Contact>{
    val list = mutableListOf<Contact>()
    val faker = Faker()
    for (i in 0..100){
        val contact = Contact(
            id = i,
            phone = getRandomPhone(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            imageURI = getImageUri(i)
        )
        list.add(contact)
        println(contact)
    }
    return list
}

private fun getRandomPhone(): String{
    return "+${(70000000000..79999999999).random()}"
}

private fun getImageUri(id: Int): String{
    return "https://loremflickr.com/320/320/cat?random=$id"
}