
$(document).ready(function () {

    // 请求后台rest接口
    $.getJSON(
        "http://localhost:8080/ocRest/getClassifyJson.html?callback=?",
        function (result) {
            alert(JSON.stringify(result));
            var classify = template("classify",{'allClassify':result.data});
            $('#classifyDIV').html(classify);


            //课程分类展示
            $(".category").popover({
                trigger:'manual',
                placement : 'right',
                html: 'true',
                content : '',
                animation: false
            }).on("mouseenter", function () {
                var cid = $(this).attr('c-id');
                $('#' + cid).show();
                $('#' + cid).hover(function(){
                    $('#' + cid).show();
                },function(){
                    $('#' + cid).hide();
                });
            }).on("mouseleave", function () {
                var cid = $(this).attr('c-id');
                $('#' + cid).hide();
            });

        });

    var data = {'name':'门户'};
    var header = template("header",data);
    $('#headerDIV').html(header);

    var footer = template("footer");
    $('#footerDIV').html(footer);
});