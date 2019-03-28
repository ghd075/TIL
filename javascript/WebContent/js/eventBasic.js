function doProcess() {
    alert('event attr:\n이벤트 발생');
}
function doProcess2() {
    alert('event attr:\n이벤트 발생2');
}

//image click handler
function imageClick(){
	//이미지 안 보이게
    this.style.display = 'none';
    //this = 이벤트핸들러가 발생한 대상을 가리킴
}

window.onload = function(){
    //document.getElementById("btn1").onclick = doProcess;
    //document.getElementById("btn1").onclick = doProcess2;
    //중복으로 정의하면 마지막으로 추가할 이벤트로 덮어씀
    var btn = document.getElementById("btn1");
//    var tag = document.getElementById("img1");
//    var tag2 = document.getElementById("img2");
    //이벤트 핸들러가 이벤트 발생 감지
    //EventListener객체는 호출한 이벤트 횟수만큼 실행함
    //마우스 클릭시 이벤트 발생
    btn.addEventListener("click",doProcess);
    btn.addEventListener("click",doProcess2);
    //마우스를 올려놓으면 이벤트 발생
    //btn.addEventListener("mouseover",doProcess);
    //btn.addEventListener("mouseover",doProcess2);
    //마우스 포인터가 벗어나면 이벤트 발생
    //btn.addEventListener("mouseout",doProcess);
    //btn.addEventListener("mouseout",doProcess2);
//    tag.addEventListener("click",imageClick);
//    tag2.addEventListener("click",imageClick);
    //image event
    var tag = document.getElementsByTagName("img"); //img로 시작하는 모든 img들을 불러온다.
    for(i=0; i<tag.length; i++){ //이벤트핸들러 안에 있는 length는 이벤트가 발생한 횟수를 나타냄
    	tag[i].addEventListener("click",imageClick);
    }
    //이벤트 제거
    //btn.removeEventListener("mouseout",doProcess);
}
//페이지가 로딩될 때 실행해라
