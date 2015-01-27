jQuery.fn.reload = function () {
    b = this; /*div*/
    if (b.css("position") == "static") {
        q = true; b.addClass("position-relative")
    } b.append('<div class="widget-box-overlay"><span>Loading...</span></div>');
    b.one("reloaded.ace.widget", function () {
        b.find(".widget-box-overlay").remove();
        if (q) {
            b.removeClass("position-relative")
        }
    });
    return this;
}
jQuery.fn.reloaded = function () {
    b = this; /*div*/
    b.trigger('reloaded.ace.widget');
    return this;
}