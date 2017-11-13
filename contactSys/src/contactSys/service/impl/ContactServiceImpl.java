package contactSys.service.impl;

import java.util.List;

import contactSys.dao.ContactDao;
import contactSys.dao.impl.ContactDaoImpl;
import contactSys.entity.Contact;
import contactSys.service.ContactService;

public class ContactServiceImpl implements ContactService {
	ContactDao dao = new ContactDaoImpl();
	@Override
	public void addContact(Contact contact) {
		dao.addContact(contact);

	}

	@Override
	public void updateContact(Contact contact) {
		dao.updateContact(contact);

	}

	@Override
	public void deleteContact(String id) {
		dao.deleteContact(id);

	}

	@Override
	public List<Contact> findAll() {
		dao.findAll();
		return null;
	}

	@Override
	public Contact findById(String id) {
		dao.findById(id);
		return null;
	}

	@Override
	public boolean checkContact(String name) {
		dao.checkContact(name);
		return false;
	}

}
