const id = document.getElementById("testid");
const pwd1 = document.getElementById("pswd1");
const pwd2 = document.getElementById("pswd2");
const nickname = document.getElementById("nickname");

const idBtn = document.getElementById("idBtn");
const pwBtn = document.getElementById("pwBtn");
const nickBtn = document.getElementById("nickBtn");
const backBtn = document.getElementById("backBtn");
const joinBtn = document.getElementById("joinResultBtn");

function handleCheckId(){
    console.log(id.style.length);
    if (id.style.length == 0){
        alert("이미 존재하는 아이디입니다.");
    } else{
        alert("사용 가능한 아이디입니다.");
    }
}

function handleCheckPw(){
    console.log(pwd1.value);
    console.log(pwd2.value);
    if(pwd1.value.length != '0' && pwd2.value.length != '0'){
        if (pwd1.value == pwd2.value){
            alert("비밀번호가 일치합니다.");
        } else{
            alert("비밀번호가 일치하지않습니다.");
        }
    }
}

function handleCheckNick(){
    console.log(nickname.value.length);
    if (nickname.value.length == '0'){
        alert("이미 존재하는 닉네임임입니다.");
    } else{
        alert("사용 가능한 닉네임입니다.");
    }
}

function handleBack(){
    location.href="/";
}

function handleLogin(){
    if (id.value.length != '0' && pwd1.value == pwd2.value
    && nickname.value.length != '0'){
        alert(`${nickname.value}님 환영합니다.`);
        lecation.href = "/";
    } else{
        alert("회원정보를 모두 입력해주세요");
    }
}

idBtn.addEventListener("click", handleCheckId);
pwBtn.addEventListener("click", handleCheckPw);
nickBtn.addEventListener("click", handleCheckNick);
backBtn.addEventListener("click", handleBack);
joinBtn.addEventListener("click", handleLogin);