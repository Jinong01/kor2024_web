function regist(){
    let name = document.querySelector('.sname');
    let kor = document.querySelector('.skor');
    let math = document.querySelector('.smath');
    let eng = document.querySelector('.seng');

    let sname = name.value;
    let skor = kor.value;
    let smath = math.value;
    let seng = eng.value;

    let student = {
        "sname" : sname,
        "skor" : skor,
        "smath" : smath,
        "seng" : seng
    };
    

    fetch('/regist',{method:'POST', headers: {'Content-Type': 'application/json'}, body : JSON.stringify(student)})
    .then(r => r.json())
    .then(d => console.log(d))
    .catch(e => console.log(e))
    
    alert("등록 성공")

    document.querySelector('.sname').value='';
    document.querySelector('.skor').value='';
    document.querySelector('.smath').value='';
    document.querySelector('.seng').value='';
    return;
}

function printAll(){
    let studentHTML = document.querySelector('.studentlist')
    fetch('/printall')
    .then(r => r.json())
    .then(d => {
        let list = d
        let HTML = 
        '<table><tr><th>학번</th><th>이름</th><th>국어점수</th><th>수학점수</th><th>영어점수</th></tr>'

        for(let index =0; index <= list.length-1; index++){
            student = list[index];
            HTML += `<tr><th>${student.sno}</th><th>${student.sname}</th><th>${student.skor}</th><th>${student.smath}</th><th>${student.seng}</th>`
        }   
        
        studentHTML.innerHTML =`${HTML}</table>`;
    })
    .catch(e => console.log(e))
}

