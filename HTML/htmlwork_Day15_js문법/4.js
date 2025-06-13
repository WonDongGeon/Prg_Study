'use strict'
//클래스 : 속성 + 함수(생성자함수 = 클래스명() = constructor())
class Person{
    //java
    //String name;
    //int age;
    constructor(name, age) {
        this.name = name; // this는 이 객체에서 name은 멤버변수
        this.age = age;
    }
    print(){
        console.log(`나의 이름은 ${this.name}입니다.`);
        console.log(`나의 나이는 ${this.age}살 입니다.`);
    }
}
let p1 = new Person();
console.log(p1);
let p2 = new Person("hong", 30);
console.log(p2);
p2.print();

p1.name = "kim";
p1.age = 20;
p1.print();

p1["name"] = "ryu";
p1["age"] = 25;
p1.print();

//getter, setter 함수
class NewPerson {
    constructor(name, age) {
        this._name=name;
        this._age=age;
    }
    get name(){return this._name;}
    get age(){return this._age;}
    set name(value){this._name=value}
    set age(value){this._age=value}
    print() {
        console.log(this.name);
        console.log(this.age);
    }
}

let newp = new NewPerson("park", 40);
console.log(newp._name); //변수를 호출
console.log(newp.name); //함수를 호출
//console.log(newp, name()); //함수로서 호출은 오류발생
newp._name="park2"; //변수에 값을 직접 설정
console.log(newp._name);
newp.name="park3"; //set함수 호출
console.log(newp.name);

//XMLHttpRequest : 비동기식
//fetch() : 동기식