function onWrite(){ console.log('onWrite load');
    let sampleBoard = {"btitle" : "테스트제목" , "bcontent" : "테스트내용" ,
        "bwriter" : "유재석" , "bpwd" : "1234"
    }
    
    let option = {
        method : 'POST',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(sampleBoard)
    }

    fetch('/write',option)
    .then(response => response.json())
    .then(data => {console.log(data);})
    .catch(error => {console.log(error);}); 
}

function onFindAll(){
    console.log('onFindAll load');

    fetch('/findAll')
    .then(response => response.json())
    .then(data => {console.log(data);})
    .catch(error => {console.log(error);})
}

function onFindId(){
    console.log('onFindId load');

    let sampleBno = 3;

    fetch(`/findId?bno=${sampleBno}`)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}

function onUpdate(){
    console.log('onUpdate load');

    let sampleBoard = {"bno" : 2 , "btitle" : "바꿨어" , "bcontent" : "바꿨어"}
    let option = {
        method : 'PUT',
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(sampleBoard)
    }
    fetch('/update',option)
    .then(r => r.json())
    .then(d => console.log(d))
    .catch(e => console.log(e))
}

function onDelete(){
    console.log('onDelete load');

    let sampleBno = 5;
    fetch(`/delete?bno=${sampleBno}`,{method : 'delete'})
    .then(r => r.json())
    .then(d => console.log(d))
    .catch(e => console.log(e))
}