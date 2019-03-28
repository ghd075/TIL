function doProcess() {
    alert('event attr:\n이벤트 발생');
}
//페이지가 로딩될 때 실행해라
window.onload = function(){
    document.getElementById("btn1").onclick = doProcess;
}