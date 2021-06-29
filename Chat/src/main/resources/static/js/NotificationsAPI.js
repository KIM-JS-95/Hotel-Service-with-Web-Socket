  function mailMe() {
  var parameter_noti = {
	title:" Web Notification",
	icon:"!!!!",
	body:"Web Notification share test"
  };
  if (!"Notification" in window) {
    alert("This browser does not support desktop notification");
  }
  else if (Notification.permission === "granted") {
    var notification = new Notification(parameter_noti.title,{
    	icon:parameter_noti.icon,
    	body:parameter_noti.body
    });
  }
  else if (Notification.permission !== 'denied') {
    Notification.requestPermission(function (permission) {
      if(!('permission' in Notification)) {
        Notification.permission = permission;
      }
      if (permission === "granted") {
        var notification = new Notification(parameter_noti.title,{
        	icon:parameter_noti.icon,
        	body:parameter_noti.body
        });
      }
    });
  }
}