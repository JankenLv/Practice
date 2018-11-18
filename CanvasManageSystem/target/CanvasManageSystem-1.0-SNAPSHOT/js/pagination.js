// 实现分页功能的js
function getCanvas(config) {
    var form = document.getElementById("page-nav-form");
    var currentEle = document.getElementById("currentPage");
    var currentPage = currentEle.value;
    var lastPage = document.getElementById("totalPage").value;
    if (config == 'first') {
        if (currentPage != 1) {
            currentEle.value = 1;
            form.submit();
        }
    } else if (config == 'pre') {
        if (currentPage != 1) {
            currentPage--;
            currentEle.value = currentPage;
            form.submit();
        }
    } else if (config == 'next') {
        if (currentPage != lastPage) {
            currentPage++;
            currentEle.value = currentPage;
            form.submit();
        }
    } else if (config == 'last') {
        if (currentPage != lastPage) {
            currentEle.value = lastPage;
            form.submit();
        }
    } else {
        if (config < lastPage && config > 0) {
            currentEle.value = config;
            form.submit();
        }
    }
}