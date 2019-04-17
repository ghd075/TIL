<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jogiyo.vo.RepleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.thumbs_up {
		border:1px solid red;
		width:24px;
	}
	.like_btn {
		width: 24px;
		height: auto;
	}
	.unlike_btn {
		width: 24px;
		height: auto;
	}
	/*
	ul {
		list-style:none;
		margin:0;
		padding:0;
	}

	li {
		margin: 0 0 0 0;
		padding: 0 0 0 0;
		border : 0;
		float: left;
	}
	*/
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function(){
	repleLoad = function() {
		var reple_arr = [
			{re_no : 1, p_no : 1, seq : 1, level : 0, txt : '맛있어', 				date : '19/5/25', user_name : 'test', b_no : 1},
			{re_no : 2, p_no : 2, seq : 1, level : 0, txt : '여긴 그저 그러함', 		date : '19/5/25', user_name : 'test', b_no : 1},
			{re_no : 3, p_no : 1, seq : 2, level : 1, txt : '아닌데 그냥 그러한데', 	date : '19/5/25', user_name : 'test', b_no : ''},
			{re_no : 4, p_no : 1, seq : 3, level : 2, txt : '둘다 틀림 그냥 맛없음', 	date : '19/5/25', user_name : 'test', b_no : ''},
			{re_no : 5, p_no : 2, seq : 1, level : 1, txt : '저도 그냥 그러함', 		date : '19/5/25', user_name : 'test', b_no : ''},
			{re_no : 6, p_no : 1, seq : 4, level : 1, txt : '아니 그냥 맛없어', 		date : '19/5/25', user_name : 'test', b_no : ''},
			{re_no : 7, p_no : 7, seq : 1, level : 0, txt : '그냥 싼 맛에 먹는 수준?',date : '19/5/25', user_name : 'test', b_no : 1}	
		];
		/*
		Array(7)
0: {re_no: 1, p_no: 1, seq: 1, level: 1, txt: "맛있어", …}
1: {re_no: 3, p_no: 1, seq: 2, level: 2, txt: "아닌데 그냥 그러한데", …}
2: {re_no: 4, p_no: 1, seq: 3, level: 3, txt: "둘다 틀림 그냥 맛없음", …}
3: {re_no: 6, p_no: 1, seq: 4, level: 2, txt: "아니 그냥 맛없어", …}
4: {re_no: 2, p_no: 2, seq: 1, level: 1, txt: "여긴 그저 그러함", …}
5: {re_no: 5, p_no: 2, seq: 1, level: 2, txt: "저도 그냥 그러함", …}
6: {re_no: 7, p_no: 7, seq: 1, level: 1, txt: "그냥 싼 맛에 먹는 수준?", …}
		*/
		reple_arr.sort(function(a, b) { // 오름차순
		    return a.p_no < b.p_no ? -1 : a.p_no > b.p_no ? 1 : 0;  
		});
		
		var html = "";
		for (var i = 0; i < reple_arr.length; i++) {
			
			html += "<div id=\"reple_" + reple_arr[i].re_no + "\">";
			html += "<div id=\"reple_parent_" + reple_arr[i].p_no + "\">";
			html +=	"<div class=\"reple_parent_" + reple_arr[i].p_no + " " + "seq_" + reple_arr[i].seq +"\">";
			html +=	"<ul class=\"level_" + reple_arr[i].level +"\">";
			html += "<li>"+reple_arr[i].user_name+"</li>";
			html += "<li>"+reple_arr[i].date+"</li>";
			html += "<li><a href=\"#\" class=\"add_textarea\">답글</a></li>";
			html += "<li>|</li>";
			//html += "<li><a href=\"\" class=\"modify_add_textarea\">수정</a></li>";
			//html += "<li>|</li>";
			html += "<li><a href=\"\" class=\"del_re\">삭제</a></li>";
			html += "<li>평가점수</li>";
			html +=	"</ul>";
			html +=	"<ul>";
			
			for (var j = 0; j < reple_arr[i].level; j++) {
				if (reple_arr[i].seq == 0) {
					break;
				}
				html += "<li><img src='../images/re_arrow.png' style='width: 24px;'></li>";
			}
			
			html += "<li>"+reple_arr[i].txt+"</li>";
			html +=	"<ul>";
			html +=	"</div>"
			html += "<div id=\"reply_txt" + reple_arr[i].re_no + "\" class=\"_t_area\"></div>"//답글 입력부분
			html +=	"</div>"
			html +=	"</div>"
		} 
		
		$("#comment_lists").append(html);
	}
	
	repleLoad();
 
	$( "div.thumbs_up" ).on( "click", function() {
		var c_name = $(this).children().attr('class');
		if (c_name == "like_btn") {
 			$(this).children().attr('class', 'unlike_btn');
			$(this).children().attr('src', '../images/unlike.png');
		} else {
			$(this).children().attr('class', 'like_btn');
			$(this).children().attr('src', '../images/like.png');
		}
		/*
        $.ajax({
            url:'./time2.php',
            type:'post',
            data:$('form').serialize(),
            success:function(data){
                $('#time').text(data);
            }
        })
        */
	});
	/*
	$( "#reply" ).click(function() {
	    if($("#dut_wr").css("display") == "none"){   
	        $('#dut_wr').css("display", "block");   
	    } else {  
	        $('#dut_wr').css("display", "none");   
	    }  
	});
	*/
/*
	$( "#div:contains(\"reply_txt\")" ).click(function() {
		alert("call")
	});
*/
	$( ".add_textarea" ).click(function() {
		//답글 입력창 생성
		var parent_div = $(this).parents("div #reple_parent_1");
		var t_area = parent_div.children(":eq(-1)");
		html = "";
		html += "<div class=\"reple_wr\">";
		html += "<ul>";
		html += "<li class=\"reple_txt\">";
		html += "<textarea name=\"cmt_contents\" style=\"width:610px;height:68px;border:1px solid #ddd;\"></textarea>";
		html += "</li>";
		html += "<li class=\"reple_wr_btn\">";
		html += "<a href=\"#\" class=\"add_re\"><img src=\"http://i.jjang0u.com/data3/web/icon/view_btn11.gif\"></a>";
		html += "</li>";		
		html += "</ul>";
		html += "</div>";		
		
		if (t_area.empty()) {
			t_area.append(html);	
		} else {
			return;
		}
	});
	
	$(".add_re").click(function() {
		//ajax처리
		var reple_arr = [
			{re_no : 8, p_no : 8, seq : 1, level : 0, txt : '가성비 짱임', 				date : '19/3/26', user_name : 'test', b_no : 1}	
		];
		
		var parent_div = $(this).parents("div #reple_parent_1");
		var t_area = parent_div.children(":eq(-1)");
		/*
			html += "<div id=\"reple_" + reple_arr[i].re_no + "\">";
			html += "<div id=\"reple_parent_" + reple_arr[i].p_no + "\">";
			html +=	"<div class=\"reple_parent_" + reple_arr[i].p_no + " " + "seq_" + reple_arr[i].seq +"\">";
			html +=	"<ul class=\"level_" + reple_arr[i].level +"\">";
			html += "<li>"+reple_arr[i].user_name+"</li>";
			html += "<li>"+reple_arr[i].date+"</li>";
			html += "<li><a href=\"#\" class=\"add_textarea\">답글</a></li>";
			html += "<li>|</li>";
			html += "<li><a href=\"\" class=\"modify_add_textarea\">수정</a></li>";
			html += "<li>|</li>";
			html += "<li><a href=\"\" class=\"del_re\">삭제</a></li>";
			html += "<li>평가점수</li>";
			html +=	"</ul>";
			html +=	"<ul>";
		*/
		
	});
	$( ".add_reple" ).click(function() {
		//ajax처리
		var reple_arr = [
			{re_no : 8, p_no : 8, seq : 1, level : 0, txt : '가성비 짱임', 				date : '19/3/26', user_name : 'test', b_no : 1}	
		];		
		// 댓글 입력창 출력
		var html = "";
		for (var i = 0; i < reple_arr.length; i++) {
			
			html += "<div id=\"reple_" + reple_arr[i].re_no + "\">";
			html += "<div id=\"reple_parent_" + reple_arr[i].p_no + "\">";
			html +=	"<div class=\"reple_parent_" + reple_arr[i].p_no + " " + "seq_" + reple_arr[i].seq +"\">";
			html +=	"<ul class=\"level_" + reple_arr[i].level +"\">";
			html += "<li>"+reple_arr[i].user_name+"</li>";
			html += "<li>"+reple_arr[i].date+"</li>";
			html += "<li><a href=\"\" class=\"add_re\">답글</a></li>";
			html += "<li>|</li>";
			//html += "<li><a href=\"\" class=\"modify_re\">수정</a></li>";
			//html += "<li>|</li>";
			html += "<li><a href=\"\" class=\"del_re\">삭제</a></li>";			
			html += "<li>평가점수</li>";
			html +=	"</ul>";
			html +=	"<ul>";
			
			for (var j = 0; j < reple_arr[i].level; j++) {
				if (reple_arr[i].seq == 0) {
					break;
				}
				html += "<li><img src='../images/re_arrow.png' style='width: 24px;'></li>";
			}
			
			html += "<li>"+reple_arr[i].txt+"</li>";
			html +=	"<ul>";
			html +=	"</div>"
			html += "<div id=\"reply_txt" + reple_arr[i].re_no + "\" class=\"_t_area\"></div>"//답글 입력부분
			html +=	"</div>"
			html +=	"</div>"
		} 
		
		$("#comment_lists").append(html);
	});
});
</script>
</head>
<body>
<%--
	댓글번호
	부모번호
	그룹내 순서
	그룹내 계층
	댓글 내용
	등록날짜
	유저코드
	게시글번호
--%>
<div class="thumbs_up" >
	<img class="like_btn" src = "../images/like.png">
</div><%= 0 %>
<div id="comment_lists">
</div>
<div class="reple_area0">
	<div id="reple_wr">
		<ul>
			<li class="reple_txt">
				<textarea name="cmt_contents" style="width:610px;height:68px;border:1px solid #ddd;"></textarea>
			</li>
			<li class="reple_wr_btn">
				<a href="#" class="add_reple"><img src="http://i.jjang0u.com/data3/web/icon/view_btn11.gif"></a>
			</li>
		</ul>
	</div>
</div>
</body>
</html>