// [POST 전송시]
// const option = {
//     method : 'POST',
//     Headers : {'Content=Type' : 'application/json'},
//     body : JSON.stringify(전송할객체)
// }

// fetch('자바컨트롤러URL' , 옵션)
// .then(response => response.json())
// .then(data => {응답결과코드})
// .catch(error => {오류결과코드})

// [1] 글쓰기 함수
function _write(){ // write는 JS함수중에 이미 있어서 중복이다.

    // [1] input 마크업의 입력받은 값을 갖고 온다.
    let titleInput = document.querySelector('.titleInput');
    let contentInput = document.querySelector('.contentInput')
    let pwdInput = document.querySelector('.pwdInput')

    let title = titleInput.value;
    let content = contentInput.value;
    let pwd = pwdInput.value;

    // [2] 입력받은 값들을 객체화.
    let board = {title : title, content : content, pwd : pwd};

    // [3] fetch 함수를 이용한 자바의 컨트롤러에게 입력받은 값 전달하고 응답받기
    const option = {
        method : 'POST',
        Headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(board)
        // INPUT 으로 부터 입력받은 값들을 JSON형식의 문자열타입으로 자바에게 전송
    }
    fetch('/day52/write' , option)
    .then(response => response.json()) // .then(매개변수 => 매개변수.json())
    .then(data => {             // .then(매개변수/응답 값 => {응답결과코드})
        // [4] 응답 결과에 따른 메세지를 출력한다.
        if(data==true){alert('write success');
            findAll()
        } 
        else {alert('write fail')}
    })
    .catch(error => {console.log(error)})
    findAll()
}

findAll()
function findAll(){

    fetch('/day52/findall' )
    .then(r => r.json())
    .then(data => {console.log(data)});

    
    
}