// toast msg function, styles
// requirement : toastify
// styleNm : info, error, warn
const styles = {
    "info": {background: "linear-gradient(to right, #42a5ef, #3d50c9)",},
    "error": {background: "linear-gradient(to right, #f55d5d, #ef6123)",},
    "warn": {background: "linear-gradient(to right, #f3a30f, #f38f1c)",}
};

function showToast(message, styleNm) {

    const toastObj = Toastify({
        duration: 1000,
        newWindow: true,
        close: true,
        gravity: "top", // `top` or `bottom`
        position: "left", // `left`, `center` or `right`
        stopOnFocus: true, // Prevents dismissing of toast on hover
        style: {
            background: "linear-gradient(to right, #42a5ef, #3d50c9)",
        },
        onClick: function () {
        }
    });

    toastObj.options.text = message;
    toastObj.options.style = styles[styleNm];
    toastObj.showToast();
}

// 특수문자 입력 방지
// requirement : toastify
function characterCheck(obj) {
    const regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
    if (regExp.test(obj.value)) {
        showToast("special character is not allowed", "warn");
        obj.value = obj.value.substring(0, obj.value.length - 1); // 입력한 특수문자 한자리 지움
    }
}


function makeChatListLi(name, createdAt, roomId) {
    let htmlliElement = document.createElement("li");
    htmlliElement.className = "p-3 border cursor-pointer cursor-pointer-action";
    let htmlaElement = document.createElement("a");
    htmlaElement.className = "d-flex justify-content-between";
    htmlaElement.setAttribute("room-id", roomId);
    let htmlDivElement1 = document.createElement("div");
    htmlDivElement1.className = "d-flex flex-row";
    let htmlDivElement2 = document.createElement("div");
    htmlDivElement2.className = "pt-1";
    let htmlpElement = document.createElement("p");
    htmlpElement.className = "fw-bold mb-0";
    htmlpElement.innerText = name;
    htmlDivElement2.appendChild(htmlpElement);
    htmlDivElement1.appendChild(htmlDivElement2);
    htmlaElement.appendChild(htmlDivElement1);
    let htmlDivElement3 = document.createElement("div");
    htmlDivElement3.className = "pt-1";
    let htmlpElement2 = document.createElement("p");
    htmlpElement2.className = "small text-muted mb-1";
    htmlpElement2.innerText = createdAt;
    htmlDivElement3.appendChild(htmlpElement2);
    htmlaElement.appendChild(htmlDivElement3);
    htmlliElement.appendChild(htmlaElement);
    return htmlliElement;
}


function makeNoRoomLi() {
    let htmlliElement = document.createElement("li");
    htmlliElement.className = "p-3 no-room-li";
    htmlliElement.innerText = "No Rooms yet.";
    return htmlliElement;
}


function getCookie(cookie_name) {
    let x, y;
    const val = document.cookie.split(';');
    for (let i = 0; i < val.length; i++) {
        x = val[i].substr(0, val[i].indexOf('='));
        y = val[i].substr(val[i].indexOf('=') + 1);
        x = x.replace(/^\s+|\s+$/g, '');
        if (x === cookie_name) {
            return unescape(y);
        }
    }
}