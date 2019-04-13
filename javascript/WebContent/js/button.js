	function Button(elementId) {
		this.element = document.getElementById(elementId);
		//초기 스타일 지정
		this.element.style.border = '1px solid blue';		
		this.element.style.backgroundColor = 'blue';		
		this.element.style.color = 'white';		
		this.element.style.fontSize = '3em';		
		var btn = this;  //Button 클래스
		var overFunc = function() {
			//함수 호출할 때 컨텍스트(this)를 인수로 넘겨줌
			//arguments 가변인자
			//첫번째 매개변수를 this로 넘겨줌
			btn.doMouseOver.apply(btn, arguments);
		}
		var outFunc = function() {
			//함수 호출할 때 컨텍스트(this)를 인수로 넘겨줌
			//arguments 가변인자
			//첫번째 매개변수를 this로 넘겨줌
			btn.doMouseOut.apply(btn, arguments);
		}
		//이벤트 핸들러 추가
		this.element.addEventListener("mouseover", overFunc );
		this.element.addEventListener("mouseout", outFunc  );
	}	
	Button.prototype = {
		doMouseOver: function(e) { //MouseOver이벤트
			console.log(this);  
			//이벤트 핸들러로 호출(실행)된 경우 
			//this 자신 클래스가 아니고 이벤트타겟을 가리킴 
			this.element.style.background = '#999'; 		
			//this.style.background = '#999';
			},
		doMouseOut: function(e) { //MouseOut이벤트
			this.element.style.background = 'blue'; 		
			//this.style.background = '#fff';
			}
	}