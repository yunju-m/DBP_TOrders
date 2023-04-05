const joinBtn = document.querySelector("#btnJoin");
const loginForm = document.getElementById("loginpage");

const id = document.querySelector("#id");
const pwd1 = document.querySelector("#pswd1");
const pwd2 = document.querySelector("#pswd2");
const nickname = document.querySelector("#nickname");
const year = document.querySelector("#year");
const month = document.querySelector("#month");
const day = document.querySelector("#day");
const gender = document.querySelector("#gender");

const DB_KEY = "login";
let newid, newpwd, newnick;
let loginDB = [];

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
    console.log(`${year.value}년 ${month.value}월 ${day.value}일`);
    console.log(`${newnick}님은 ${gender.value} 입니다.`);
}

function handleSubmitId(event) {
    event.preventDefault();
    newid = id.value;
    if (loginDB.includes(newid)) { 
        alert("이미 존재하는 아이디입니다.");
        id.value = "";
    } else{
        alert("사용가능한 아이디입니다.");
    }
}

function handleSubmitPwd(){
    newpwd = pwd2.value;
    if (newpwd != pwd1.value){
        alert("비밀번호가 일치하지 않습니다.");
    } else{
        alert("비밀번호가 일치합니다.");
    }
}

function handleSubmitNick(){
    newnick = nickname.value;
    if (loginDB.includes(newnick)) {
        alert("존재하는 닉네임입니다.");
    } else {
        alert("사용가능한 닉네임 입니다.");
    };
}

loginForm.addEventListener("submit", handleSubmitId);
loginForm.addEventListener("submit", handleSubmitPwd);
loginForm.addEventListener("submit", handleSubmitNick);
joinBtn.addEventListener("click", onJoinBtnClick);

const savedDBs = localStorage.getItem(DB_KEY);
if(savedDBs != null) {
    const parsedDBs = JSON.parse(savedDBs);
    loginDB = parsedDBs;
}