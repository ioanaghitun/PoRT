function calc() {

    //This two values need for only option one to send the data 
    var number1 = $.trim($("#n1").val());
    var number2 = $.trim($("#n2").val());

    $.ajax({
        type: "POST",
        url: "ScriptServlet.java",
        data: "&n1=" + number1 + "&n2=" + number2, 
        dataType: "html",
        success: function(response) {
            if(response != null && response !="" && response !="null"){
                $('#result').val(response);
            }

        },
        error: function(e) {
            alert('Error: ' + e.message);
        }
    });
}
