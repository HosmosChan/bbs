$(function () {
    $("#tijiao").click(function () {
        alert("Text: " + $("#select").find("option:selected").text());
    });
});