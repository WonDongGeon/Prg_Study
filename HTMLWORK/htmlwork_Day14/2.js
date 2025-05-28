'use strict' //문법적으로 오류 확인 역할
var a=10;
console.log(a);

let b=20;
console.log(b);

{
    console.log(a);
    console.log(b);
    var c=100; // var는 한번 선언되면 구역 밖에서도 계속 유지됨.
    let d=200; // let은 선언된 구역에서만 유지됨.
    //var는 엄격하지 않고, let은 엄격함
}
console.log(c);
// console.log(d); //오류발생

console.log('오류 후 실행이 안됨'); //오류발생시 다음으로 코드가 넘어가지 않음
//오류가 발생하면 그 오류가 발생한 코드 다음에 실행되어야할 코드는 동작하지 않음

const e= "한번선언후 갑 변경 불가";
console.log(e);
// e="값을 변경함"; //const 값 변경시 오류발생

let f = 1;
let g ='1';
let h ="1";
let i =`1`;
console.log(typeof f);
console.log(typeof g);
console.log(typeof h);
console.log(typeof i);

console.log(f == g);              // 느슨한 동등 비교
console.log(f === g);             // 엄격한 동등 비교
console.log(f === parseInt(g));   // 문자열을 정수로 변환 후 비교
console.log(String(f) === g);     // f를 문자열로 변환 후 비교
console.log(f.toString() === g);  // toString()으로 변환 후 비교
console.log("" + f === g);        // 문자열 연결로 변환 후 비교
console.log(`${f}` === g);        // 템플릿 리터럴로 문자열화 후 비교

//문자+숫자는 문자열이 우선한다.
console.log('5+5'); //문자
console.log('5'+'5'); //문자
console.log(5+String(5)); //문자
console.log(5+Number('5')); //숫자
console.log(5+parseInt('5')); //숫자
console.log(5+parseFloat('3.14')); //숫자

//변수의 값 상태
//null : 객체가 생성되지 않은 상태
//undefined : 값이 정의되지 않은 상태
//NaN(Not a Number) :잘못된 입력값

var j;
console.log(j);
j=null;
console.log(j);
j=undefined;
console.log(j);
console.log(0/0); // NaN
console.log(10/0); // Infinity 무한대
console.log(isNaN(0/0)); // NaN인지 확인하는 함수

// let xhttp = new XMLHttpRequest1();
// console.log(xhttp);

// let xhttp = new XMLHttpRequest();
// console.log(xhttp);
// xhttp.open("get", "bootstrap1.html");
// let result = xhttp.send();