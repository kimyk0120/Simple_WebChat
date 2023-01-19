

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
        onClick: function(){}
    });

    toastObj.options.text = message;
    toastObj.options.style = styles[styleNm];
    toastObj.showToast();
}

// 특수문자 입력 방지
// requirement : toastify
function characterCheck(obj){
    const regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
    if( regExp.test(obj.value) ){
        showToast("special character is not allowed", "warn");
        obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
    }
}