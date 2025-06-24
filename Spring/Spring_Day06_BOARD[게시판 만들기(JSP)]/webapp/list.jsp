<%@page import="board.Writing"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="lombok.ToString"%>
<%@page import="lombok.Getter"%>
<%@page import="lombok.Setter"%>
<%@page import="org.springframework.stereotype.Service"%>
<%@page import="lombok.NoArgsConstructor"%>
<%@page import="lombok.AllArgsConstructor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
/* @NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Writing {
	int id; // 글번호 (자동 증가)
	String title; // 제목
	String author; // 작성자 아이디
	Date createdate; // 작성일자(기본값 : 현재 시간)
	String content; // 내용(본문)
	String attachment; // 첨부 파일(BLOB 데이터 타입 사용)
	int viewcnt; // 조회수 (기본값 0)
	String type; // 게시판 종류 (예 : 공지사항 자유게시판 등)
} */
%>
<%

//sql연결하기 위한 설정(oracle)
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "night";
String password = "night";
Connection conn = DriverManager.getConnection(url, user, password);
System.out.println(conn);

//------------게시글 전체 개수---------------------------------------------------------------

int totalCount=0; //글의 전체 갯수 -> 자동 계산
//String sql = "select count(*) from board"; #1
String sql = "select count(*) as count from board";
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
if(rs.next()) {
	//totalCount = rs.getInt("count(*)"); #1
	totalCount = rs.getInt("count");
}
System.out.println("글의 전체 개수 : " + totalCount);

//------------게시글 전체 페이지 수-----------------------------------------------------------

int pagePerCount=10; //1페이지의 글의 갯수 -> 수동입력
int totalPage=0; //전체페이지 -> 자동계산
totalPage = totalCount/pagePerCount;
System.out.printf("전체페이지:%d\n", totalPage);

//상황적인 부분확인
//전체글이 111개 일 때 페이지수는 12page
//전체글이 110개 일 때 페이지수는 11page
//나머지 연산자를 이용하여 나머지 값이 0인경우, 그렇지 않은 경우
if(totalCount % pagePerCount == 0) {
	totalPage = totalCount/pagePerCount;
} else {
	totalPage = (totalCount/pagePerCount) + 1;
}
System.out.printf("전체페이지:%d\n", totalPage);

//------------게시글 페이지 글 시작과 끝 번호---------------------------------------------------

int requestPage=1; //요청한페이지 or 현재페이지 -> 수동입력
//페이지에 요청 페이지가 전달되는 경우
String _requestPage=request.getParameter("requestPage");
if(_requestPage!=null) {
	requestPage=Integer.parseInt(_requestPage);
}
//http://localhost:8888/board/list.jsp?requestPage=3
//요청한 페이지에 대한 시작글번호와 끝글번호가 필요
//글의 시작번호, 글의 끝번호
//고려사항 : 글의 번호가 순서적으로 되어 있다고 가정
//글의 번호가 순서적으로 되어 있지 않은 경우 oracle rownum, 날짜의 순서 order by 필드명 desc
int startnum=1; //글의 시작번호 -> 자동 계산
int endnum=10; //글의 끝번호 -> 자동 계산
startnum = ((requestPage-1)*pagePerCount) + 1;
endnum = requestPage*pagePerCount;
System.out.printf("요청 페이지 : %d\n", requestPage);
System.out.printf("글 시작번호 : %d\n", startnum);
System.out.printf("글 끝번호 : %d\n", endnum);

//------------게시글 페이지 네비게이트 시작과 끝 번호---------------------------------------------

//시나리오 : 요청한페이지가 1페이지 일 때 시작페이지1, 끝페이지5
//시나리오 : 요청한페이지가 2페이지 일 때 시작페이지1, 끝페이지5
//시나리오 : 요청한페이지가 5페이지 일 때 시작페이지1, 끝페이지5
//시나리오 : 요청한페이지가 6페이지 일 때 시작페이지6, 끝페이지10
//시나리오 : 요청한페이지가 11페이지 일 때 전체페이지가 12페이지 일 때 시작페이지 11, 끝페이지 12
//요청한페이지의 네비게이트 시작페이지 번호, 끝페이지 번호
//requestPage=1;
int startPage = 0; //네비게이트 시작번호 -> 자동 계산
int endPage = 0; //네비게이트 시작번호 -> 자동 계산
startPage = ((requestPage-1)/ 5 * 5) + 1;
endPage = startPage + (5-1);
if(endPage > totalPage) {
	endPage = totalPage;	
}
System.out.printf("네비게이트 시작페이지 : %d\n", startPage);
System.out.printf("네비게이트 끝페이지 : %d\n", endPage);


//------------게시글 페이지 네비게이트 클릭 활성화, 비활성화---------------------------------------

