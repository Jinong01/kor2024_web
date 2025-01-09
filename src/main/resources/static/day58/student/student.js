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

