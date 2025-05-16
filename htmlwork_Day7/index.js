// let menu=document.getElementsByTagName("li"); //오류발생 li의 개수가 복수이기 때문에 menu는 배열이 됨.(해당 이름을 가진 태그)
// console.log(menu);

// 실행동작 확인은 웹피이지 F12 Console창에서 확인

// //오류발생 : for문을 사용했을 떄 오류가 발생함.
// menu.array.forEach(element => { 
//     console.log(element);  
// });

let menu = document.querySelectorAll("li");
console.log(menu);


/*menu.forEach(Element =>{
    console.log(Element); //출력이 안됨
    Element.addEventListener("click", () => {

    });
})*/

// menu.forEach(function(element) { 
//     console.log(element); //출력이 안됨
//     element.addEventListener("click", () => { // 클릭했을 때 수행
//         console.log(element.innerText); // 클릭한 li의 텍스트를 log함
//     });
// });

menu.forEach(function(element) { 
    console.log(element); //출력이 안됨
    element.addEventListener("click", () => { // 클릭했을 때 수행
        // console.log(element.innerText); // 클릭한 li의 텍스트를 log함
        console.log(`${element.innerText}.html`); // menu1을 누르면 log에 menu1.html로 나옴
        fetch(`${element.innerText}.html`) // fetch가 결과를 가져와야 then을 실행할 수 있음
        .then(resp => resp.text()) // 결과를 resp에 저장하고 resp의 텍스트를 가져오고
        .then(result => { // result에 resp의 텍스트를 저장하여 다음 문장을 실행합니다.
            let main = document.querySelector("main"); 
            main.innerHTML = result;
        })
    });
});