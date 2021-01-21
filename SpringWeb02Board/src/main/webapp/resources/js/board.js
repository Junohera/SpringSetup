function idCheck() {
    if (document.frm.id.value === "") {
        alert("id");
        document.frm.id.focus();
        return;
    }
    var id = document.frm.id.value;
    var opt = "toolbar=no, menubar=no, resizable=no, width=450, height=200";
    window.open("idcheck?id=" + id, "dupcheck", opt);
};

function editCheck() {
    if (document.frm.pw.value === "") {
        alert("pw");
        frm.pw.focus();
        return false;
    }
    if (document.frm.pw.value != document.frm.pw_check.value) {
        alert("not equal");
        frm.pw_check.focus();
        return false;
    }
    if (document.frm.re_id.value === "") {
        alert("do id check");
        frm.id.focus();
        return false;
    }

    return true;
}

function joinCheck() {
    if (document.frm.name.value.length === 0) {
        alert("name");
        frm.name.focus();
        return false;
    }
    if (document.frm.pw.value === "") {
        alert("pw");
        frm.pw.focus();
        return false;
    }
    if (document.frm.pw.value != document.frm.pw_check.value) {
        alert("not equal");
        frm.pw_check.focus();
        return false;
    }
    if (document.frm.re_id.value === "") {
        alert("do id check");
        frm.id.focus();
        return false;
    }

    return true;
};

function idok(id) {
    opener.frm.id.value = document.frm.id.value;
    opener.frm.re_id.value = document.frm.id.value;
    self.close();
};

function boardCheck() {
    if (document.frm.pass.value === "") {
        alert("pw");
        document.frm.pass.focus();
        return false;
    }
    if (document.frm.title.value === "") {
        alert("title");
        document.frm.title.focus();
        return false;
    }
    if (document.frm.content.value === "") {
        alert("content");
        document.frm.content.focus();
        return false;
    }

    return true;
};

function open_win(url, name) {
    var opt = "toolbar=no, menubar=no, resizable=no, width=450, height=200";
    window.open(url, name, opt);
};

function replyCheck() {
    if (document.frm2.content.value === "") {
        alert("content");
        return false;
    }
    return true;
}