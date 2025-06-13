package member;

import javax.servlet.ServletContext;

public class DBConfig {
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public DBConfig() {}
		
	public DBConfig(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}



	public DBConfig(ServletContext context) {
		this.driver=context.getInitParameter("driver");
		this.url=context.getInitParameter("url");
		this.user=context.getInitParameter("user");
		this.password=context.getInitParameter("password");
		//System.out.println("**driver**:"+driver);
		//System.out.println("**url**:"+url);
		//System.out.println("**user**:"+user);
		//System.out.println("**password**:"+password);
	}

	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBConfig [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
	}
	
	
}
