function doProcess() {
    alert('event attr:\n이벤트 발생');
}
function doProcess2() {
    alert('event attr:\n이벤트 발생2');
}
window.onload = function(){
    document.getElementById("btn1").onclick = doProcess;
    document.getElementById("btn1").onclick = doProcess2;
}
//중복으로 정의하면 마지막으로 추가할 이벤트로 덮어씀
//페이지가 로딩될 때 실행해라
