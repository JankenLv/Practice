function login(){
    $('#loginTitle').css('color','#337Ab7');
    $('#loginForm').show();
    $('#registeTitle').css('color','#000');
    $('#registeForm').hide();
}
function registe(){
    $('#loginTitle').css('color','#000');
    $('#loginForm').hide();
    $('#registeTitle').css('color','#337Ab7');
    $('#registeForm').show();
}
$(function(){
    $("#userdetail").popover({
        trigger:'manual',
        placement : 'bottom',
        html: 'true',
        content : '<div style="width:300px;height:300px;"></div>',
        animation: false
    }).on("mouseenter", function () {
        var _this = this;
        $(this).popover("show");
        $(this).siblings(".popover").on("mouseleave", function () {
            $(_this).popover('hide');
        });
    }).on("mouseleave", function () {
        var _this = this;
        setTimeout(function () {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide")
            }
        }, 0);
    });


    /*$.ajax({
        dataType:"jsonp",
        jsonp:"callback",
        url:"http://localhost:8080/ocRest/getClassifyJson",
        success:function (result) {
            alert(JSON.stringify(result));
        },
        error:function (result) {
            alert(result.errcode);
        }
    });*/

    /*$.jsonp({
        url:"http://localhost:8080/ocRest/getClassifyJson.html?callback=?",
        success:function (result) {
            alert(JSON.stringify(result));
        },
        error:function (result) {
            alert('error');
        }
    });*/


});