console.log('test');

//객체형식
let obj1={"name":"hongkildong", "age":23,}
console.log(obj1);
let obj2={"name":"hongkildong", "age":"23",}
console.log(obj2);

console.log(obj1.name); // obj1에서 name이라는 키의 값을 가져옴
console.log(obj1["name"]); // 위와 똑같음


//json 형식
let strobj1='{"name":"hongkildong", "age":"30"}';
// let strobj2="{"name":"hongkildong", "age":"30",}"; //오류
let strobj3="{\"name\":\"hongkildong\", \"age\":\"30\"}";
console.log(strobj1);

//문자열 표현방법
let str1 = "Hello";
let str2 = "Hello2";

//주의사항
//네트워크를 통해서 데이터 전달될 때는 문자열 전달
//문자열로 받은 데이터를 json형식일 때 객체로 변환이 가능
let obj4 = JSON.parse(strobj1); //문자열 strobj1을 가져와 json형식으로 변환하여 obj4에 저장 
console.log(obj4.name);
console.log(obj4.age);
console.log(typeof obj4);

//객체를 문자열로 받아서 저장
console.log(typeof JSON.stringify(obj4));

//객체의 조합
//속성만을 사용한 객체 {"name":"hongkildong", "age":"30"}
//속성+함수
let obj5 = {
    "name":"hongkildong", 
    "age":"30", 
    "callname" : function(name) {console.log(name)}, 
    "callage" : function(age) {console.log(age)}
}

//객체의 key는 변수이지만 함수가 저장된 경우 함수처럼 사용가능하다.
obj5.callname(obj5.name);
obj5["callage"](obj5.age);

//변수에 함수를 입력하여 사용하는 방법
let myfunc1 = function() {
    console.log('hello myfunc');
}
myfunc1();

let myfunc2=()=>{
    console.log('hello myfunc2');
}
myfunc2();

function myfunc3(){
    console.log('hello myfunc3');
}
let myfunc4 = myfunc3;
myfunc4();

let myfunc5 = myfunc4 = myfunc3;
myfunc5();
myfunc4();
myfunc3();


let arr = ["apple", "banana", "mango"]; // 1차원 배열
console.log(typeof arr); //object
console.log(arr[0]);

let arr2 = [ // 2차원 배열
    {"name":"kim", "age":"20"},
    {"name":"hong", "age":"30"},
    {"name":"won", "age":"40"}
]
console.log(arr2[0]['name']);
console.log(arr2[1]['name']);
console.log(arr2[2]['name']);


let obj6= { // 배열 안에 함수
    "name":"kim", 
    "age":"20", 
    "intro":function(name, age, fav){
        console.log(`my name is ${name}`);
        console.log(`my age is ${age}`);
        console.log(`my fav is ${fav}`);
    },
    "fav":["apple", "banana", "mango"],
    "bestfriend" : {"name" : "park", "age" : 10,},
    "firends" : [
        {"name" : "lee", "age" : 12},
        {"name" : "ryu", "age" : 13},
        {"name" : "sin", "age" : 14}
    ]
}

// 위 배열 접근 방법 
obj6.intro(obj6.name, obj6.age, obj6.fav); 
console.log(obj6.bestfriend["name"]); // park
console.log(obj6.bestfriend.age); // 10
console.log(obj6.firends[0].name); // lee
console.log(obj6["firends"][1]["name"]); // ryu