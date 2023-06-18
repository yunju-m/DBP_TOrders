const logoutBtn = document.getElementById("logoutBtn");
const searchContent = document.getElementById("searchContent");
const searchBtn = document.getElementById("searchBtn");
const categoryBtns = document.getElementsByClassName("category-item");

// 로그아웃 버튼 클릭하면 첫 화면으로 이동
async function handleLogout(){
    await fetch(`/login`)
    .then(res => res.json())
    .then(res => {
        console.log(res);
        alert(`${res[0].id}님 로그아웃 되었습니다.`);
        return location.href="/";
    });
}

// 카테고리 별 버튼 클릭하면 해당 내용만 추출
async function handlerCategory(event){
    console.log("카테고리 버튼 클릭!!!");
    let categoryData = {
        method:'POST',
        body:JSON.stringify({"category_id": event.target.id, "category_name": event.target.name}),
        headers:{
            'Content-Type':'application/json',
        }
    }
    console.log(categoryData);
    await fetch(`/category`, categoryData)
    .then(res => res.json())
    .then(res => {
        console.log(res);
    })
}

// 검색 버튼 클릭하면 검색어에 해당하는 카테고리 id가져오기
async function handleSearch(){
    console.log("검색시작!!!!!!");
    let searchData = {
        method:'POST',
        body:JSON.stringify({"searchData":searchContent.value}),
        headers:{
            'Content-Type':'application/json',
        }
    }
    console.log(searchData);
    await fetch(`/search`, searchData)
    .then(res => res.json())
    .then(res => {
        console.log(res);
    })
}

logoutBtn.addEventListener("click", handleLogout);
searchBtn.addEventListener("click", handleSearch);

for (var i=0; i < categoryBtns.length; i++){
    categoryBtns[i].addEventListener("click", handlerCategory);
}