_print()

function regist(){ 
    const contInput = document.querySelector('.contInput')
    const content = contInput.value
    const todo = {
        "content" : content,
        "status" : false
    }
    let option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(todo)
    }
    fetch('/regist',option)
    .then(r => r.json())
    .then(d => console.log(d))
    .catch(e => console.log(e))
    alert('regist 성공!')
    _print();
    return;
}

// [4] 출력함수
function _print(){
    const todoBottom = document.querySelector('.todoBottom');
    fetch('/print')
    .then(r => r.json())
    .then(d => {
    let todolist = d;
    let HTML = '';
    for (let index = 0; index <= todolist.length-1; index++) {
        const todo = todolist[index]
        HTML += `<div class="contBox ${todo.status? 'success' : ''}">
            <div class="cont"> ${todo.content} </div>
            <div class="contBtns">
                <button onclick="_update(${todo.no})" class="updateBtn">수정</button>
                <button onclick="_delete(${todo.no})" class="deleteBtn">삭제</button>
            </div>
        </div>`
    }
    todoBottom.innerHTML = HTML
    })
    .catch(e => console.log(e))
}

// [5] 수정함수
function _update(no){
    fetch(`/update?no=${no}`,{method : 'PUT'})
    .then(r => r.json())
    .then(d => console.log(d))
    .catch(e => console.log(e))
    alert('변경 성공')
    _print()
    return;
}

// [6] 삭제함수
function _delete(no){
    fetch(`/delete?no=${no}`, {method : 'delete'})
    .then(r => r.json())
    .then(d => console.log(d))
    .catch(e => console.log(e))
    alert('삭제 성공')
    _print()
    return;
}