const HtmlWebpackPlugin = require("html-webpack-plugin");
//HTML 파일을 자동으로 생성하거나 기존 템플릿을 기반으로 스크립트 번들을 삽입
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
//CSS를 별도의 파일로 추출 (기본적으로 JS 안에 포함된 CSS를 따로 분리)
const path = require("path"); // require는 "path" 라이브러리를 들고오는 함수
//Node.js의 내장 모듈. 경로 설정 시 사용 (__dirname은 현재 파일 위치)

module.exports={
    mode:"development", // 개발용 설정 (디버깅이 쉬움, 난독화 안 됨). 배포 시에는 "production"으로 변경

    entry:{index:"./index.js",}, //진입점

    output:{
        path:path.resolve(__dirname, "freedirectory"), // __dirname : 현재 경로, freedirectory라는 폴더를 만들 수 있음
        filename:"[name].js",
    }, 

    module:{
        rules:[
            {
            test:/\.css$/i, //  \ : 앞의 모든 파일,  / : 로 끝나는 모든 파일
            use:[MiniCssExtractPlugin.loader, "css-loader"]
            }
        ]
    },

    plugins:[
        new HtmlWebpackPlugin({
            template:'./index.html',
            filename:'index.html',
            chunks:['index'] // chunks : 덩어리(규격)
        }),
        new MiniCssExtractPlugin(),
    ]
}