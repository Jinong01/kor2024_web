console.log('member.js open');

function signup(){
    const midInput = document.querySelector('.midInput');
    const mpwdInput = document.querySelector('.mpwdInput');
    const mnameInput = document.querySelector('.mnameInput');
    const mphoneInput = document.querySelector('.mphoneInput');

    const mid = midInput.value;
    const mpwd = mpwdInput.value;
    const mname = mnameInput.value;
    const mphone = mphoneInput.value;

    const member={
        mid : mid,
        mpwd : mpwd,
        mname : mname,
        mphone : mphone
    }

    fetch('/signup.do',
        {method : 'POST', headers : {'Content-Type' : 'application/json'}, 
            body : JSON.stringify(member)})
    .then(r => r.json())
    .then(data => {console.log( data );
          if( data == true ){
          alert('회원가입 성공 했습니다.');
          location.href="/login"
          } else{ alert('회원가입 실패 했습니다.');}})
    .catch(e => console.log(e))
    return;
}


function login(){
    const midInput = document.querySelector('.midInput');
    const mpwdInput = document.querySelector('.mpwdInput');

    const mid = midInput.value;
    const mpwd = mpwdInput.value;

    fetch(`login.do?mid=${mid}&mpwd=${mpwd}`)
    .then(r => r.json())
    .then(d => {console.log(d)
        if(d==true){
            alert('로그인 성공')
            location.href="/"
        } else{alert('로그인 실패')}
    })
    .catch(e => console.log(e))
}