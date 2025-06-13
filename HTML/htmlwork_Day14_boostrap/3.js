'use strict'
//객체:{} , "{}":JSON형식
//배열:[] (객체)

function add(a, b) {
    return a+b;
} 

let copyadd = add;
console.log(copyadd(10,20));

//함수명 = 변수명처럼 사용, 함수이름은 주소 또는 위치
let minus = (a,b) => {
    return a-b;
}
console.log(minus(20,10));

minus = function(a, b) {
    return a-b;
}
console.log(minus(20,10));

minus = function minus2(a, b) {
    return a-b;
}
console.log(minus(30,10));

let fff;
let ff;
let f;
fff=ff=f=minus;
console.log(fff(1,2));
console.log(ff(3,6));
console.log(f(4,8));

//배열을 선언하는 방법(객체) []
let arr=[];
console.log(typeof arr);
console.log(arr);

let arr2 = new Array();
console.log(typeof arr2);
console.log(arr2);

//객체를 선언하는 방법(객체) {}
let obj = {};
console.log(typeof obj);
console.log(obj);

let obj2 = new Object();
console.log(typeof obj2);
console.log(obj2);

//배열객체와 객체를 구별하는 방법
console.log(Array.isArray(arr)); 
console.log(Array.isArray(obj));

//배열에 값을 입력하기(FILO : First In Last Out)
arr = ["banana", "apple"];
console.log(arr);
arr.push("melon");
console.log(arr);
console.log(arr.pop()); // 뒤에 들어온 배열 값이 삭제됨.
console.log(arr);

arr2 = new Array(1,2,"3","4");
console.log(arr2);

let arr3 = [];
let insa = 'hello';
console.log(insa);
arr3=insa; //arr3은 단순히 문자열
arr3=[...insa]; // [...문자열변수] 배열로 분리
console.log(arr3);

let arr4 =insa.split(); //space로 분리
console.log(arr4); //분리할게 없을 경우 단일배열

arr4= insa.split(""); //한문자씩 분리
console.log(arr4); //문자열 한자한자 분리

let arr5=["banana", "apple", "melon"];
let arr6=["banana", "apple", "melon"];
let arr7="['banana', 'apple', 'melon']";
console.log(Array.isArray(arr5));
console.log(arr5);
console.log(Array.isArray(arr6));
console.log(arr6);
console.log(Array.isArray(arr7));
console.log(arr7);

//Q.문자열 형태의 배열을 입력받을 경우(arr7)이 데이터를
//배열 객체로 변환하시오.
// [ ]를 제거시키시오.
console.log(arr7.substring(1,arr7.length-1));
arr7 = arr7.replace("[", "");
arr7 = arr7.replace("]", "");
console.log(arr7);
arr7 = arr7.replaceAll("'","");
console.log(arr7.split(","));

let arr8="['banana', 'apple', 'melon']";
let arr9='["banana", "apple", "melon"]'; // JSON형식
console.log(JSON.parse(arr9)); // 변환하여 자동으로 배열 객체로 만듦
// console.log(JSON.parse(arr8)); //"[' ']"는 오류발생
//즉 json형식은 key와 value를 ""으로 묶어야 가능

let json3="{'name':'hong', 'age':'23'}"; //오류발생
let json4='{"name":"hong", "age":"23"}';
let json5='{\"name\":\"hong\", \"age\":\"23\"}';
console.log(JSON.parse(json5));
//중요사항:배열 또는 객체는 ""으로 값을 처리하라.

arr5=["banana", "apple", "melon"];
//배열을 문자열로 만들경우 join()함수 이용
console.log(arr5.join()); //기본이 ,로 문자열합해짐
console.log(Array.isArray(arr5.join()));
console.log(arr5.join("-"));
console.log(arr5.toString());
console.log(JSON.stringify(arr5)); //JavaScript객체나 배열을 JSON 문자열로 변환

//객체
let obj5={"name":"kim", "age":"20"};
console.log(obj5);

let firstname = "park";
let age = 23;
let person = {"name":firstname, "age":age};
console.log(person);

person.name = "ryu";
person.age = 30;
console.log(person);

person["age"]=35;
console.log(person);

//for문은 for(초기값;제어값;증가값), forEach, for( in ), for( of ) 