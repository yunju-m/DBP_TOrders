const id = document.getElementById("id");
const pwd1 = document.getElementById("pswd1");
const pwd2 = document.getElementById("pswd2");
const nickname = document.getElementById("nickname");

const idBtn = document.getElementById("idBtn");
const pwBtn = document.getElementById("pwBtn");
const nickBtn = document.getElementById("nickBtn");
const backBtn = document.getElementById("backBtn");
const joinBtn = document.getElementById("joinResultBtn");

// async function handleCheckId(){
//     await fetch("http://localhost:8080/login/id/new")
//     .then(res => {
//         console.log(res);
//         if (res.id == ""){
//             alert("이미 존재하는 아이디입니다.");
//         } else{
//             alert("사용 가능한 아이디입니다.");
//             id.innerHTML(res.id);
//         }
//     })
// }

async function handleCheckPw(){
    await fetch("http://localhost:8080/login/pw/new")
    .then(res => res.json())
    .then(res => {
        console.log(res);
        if(res.password == ""){
            alert("비밀번호가 일치하지 않습니다.");
        } else{
            alert("비밀번호가 일치합니다.");
        }
        location.href='/login/new';
    })
}

async function handleCheckNick(){
    await fetch("http://localhost:8080/login/nick/new")
    .then(res => res.json())
    .then(res => {
        if (res.nickname == ""){
            alert("이미 존재하는 닉네임입니다.");
        } else{
            alert("사용 가능한 닉네임입니다.");
        }
        history.go();
    })
}

function handleBack(){
    location.href="/";
}

// idBtn.addEventListener("click", handleCheckId);
pwBtn.addEventListener("click", handleCheckPw);
nickBtn.addEventListener("click", handleCheckNick);
backBtn.addEventListener("click", handleBack);
joinBtn.addEventListener("click", handleLogin);