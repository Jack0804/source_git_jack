/**
 * 
 */
var commentManager = (function(){
	
	console.log("START todoManager");
	
    function getCommentData(uri, callback) {
    	
    	console.log("URI ="+uri);
        $.getJSON(uri, callback);
    }
    
    
    function addData(obj, callback) {
        console.log("addData", obj);

        $.ajax({
            url: "http://192.168.1.14:8081/comment/register/",
            type: "post",
            data: JSON.stringify(obj),
            contentType: "application/json;charset=UTF-8",
            success: callback
        });
    }
    
    
    function deleteData(obj, callback) {
        
    	console.log("deleteData", obj);

        $.ajax({
            url: "http://192.168.1.14:8081/comment/delete/",
            type: "post",
            data: JSON.stringify(obj),
            contentType: "application/json;charset=UTF-8",
            success: callback
        });
    }
    
	function updateData(obj, callback) {
	        
	    	console.log("updateData = ", obj);
	
	        $.ajax({
	            url: "http://192.168.1.14:8081/comment/update/",
	            type: "post",
	            data: JSON.stringify(obj),
	            contentType: "application/json;charset=UTF-8",
	            success: callback
	        });
	    }
    
    
    return {
    	getCommentData:getCommentData,
    	addData:addData,
    	deleteData:deleteData,
    	updateData:updateData
    }
    
})();