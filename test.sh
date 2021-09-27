set -e

./compile.sh

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner -cp . -c Application

java Application | diff -u --color - ./default.txt

java Application 0 | diff -u --color - ./0.txt

java Application 1 | diff -u --color - ./1.txt

java Application 2 | diff -u --color - ./2.txt
