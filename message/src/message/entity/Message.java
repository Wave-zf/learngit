package message.entity;

public class Message {
	private String id;
	private String name;
	private String password;
	private String texts;
	private String phone;
	private String qq;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		/*try {
			byte []bb=newtexts.getBytes("ios-8859-1");
			newtexts = new String(bb);
		} catch (Exception e) {}
		texts = newtexts;*/
		this.texts=texts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", password=" + password + ", texts=" + texts + ", phone="
				+ phone + ", qq=" + qq + "]";
	}
	
	
	
	
	

}
