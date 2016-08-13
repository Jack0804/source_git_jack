/**
 * 
 */

var todoManager = (function(){

    function getCommentData(bno, callback) {
        console.log("getPageData", bno);
        $.getJSON("http://192.168.1.14:8081/board/view/" + bno, callback);
    }
})();