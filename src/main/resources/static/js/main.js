const logoutBtn = document.getElementById("logoutBtn");

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

logoutBtn.addEventListener("click", handleLogout);