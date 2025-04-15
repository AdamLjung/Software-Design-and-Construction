#include <libintl.h>

void setup()
{
  /* Your code here. Setup a domain for gettext. */
  bindtextdomain("messages","./"); 
  textdomain("messages");
  /* Use UTF-8 or gettext prints question marks for your Swedish letters */
  bind_textdomain_codeset("messages" , "utf8"); 
}
