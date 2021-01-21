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