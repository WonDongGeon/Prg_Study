import ReactDOM from "react-dom/client";
 import React,{ useEffect, useState } from "react";

 function PhonebookList() {
    //useEffect(); 호출될 때 데이터가 수신될 경우 이를 저장할 상태변수 미리 선언
    const [contacts, setContacts]=useState([]); // 배열


    //최초 호출이 한번 일어난다!!
    useEffect(()=>{
        console.log("호출");
        const xhttp = new XMLHttpRequest();
        xhttp.open("get", "data.json");
        xhttp.send();
        xhttp.onload=function() {
            let data = JSON.parse(xhttp.responseText);
            setContacts(data);
            console.log(contacts);

        }
    });
    return <>
    <div>  
        {contacts.map(contact => (
        <ul style={{listStyle:'none', border:'1px solid black', padding:0}}>
            <li>{contact.id}</li>
            <li>{contact.name}</li>
            <li>{contact.phone}</li>
        </ul>
        ))}  
    </div>
    </>
 }

 const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<PhonebookList />);

// import ReactDOM from "react-dom/client";
// import { BrowserRouter, Routes, Route } from "react-router-dom";
//  import { useEffect, useState } from "react";
// import Todos from "./Todos";
// import { memo } from "react";

// // import Layout from "./pages/Layout.js";
// // import Home from "./pages/Home.js";
// // import Blogs from "./pages/Blogs.js";
// // import Contact from "./pages/Contact.js";
// // import NoPage from "./pages/NoPage.js";


// //<App/> 태그는 외부에 있는 함수를 가지고와서 사용하는 태그
// //내부적으로 App을 작성

// // function App() {
// //     //전달받은 데티터가 있다고 가정할 경우(배열형식)
// //     //<Todos>태그는 함수의 Todos(), todos={todos}는 속성=값으로서 함수의 입력값
// //     //map을 이용하여 반복처리
// //     const [todos, setTodos] = useState(["todo 1", "todo 2", "todo 3"]);
// //     return <>
// //           <div>
// //           <Todos todos={todos} />
// //           </div>
// //         </>

// //     // const [count, setCount] = useState(0);
// //     // //어떤 기능을 사용할 것인가?
// //     // //값을 증가시키는 기능
// //     // function increment() {
// //     //     //값을 저장할 변수가 필요하고 이 변수를 App내에 선언
// //     //     // setCount(count++); //오류 발생
// //     //     // setCount(c++) //오류 발생
// //     //     // setCount(c=c+1) //오류 발생
// //     //     setCount((count)=> count+1); //정상 실행
// //     // }
// //     // return <>
// //     //     <div>
// //     //     Count: {count}
// //     //     <button onClick={increment}>+</button>
// //     //     </div>
// //     // </>
// // }
// // function Tools({todos}) {
    
// //     return (
// //         <>
// //           {todos.map((todo, index) => {
// //             return <p key={index}>{todo}</p>;
// //           })}
// //         </>
// //     );
// // }

// //사용할 기능을 함수로 만들기)상태변수선언, 상태변화실행함수(useEffect), 화면에 표시할 return
// function Counter() {
//     //상태변수선언
//     const [count, setCount] = useState(0);

//     //상태변화실행함수(useEffect)
//     useEffect(() => {
//         console.log(`현재 카운터:${count}`)
//     },[count]);

//     //화면에 표시할 return 태그(<> </> or () 멀티라인가능)
//     return (
//         <div>
//         <div>카운터:(count)</div>
//         <button onClick={()=>setCount(count+1)}>숫자 증가하기</button>
//         </div>
//     );
// }

// // export default function App() {
// //   return (
// //     <BrowserRouter>
// //       <Routes>
// //         <Route path="/" element={<Layout />}>
// //           <Route index element={<Home />} />
// //           <Route path="blogs" element={<Blogs />} />
// //           <Route path="contact" element={<Contact />} />
// //           <Route path="*" element={<NoPage />} />
// //         </Route>
// //       </Routes>
// //     </BrowserRouter>
// //   );
// // }

// //메인 실행코드
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<App />);
