
function changeView(value){
	if(value == "0") //HOME 버튼 클릭시 첫화면으로 이동
	{
		location.href="../main/MianForm.do"; 
	}else if(value == "1"){ //로그인 버튼 클릭시 로그인 화면으로 이동
		location.href="../member/LoginForm.do";
	}else if(value == "2"){ //로그아웃 버튼 클릭시 로그아웃처리
		location.href="../member/MemberLoginOut.do";
	}else if(value == "3"){ //회원가입 버튼 클릭시 회원가입 화면으로 이동
		location.href="../member/RegisterForm.do";
	}else if(value == "4"){ //내정보보기 버튼 클릭시 내정보보기 화면으로 이동
		location.href="../member/MemberInfo.do";
	}else if(value == "5"){ //게시물 관리 화면으로 이동
		location.href="../admin/PostList.do";
	}else if(value == "6"){ //메뉴 게시판 화면으로 이동
		location.href = "../board/BoardList.do?food_code=f01";
	}else if(value == "7"){ //지역 게시판 화면으로 이동
		location.href = "../board/BoardList2.do?loc_code=l01";
	}else if(value == "8"){ //베스트 게시판 화면으로 이동
		location.href = "../board/BestList.do";
	}else if(value == "9"){ //회원관리 화면으로 이동
		location.href = "../admin/MemberList.do"; 
	}else if(value == "10"){ //블랙리스트 화면으로 이동
		location.href = "../notice/RankListForm.do";
	}else if(value == "11"){ //차트 화면으로 이동
		location.href = "../chart/ChartForm.do";
	}else if(value == "12"){ //공지사항 화면으로 이동
		location.href = "../notice/NoticeListForm.do";
	}
}


(function ($) {
    "use strict";


    /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    /*==================================================================
    [ Show pass ]*/
    var showPass = 0;
    $('.btn-show-pass').on('click', function(){
        if(showPass == 0) {
            $(this).next('input').attr('type','text');
            $(this).addClass('active');
            showPass = 1;
        }
        else {
            $(this).next('input').attr('type','password');
            $(this).removeClass('active');
            showPass = 0;
        }
        
    });

})(jQuery);