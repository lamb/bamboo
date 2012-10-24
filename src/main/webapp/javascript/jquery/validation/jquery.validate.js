(function($) {
  $.extend($.fn, {
    validate : function(callback) {
      this.ajaxForm({
        dataType : 'json',
        success : function(errors) {
          if (!errors.length) {
            window.location.href = callback;
          } else {
            for ( var i = 0; i < errors.length; i++) {
              var error = errors[i];
              var field = $("*[name='" + error.field + "']");
              field.after('<span class="label label-important">' + error.defaultMessage + '</span>');
            }
          }
        }
      });
    }
  });
}(jQuery));