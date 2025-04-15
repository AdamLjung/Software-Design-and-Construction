#include <stdio.h>
#include <QCoreApplication>
#include <QTranslator>

extern "C" void setuplocale();

class TestTranslation : public QCoreApplication /* an application without GUI */
{
public:
  TestTranslation(int argc, char** argv) : QCoreApplication(argc, argv)
  {
    /* Install a translator */
    // https://doc.qt.io/archives/qt-5.9/qtlinguist-hellotr-example.html

    QTranslator translator;
    translator.load("example_sv");
    app.installTranslator(&translator);


    /* Mark strings for translation and use linguist to create translation files.
     * Output the translated strings
     *  */

    puts(QObject::tr("The current language is the default (C/POSIX)\n"));
    puts(QObject::tr("The horse can run.\n"));
    puts(QObject::tr("How fast can the horse run?\n"));
    puts(QObject::tr("It typically runs at speed of less than 50 km/h.\n"));
  }
};

int main(int argc, char** argv)
{
  setuplocale();
  TestTranslation test(argc, argv);
  return 0;
}
