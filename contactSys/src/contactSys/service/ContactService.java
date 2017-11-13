package contactSys.service;

import java.util.List;

import contactSys.entity.Contact;

public interface ContactService {
	public void addContact(Contact contact);//�����ϵ��
	public void updateContact(Contact contact);//�޸���ϵ��
	public void deleteContact(String id);//ɾ����ϵ��
	public List<Contact> findAll();//��ѯ������ϵ��
	public Contact findById(String id);//����id������ϵ��
	public boolean checkContact(String name);//�ж��Ƿ�����
	
}
