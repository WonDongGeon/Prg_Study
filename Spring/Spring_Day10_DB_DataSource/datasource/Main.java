package datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		// datasource는 접속정보와 접속을 분리한다.
		// 접속정보를 설정파일에 저장 후 사용(db.properties)
		
		// db접속 정보 얻기
		Properties props = new Properties();

        FileInputStream input 
        = new FileInputStream
        ("D:\\work\\sts-3\\workspace\\jdbc\\src\\main\\java\\datasource\\db.properties");
        props.load(input);

        String driver = props.getProperty("db.driverClassName");
        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        
        //위의 정보를 BasicDataSource 객체에 정보를 입력
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        //획득할 수 있는 것은 Connection객체를 얻을 수 있음
        Connection conn=ds.getConnection();
        System.out.println(conn);
        
        //인터페이스
        DataSource interds=(DataSource)ds;
        Connection  conn2=interds.getConnection();
        System.out.println(conn2);
        
	}

}
