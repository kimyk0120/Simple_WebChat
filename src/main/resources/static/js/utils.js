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


function makeChatListLi(name, createdAt, roomId, callbackfunc) {
    let htmlliElement = document.createElement("li");
    htmlliElement.className = "p-3 border cursor-pointer cursor-pointer-action";
    htmlliElement.onclick = () => {
        callbackfunc(htmlliElement)
    };
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

function makeJoinCard(senderName, type){
    let htmlPElement = document.createElement("p");
    htmlPElement.className = "small rounded-3 text-muted" ;
    htmlPElement.innerText = senderName + " " + type.toLowerCase() + "  the room.";
    return htmlPElement;
}


function makeMyMsgCard(message, senderName, msgTime){
    let htmlDivElement1 = document.createElement("div");
    htmlDivElement1.className = "d-flex flex-row justify-content-start";
    let htmlDivElement2 = document.createElement("div");
    htmlDivElement2.innerText = senderName;
    let htmlDivElement3 = document.createElement("div");
    htmlDivElement3.className = "update-msg-container"
    let htmlPElement1 = document.createElement("p");
    htmlPElement1.className = "small p-2 ms-3 mb-1 rounded-3";
    htmlPElement1.style.backgroundColor = "#f5f6f7";
    htmlPElement1.innerText = message;
    let htmlPElement2 = document.createElement("p");
    htmlPElement2.className = "small ms-3 mb-3 rounded-3 text-muted";
    htmlPElement2.innerText = msgTime;
    htmlDivElement3.appendChild(htmlPElement1);
    htmlDivElement3.appendChild(htmlPElement2);
    htmlDivElement1.appendChild(htmlDivElement2);
    htmlDivElement1.appendChild(htmlDivElement3);
    return htmlDivElement1;
}


function makeOtherMsgCard(message, senderName, msgTime){
    let htmlDivElement1 = document.createElement("div");
    htmlDivElement1.className = "d-flex flex-row justify-content-end mb-4 pt-1";
    let htmlDivElement2 = document.createElement("div");
    htmlDivElement2.className = "update-msg-container";
    let htmlPElement1 = document.createElement("p");
    htmlPElement1.className = "small p-2 me-3 mb-1 text-white rounded-3 bg-primary";
    htmlPElement1.innerText = message;
    let htmlPElement2 = document.createElement("p");
    htmlPElement2.className = "small me-3 mb-3 rounded-3 text-muted d-flex justify-content-end";
    htmlPElement2.innerText = msgTime;
    htmlDivElement2.appendChild(htmlPElement1);
    htmlDivElement2.appendChild(htmlPElement2);
    let htmlDivElement3 = document.createElement("div");
    htmlDivElement3.innerText = senderName;
    htmlDivElement1.appendChild(htmlDivElement2);
    htmlDivElement1.appendChild(htmlDivElement3);
    return htmlDivElement1;
}


function makeUpdateMyMsgCard(message, msgTime, lastAppendEl){

    let pEls = lastAppendEl.getElementsByTagName("p");
    let updatetMsgContainer = lastAppendEl.getElementsByClassName("update-msg-container")[0];

    //마지막 p 태그의 메세지 시간을 업데이트 함
    pEls[pEls.length-1].innerText = msgTime;

    // 마지막 p 태그의 앞에 메세지를 추가함
    let htmlPElement = document.createElement("p");
    htmlPElement.className = "small p-2 ms-3 mb-1 rounded-3";
    htmlPElement.style.backgroundColor = "#f5f6f7";
    htmlPElement.innerText = message;
    updatetMsgContainer.insertBefore(htmlPElement, pEls[pEls.length-1]);
}

function makeUpdateOtherMsgCard(message, msgTime, lastAppendEl){
    console.log(lastAppendEl);
    let pEls = lastAppendEl.getElementsByTagName("p");
    let updatetMsgContainer = lastAppendEl.getElementsByClassName("update-msg-container")[0];

    //마지막 p 태그의 메세지 시간을 업데이트 함
    pEls[pEls.length-1].innerText = msgTime;

    // 마지막 p 태그의 앞에 메세지를 추가함
    let htmlPElement = document.createElement("p");
    htmlPElement.className = "small p-2 me-3 mb-1 text-white rounded-3 bg-primary";
    htmlPElement.innerText = message;
    updatetMsgContainer.insertBefore(htmlPElement, pEls[pEls.length-1]);

}