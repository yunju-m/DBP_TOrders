const joinBtn = document.querySelector("#btnJoin");

const idForm = document.getElementById("form_id");
const pwdForm = document.getElementById("form_pwd");
const nickForm = document.getElementById("form_nick");

const id = document.querySelector("#id");
const pwd1 = document.querySelector("#pswd1");
const pwd2 = document.querySelector("#pswd2");
const nickname = document.querySelector("#nickname");
const year = document.querySelector("#year");
const month = document.querySelector("#month");
const day = document.querySelector("#day");
const gender = document.querySelector("#gender");

const DB_KEY = "login";
let newid, newpwd, newnick, chkid, chknick;
let loginDB = [];
let chkidDB = [];
let chknickDB = [];

function saveDB(){
    localStorage.setItem(DB_KEY, JSON.stringify(loginDB));
}

function onJoinBtnClick(event){
    event.preventDefault();
    const newidObj = {
        id: newid,
        pw: newpwd,
        nick: newnick,
    };
    loginDB.push(newidObj);
    saveDB();

    alert(`${newnick}님 환영합니다.`);
}

function checkId(event){
    console.log("check id!!!");
    chkidDB.push(event.id);
}

function checkNick(event){
    console.log("check nickname!!");
    chknickDB.push(event.nick);
}

function handleSubmitId(event) {
    event.preventDefault();
    newid = id.value;
    loginDB.forEach(checkId);
    if (loginDB.length == 0 || chkidDB.includes(newid) == false) { 
        alert("사용가능한 아이디입니다.");
    } else{
        alert("이미 존재하는 아이디입니다.");
        id.value = "";
        chkidDB = [];
    }
}

function handleSubmitPwd(event){
    event.preventDefault();
    newpwd = pwd2.value;
    if (newpwd != pwd1.value){
        alert("비밀번호가 일치하지 않습니다.");
    } else{
        alert("비밀번호가 일치합니다.");
    }
}

function handleSubmitNick(event){
    event.preventDefault();
    newnick = nickname.value;
    loginDB.forEach(checkNick);
    if (chknickDB.includes(newnick)) {
        alert("존재하는 닉네임입니다.");
        nickname.value="";
        chknickDB=[];
    } else {
        alert("사용가능한 닉네임 입니다.");
    };
}

idForm.addEventListener("submit", handleSubmitId);
pwdForm.addEventListener("submit", handleSubmitPwd);
nickForm.addEventListener("submit", handleSubmitNick);
joinBtn.addEventListener("click", onJoinBtnClick);

// 새로고침 후에도 사용자DB 저장
const savedDBs = localStorage.getItem(DB_KEY);
if(savedDBs != null) {
    const parsedDBs = JSON.parse(savedDBs);
    loginDB = parsedDBs;
}