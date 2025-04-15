#include <stdio.h>

int main(int argc, char **argv)
{
  /* Note: dlopen does not exist on Windows and the filename will not be .so.
   * If you are performing the labs on Windows, you need to change this.
   */
  void *ptr = dlopen("libcopyfile.so", RTLD_LAZY);
  /* TODO: Call copy_files() from the opened shared object */

  { /* Disable this if --without-trig-functions or -DTRIG_FUNCTIONS:BOOL=OFF */
    double d = cos(1.5);
    printf("The result of cos (a trigonometric function) is: %f\n", d);
  }
}
