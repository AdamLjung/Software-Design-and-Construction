#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include "lua.h"
#include "lualib.h"
#include "lauxlib.h"

static double fromC(double v)
{
  return -v;
}

static int _fromC (lua_State *L) {
      double d = luaL_checknumber(L, 1); /* get argument */
      lua_pushnumber(L, fromC(d)); /* push result */
      return 1;  /* number of results */
}

int main ( int argc, char *argv[] )
{
    int status, result;
   
    lua_State *L;

    /* initialize Lua */
    L = luaL_newstate();

    /* load Lua base libraries */
    luaL_openlibs(L);

    /* TODO: load and run the test.lua file */
    if (luaL_loadfile(L, "test.lua") || lua_pcall(L, 0, 0, 0)){
      printf("Cant load file hehe");
      }

    /* TODO: Call the lua version of the addFromC function from test.lua */
    lua_pushcfunction(L, _fromC);
    lua_setglobal(L, "fromC");

    lua_getglobal(L, "addFromC");
    lua_pushnumber(L, 41);
    lua_pushnumber(L, 22);

    // State, antal argument, antal resulat, errorfunc
    lua_pcall(L,2,1, 0);
    /* cleanup Lua */
    lua_close(L);

    double res = lua_tonumber(L,-1);
    printf("Resultat: %f", res);
    printf("\n");
    return 0;
}
