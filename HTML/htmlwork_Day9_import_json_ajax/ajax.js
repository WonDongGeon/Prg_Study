//ajax통신(비동기 자바크스립트 통신)
//무료 JSON데이터
/*
https://api.coingecko.com/api/v3/coins/bitcoin
https://jsonplaceholder.typicode.com/users
https://jsonplaceholder.typicode.com/posts
https://jsonplaceholder.typicode.com/comments
*/

let xhttp = new XMLHttpRequest();
console.log(xhttp); //객체가 생성됐는지 확인
// xhttp.open("get", "https://api.coingecko.com/api/v3/coins/bitcoin"); //get방식요청, 요청할 API 주소
xhttp.open("get", "http://127.0.0.1:5500/books.json");
xhttp.send(); // 준비된 요청을 실제로 서버에 보냅니다.
xhttp.onload=function() { // 요청이 완료되고 응답을 받았을 때 실행되는 함수
    console.log(xhttp.responseText); // 응답 받은 JSON 텍스트를 받아오는 객체
    const body = document.querySelector("body"); 
    console.log(body);
    let books = JSON.parse(xhttp.responseText);

    body.textContent=books[0].title; 
    body.textContent+=books[1].title; 
    body.textContent+=books[2].title; 

    console.log(typeof books);
    console.log(books.length);

    body.innerHTML += "-----기본 반복문 사용-----<br>";
    for(i=0; i<books.length; i++) {
        body.innerHTML += books[i].title+"<br>";
    }

    body.innerHTML += "-----forEach 반복문 사용-----<br>";
    books.forEach(element => {
        body.innerHTML +=element.title+"<br>";
    });

    body.innerHTML += "-----for in(index==번호) 반복문 사용-----<br>";
    for (const index in books) {
        body.innerHTML +=books[index].title+"<br>";
    }

    body.innerHTML += "-----for of(객체반환) 반복문 사용-----<br>";
    for (const obj of books) {
        body.innerHTML += obj.title+"<br>";
    }

    /* 특정조건을 이용하여 json 객체를 찾기 방법(books에서 객체를 book에 넘기고
        book.title과 문자열이 일치할 때 객체를 반환 */

    var result = books.find(book => book.title === "jJavaScript 기초");
    console.log(result);

    // 문제 books.json은 ajax 통신으로 가져오고 html문서에 책찾기 : input(text)칸 + input(submit)칸
    // div : 
    /*
        찾는 책의 모든 정보 표시
        제목 : 
        저자 : 
        가격 : 
    */
}