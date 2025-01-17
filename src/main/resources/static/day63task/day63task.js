function regist(){
    let todoInput = document.querySelector('.todoInput');
    let todo = todoInput.value;

    let dto = { "tcontent" : todo}

    fetch('/regist',
        {
            method:'POST',
            headers : {'Content-Type':'application/json'},
            body : JSON.stringify(dto)
        })
    .then(r => r.json())
    .then(d => {
        console.log(d); 
        if(d==true){alert("등록 성공")
        } else{alert("등록 실패")}
        printall()
    })
    .catch(e => console.log(e))

}

function printall(){
    let todoList = document.querySelector('.todoList')
    let HTML = ''

    fetch('/printall')
    .then(r => r.json())
    .then(d => {
        let list = d;
        for(let index = 0; index <= list.length-1; index++){
            let dto = list[index];
            HTML += `<div class="todo">
            <div>${dto.tcontent}</div>
            <div><button onclick="update(${dto.tno})" type="button">수정</button>
            <button onclick="_delete(${dto.tno})" type="button">삭제</button></div></div>`
        }
        todoList.innerHTML = HTML;
    })
    .catch(e => console.log(e))
}

function update(tno){
    let updto = {"tno" : tno}
    fetch('/update',{
        method : 'PUT',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(updto)
    })
    .then(r => r.json())
    .then(d => {
        console.log(d);
        if(d==true){alert("수정 성공")
        } else{alert("수정 실패")}
        printall()
    })
    .catch(e => console.log(e))
}

function _delete(tno){
    fetch(`/delete?tno=${tno}`,{method : 'delete'})
    .then(r => r.json())
    .then(d => {
        console.log(d); 
        if (d==true){alert("삭제 성공")
        } else{alert("삭제 실패")}
        printall()
    })
    .catch(e => console.log(e))
}