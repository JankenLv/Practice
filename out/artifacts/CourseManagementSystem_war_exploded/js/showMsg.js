// 提示信息msg淡出
$(document).ready(function domain() {
    var msg = $("#msg");
    var html = msg.html();
    html!==undefined && html!=="" ? msg.delay(2500).fadeOut("slow") : msg.show();
});
