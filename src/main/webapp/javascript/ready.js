$(document).ready(function() {
  $('code, pre').addClass('prettyprint');
  prettyPrint();

  var sss = 'url';
  $('#project').ajaxForm({
    // dataType identifies the expected content type of the server response
    dataType : 'json',
    success : function(data) {
      alert(data);
      alert(sss);
    }
  });
});
