const inputcontent = document.getElementsByClassName("inputcontent");
const content_id= document.querySelector(".inputcontent > li");

// login 사용자 정보 요청 함수
async function loginUserInfo(){
    console.log("로그인 사용자 정보 내놔");
    await fetch(`/login`)
    .then(res => res.json())
    .then(res => {
        console.log(res[0].id);
        contenthandler(res[0].id);
    })
}

// 반환받은 사용자 id, contentid를 이용해서 content.html에 전달
async function contenthandler(userid){
    console.log('내용 불러온다 딱대');
    let contentData = {
        method:'POST',
        body: JSON.stringify({"userid":userid, "contentid":content_id.innerHTML}),
        headers:{
            'Content-Type': 'application/json',
        }
    };
    console.log(contentData);
    await fetch(`/post/ids`, contentData)
    .then(res => res.json())
    .then(res => {
        console.log(res);
    })
    return location.href="/content";
}

inputcontent[0].addEventListener("click", loginUserInfo);
