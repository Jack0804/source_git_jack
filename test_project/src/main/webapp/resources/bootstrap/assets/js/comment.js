/**
 * 
 */
var todoManager = (function(){
	
	console.log("START todoManager");
	
    function getCommentData(bno, callback) {
    	console.log("bno = "+bno );
        console.log("getPageData", bno);
        $.getJSON("http://192.168.1.14:8081/board/view/" + bno, callback);
    }
    
    function getTest() {
    	console.log("Test");
    }
    
})();