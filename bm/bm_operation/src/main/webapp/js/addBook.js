// 返回上一页
function goback() {
    window.history.back();
}

// 预览上传的图片
function previewPic(version){
    if (version != null) {
        var imgId = "img_" + version;
        var fileId = "file_" + version;
        var blockId = "preview_" + version;
        var objUrl_ = getObjectURL(document.getElementById(fileId).files[0]);//获取文件信息
        // console.log("objUrl = "+objUrl);
        if (objUrl_) {
            var img = '#'+imgId;
            var block = '#'+blockId;
            $('#'+imgId).attr("src", objUrl_);
            $('#'+blockId).css("display", "block");
        }
    } else {
        var file = document.getElementById("file").files[0];
        var objUrl = getObjectURL(file) ;//获取文件信息
        // console.log("objUrl = "+objUrl);
        if (objUrl) {
            $("#img").attr("src", objUrl);
            $("#preview").css("display","block");
        }
    }
}
// 获取上传图片
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL!=undefined) {
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}