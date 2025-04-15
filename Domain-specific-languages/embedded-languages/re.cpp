#include <fstream>
#include <regex>
#include <iostream>
#include <sstream>

using namespace std;


int main(int argc, char** argv)
{
  ifstream in1("file1.txt");
  string str;
  ifstream in2("file2.txt");


  //stringstream ss;
  //ss << in1.rdbuf();
  //str = ss.str();
  
  regex regMemory(R"(^[^,]+,(19|20|21|22|23),[^,]+,[^,]+.*memory)");
  regex regSed(R"(^("Carl"|"Diana");([^;]+);([^;]+))");


  //cout << str << "\n";

  


  // TODO: Create a regular expression object; you don't want to create a new
  // object in each iteration of the loop
  string line2;
  while(getline(in2,line2)){

    cout << regex_replace(line2, regSed, "$1,4,$3") << "\n";

  }

  


  
 
  string line;
  int count = 0;
  while (getline(in1, line)) {
    if(regex_search(line, regMemory)){
      //cout << line << "\n";
      //count ++;
    }
  }
  //cout << count << "\n";
}
