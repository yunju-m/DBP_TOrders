const idForm = document.getElementById("form_id");
const pwdForm = document.getElementById("form_pwd");
const nickForm = document.getElementById("form_nick");

const id = document.querySelector("#id");
const pwd1 = document.querySelector("#pswd1");
const pwd2 = document.querySelector("#pswd2");
const nickname = document.querySelector("#nickname");
const joinBtn = document.querySelector("#btnJoin");


function handleSubmitId(event) {
    event.preventDefault();
    alert(event.id);
}