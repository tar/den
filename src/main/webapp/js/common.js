function escapeSelector(str) {
    if (str)
        return str.replace(/([ #;&,.+*~\':"!^$[\]()=>|\/@])/g, '\\$1');
    else
        return str;
}

function notEmpty($elem, $msg) {
    if (!($elem.val() && $.trim($elem.val()))) {
        $msg.addClass('error');
        $elem.focus();
        return false;
    } else {
        $msg.removeClass('error');
    }
    return true;
}

function notZero($elem, $msg) {
    if ($elem.val() == 0) {
        $msg.addClass('error');
        $elem.focus();
        return false;
    } else {
        $msg.removeClass('error');
    }
    return true;
}

function isInteger($elem, $msg) {
    var intVal = parseInt($elem.val());  
    if (isNaN(intVal) || !($elem.val() === intVal.toString())) {
        $msg.addClass('error');
        $elem.focus();
        return false;
    } else {
        $msg.removeClass('error');
    }
    return true;
}

function isDouble($elem, $msg) {
    var doubleVal = parseFloat($elem.val());  
    if (isNaN(doubleVal) || $elem.val() != doubleVal) {
        $msg.addClass('error');
        $elem.focus();
        return false;
    } else {
        $msg.removeClass('error');
    }
    return true;
}

$(function () {
    $.ajaxSetup({
        contentType:"application/json",
        error:function (jqXHR, exception) {
            function message(){return jqXHR.responseText.split('\n')[0]}
            if (jqXHR.status === 0) {
                alert('Not connect.\n Verify Network.');
            } else if (jqXHR.status == 401) {
                alert('Not logged in. [401]');
            } else if (jqXHR.status == 403) {
                alert('Not allowed. [403]');
            } else if (jqXHR.status == 404) {
                alert('Requested resource not found. [404]');
            } else if (jqXHR.status == 500) {
                alert('Internal Server Error [500].' + message());
            } else if (exception === 'parsererror') {
                alert('Requested JSON parse failed.');
            } else if (exception === 'timeout') {
                alert('Time out error.');
            } else if (exception === 'abort') {
                alert('Ajax request aborted.');
            } else {
                alert('Uncaught Error.\n' + message());
            }
        }
    });

    $('form').submit(function() {
        var isValid = $(this).triggerHandler('validate');
        if (isValid == true || isValid == undefined) {
            $(this).submit(function () {
                return false;
            });
            $(this).triggerHandler('beforeSubmit');
            return true;
        }
        if (!isValid)
            return false;
    });
});