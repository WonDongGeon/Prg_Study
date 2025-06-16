package mail;

public class MailData {
	private String recvemail;
	private String subject;
	private String content;
	
	public MailData() {
		// TODO Auto-generated constructor stub
	}

	public MailData(String recvemail, String subject, String content) {
		this.recvemail = recvemail;
		this.subject = subject;
		this.content = content;
	}

	public String getRecvemail() {
		return recvemail;
	}

	public void setRecvemail(String recvemail) {
		this.recvemail = recvemail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MailData [recvemail=" + recvemail + ", subject=" + subject + ", content=" + content + "]";
	}
	
	
}
