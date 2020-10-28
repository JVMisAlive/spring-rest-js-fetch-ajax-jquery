$(document).ready(function () {
    getAuthUserInfo();
    getUserInfo()
})

function authUser(title, roles) {
    document.getElementById("userTitle").textContent = title;
    document.getElementById("roleTitle").textContent = roles;
}

async function getAuthUserInfo() {
    fetch("/user/authUser")
        .then(response => (response.json()))
        .then(data => {
            authUser(data.uEmail, JSON.stringify(data.uSetRoles
                .map(role => role.name.substring(5)).join(", ")));
        })
}

$("#v-pills-profile-tab").click(function () {
    $("#userInformation").empty();
    $.ajax({
        type: 'GET',
        url: '/user/authUser',
        dataType: "json",
        success: function (data) {
            $('#userInformation').append($('<tr>').append(
                $('<td>').text(data.uId),
                $('<td>').text(data.uNickname),
                $('<td>').text(data.uFirstName),
                $('<td>').text(data.uLastName),
                $('<td>').text(data.uAge),
                $('<td>').text(data.uEmail),
                $('<td>').text(data.uPassword),
                $('<td>').text(JSON.stringify(data.uSetRoles.map(role => role.name.substring(5)).join(", ")))
            ))
        }
    });
});

function getUserInfo() {
    $("#userInformation").empty();
    $.ajax({
        type: 'GET',
        url: 'user/authUser',
        dataType: "json",
        success: function (data) {
            $('#userInformation').append($('<tr>').append(
                $('<td>').text(data.uId),
                $('<td>').text(data.uNickname),
                $('<td>').text(data.uFirstName),
                $('<td>').text(data.uLastName),
                $('<td>').text(data.uAge),
                $('<td>').text(data.uEmail),
                $('<td>').text(data.uPassword),
                $('<td>').text(data.uSetRoles.map(role => role.name.substring(5)).join(", "))
            ))
        }
    });
}