//이전페이지 다음페이지 표시 여부 확인 속성
boolean isPre=false;
boolean isNext=true;
//시나리오: 요청한 페이지 1~5페이지일 경우 이전페이지 클릭 비활성화
//시나리오: 요청한 페이지 6~10페이지일 경우 이전페이지, 다음페이지 클릭 활성화
//시나리오: 요청한 페이지 11페이지일 경우 이전페이지 활성화, 다음페이지 비활성화
if(requestPage > 5) isPre=true;
//시나리오 요청한 페이지 : 11page, 전체 페이지 : 12page, 마지막 페이지 : 12page
//11페이지에서 전체 페이지는 endPage:15page 
if(totalPage >= endPage) isNext=false;
System.out.printf("네비게이트 이전페이지링크표시 : %b\n", isPre);
System.out.printf("네비게이트 다음페이지링크표시 : %b\n", isNext);

//------------게시글 요청한 페이지의 게시판 리스트-----------------------------------------------
//요청한 페이지의 게시판 리스트
List<Writing> list = new ArrayList();
//startnum=1; // 글의 시작번호
//endnum=10; // 글의 끝번호
sql = "select * from (select rownum rid, t1.* from (select * from board order by id asc) t1) where rid >= ? and rid <= ?";

StringBuffer sql2 = new StringBuffer();
sql2.append("select * from");
sql2.append("(select rownum rid, t1.* from");
sql2.append("(select * from board order by id asc) t1)");
sql2.append("where rid >= ? and rid <= ?");

ps = conn.prepareStatement(sql2.toString());
System.out.println(sql2.toString());

ps.setInt(1, startnum);
ps.setInt(2, endnum);
rs = ps.executeQuery();

while(rs.next()) {
	System.out.println(rs.getInt("id"));
	Writing write = new Writing();
	write.setId(rs.getInt("id"));
	write.setTitle(rs.getString("title"));
	write.setAuthor(rs.getString("author"));
	//write.setCreatedate(rs.getDate("createdate"));
	write.setViewcnt(rs.getInt("viewcnt"));
	
	list.add(write); 
}
request.setAttribute("list", list);
System.out.println(list);
rs.close();
ps.close();
conn.close();
%>

<!-- 위쪽은 jsp코드로서 데이터를 획득/아래쪽은 데이터로 화면표시 -->
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>게시판</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <h2 class="mb-4">📋 게시판()</h2>
  <div><%=totalCount %>개의 글(현재<%=requestPage%>page/전체<%=totalPage%>page)</div>
  
  <table class="table table-hover table-bordered text-center">
    <thead class="table-dark">
      <tr>
        <th scope="col" name="id">번호</th>
        <th scope="col" name="title">제목</th>
        <th scope="col" name="author">작성자</th>
        <th scope="col" name="createdate">작성일</th>
        <th scope="col" name="viewcnt">조회수</th>
      </tr>
    </thead>
    <tbody>
      <!-- Writing 데이터를 반복처리 -->
      <c:forEach var="board" items="${list}">
      <tr>
        <td value="id">${board.id }</td>
        <td value="title">${board.title}</td>
        <td value="author">${board.author}</td>
        <td value="createdate">${board.createdate}</td>
        <td value="viewcnt">${board.viewcnt}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>

  <!-- 페이지 네비게이션 -->
  <nav aria-label="페이지 네비게이션">
    <ul class="pagination justify-content-center">
            <% 
            //if(isPre){ 
            %>
                <li id="pre" class="page-item disabled">
                    <a class="page-link" href="/board/list.jsp?requestPage=<%=requestPage-1%>" tabindex="-1">이전</a>
                </li>
            <% 
            //}
            if(isPre){
            	System.out.println("pre활성화");
            %>
            <script>
         // 요청할 페이지가 1 ~ 5 페이지일 경우
            document.getElementById("pre").className +="disabled";
            //document.getElementById("pre").disabled="false"; 
            //document.getElementById("pre").setAttribute("disabled", false);
            //document.getElementById("pre").removeAttribute("disabled");
            </script>
            <%	
            }else{
            %>
            <script>
         // 요청할 페이지가 1 ~ 5 페이지를 초과할 경우
            document.getElementById("pre").disabled="true"; 
            </script>
            <%}%>    
                <%for(int i=startPage;i<=endPage;i++){ %>
                <% 
                	//문제:요청한페이지와 화면에 표시될 페이지가 같은 경우 active를 class에 추가하기
                	if(requestPage==i) { // 요청한 페이지와 표시될 페이지가 같을 경우
                %>
                	<li class="page-item active"> <!-- active로 선택된 페이지 표시 -->
                	<a class="page-link" href="/board/list.jsp?requestPage=<%=i%>"><%=i%></a>
                	</li>
                <% 
                	}else{ // 같지 않을 경우
                %>
                	<li class="page-item">
                	<a class="page-link" href="/board/list.jsp?requestPage=<%=i%>"><%=i%></a>
               	 	</li>
                <%	
                	}
                } 
                %>
                
             <% if(isNext){ %>
                <li class="page-item">
                    <a class="page-link" href="/board/list.jsp?requestPage=<%=startPage+5%>">다음</a>
                </li>
            <%}%>
     </ul>
   </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>