package net.addradio.services.yellow_pages.factories;

import https.addradio_net.services.yellow_pages.v1.ContactType;

public class ContactFactory extends TestFactory<ContactType> {

    public ContactFactory withAddress(String value) {
        record.setAddress(value);
        return this;
    }

    public ContactFactory withEmail(String value) {
        record.setEmail(value);
        return this;
    }

    public ContactFactory withPhone(String value) {
        record.setPhone(value);
        return this;
    }
}
