import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbc_03 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "night"; 
		String pwd = "night"; 
		
		Connection con = null; 
		PreparedStatement pt1 = null; 
		String sql01 = null;

       try {
           Class.forName(driver);
           con = DriverManager.getConnection(url, user, pwd);
           Scanner scan = new Scanner(System.in);
           
           System.out.print("게시글 작성자 >>");
           String bname = scan.nextLine();
             
           System.out.print("게시글 제목 >>");
           String btitle = scan.nextLine();

           System.out.print("게시글 내용 >>");
           String bcont = scan.nextLine();
         
           sql01 = "insert into tbl_board7 (bno, bname, btitle, bcont, bdate) values (bno_seq2.nextval," + "?,?,?,sysdate)";
           		
           pt1 = con.prepareStatement(sql01);
           pt1.setString(1, bname);
           pt1.setString(2, btitle);
           pt1.setString(3, bcont);
 
           int re = pt1.executeUpdate();

           if(re == 1) {
            System.out.println("게시물 저장 성공");
           }

       }catch(Exception e) { 
			e.printStackTrace();
		}finally {
		    try {					
			   if(pt1 != null) pt1.close();
                if(con != null) con.close();
		    }catch(Exception e) {e.printStackTrace();}	
		}//finally
	}

}
