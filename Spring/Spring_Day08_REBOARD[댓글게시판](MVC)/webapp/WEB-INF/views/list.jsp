<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판 테이블[pageList]</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">게시판</h2>
        <div>${pageList.totalCount}개의 글
        (현재${pageList.currentPage}page/전체${pageList.totalPage}page)
        <button class="btn btn-primary" 
        onclick="location.href='/reboard/writeform'">글쓰기</button>
        
        
        <table class="table table-bordered table-hover">
            <thead class="table-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일</th>
                    <th scope="col">조회수</th>
                </tr>
            </thead>
            <tbody>
                <!-- Writing 데이터를 반복처리 -->
                <c:forEach var="board" items="${pageList.list}">
                <tr onclick="location.href='/reboard/view?id=${board.id}'">
                    <td name="id">${board.id}</td>
                    <td name="title">
                    
                    <!-- tab횟수에 따라 re 이미지를 반복 -->
                    <c:forEach begin="1" end="${board.tab}">
                    <img src="/static/reply_icon.gif" width="20px">
                    </c:forEach>
                    
                    ${board.title}
                    
                    <!-- attachment의 파일이 존재하는지 여부를 확인하고 파일이미지표현 -->
                    <c:if test="${not empty board.attachment}">
                    <img src="/static/file.png" width="20px">
                    </c:if>
                    
                    </td>
                    <td name="author">${board.author}</td>
                    <td name="createdate">
                    <fmt:formatDate value="${board.createdate}" pattern="yyyy/MM/dd"/>
                    </td>
                    <td name="viewcnt">${board.viewcnt}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 페이지 네비게이션 -->
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
            
               <li id="pre" class="page-item ${pageList.pre ? '' : 'disabled'} ">
                    <a class="page-link" href="/reboard/list?requestPage=${pageList.startPage-5}" tabindex="-1">이전</a>
               </li>
            
             
             <c:forEach begin="${pageList.startPage}" end="${pageList.endPage}" 
             step="1" var="i">
             	<c:if test="${pageList.currentPage eq i }">
             	<li class="page-item">
                <a class="page-link active" href="/reboard/list?requestPage=${i}">${i}</a>
                </li>
             	</c:if>
             	
             	<c:if test="${pageList.currentPage ne i }">
             	<li class="page-item">
                	<a class="page-link " href="/reboard/list?requestPage=${i}">${i}</a>
                </li>
             	</c:if>
             </c:forEach>
               
             <c:if test="${pageList.next}">
                <li class="page-item">
                    <a class="page-link" 
                    href="/reboard/list?requestPage=${pageList.startPage+5}">다음</a>
                </li>
             </c:if> 
             </ul>
        </nav>
    </div>

    <!-- Bootstrap JS (선택사항) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>