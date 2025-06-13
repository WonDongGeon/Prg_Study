const path = require("path"); // require는 "path" 라이브러리를 들고오는 함수

module.exports={
    mode:"development",
    entry:{main:"./app.js",}, //진입점
    output:{
        filename:"[name].js",
        path:path.resolve(__dirname, "dist")
    }, //출력문
}