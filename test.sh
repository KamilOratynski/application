set -e

javac -cp junit-platform-console-standalone-1.8.1.jar Application.java

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner --details=none -cp . -c Application

java Application | diff -Zu --color - ./default.txt

echo q | java Application 0 | diff -Zu --color - ./0.txt

echo q | java Application 1 | diff -Zu --color - ./1.txt

echo q | java Application 2 | diff -Zu --color - ./2.txt

echo q | java Application 0 z | diff -Zu --color - ./0.txt

echo q | java Application 1 z | diff -Zu --color - ./1z.txt

echo q | java Application 2 z | diff -Zu --color - ./2z.txt

(echo -e "1a\n" & sleep .1 ; echo -e "q\n") | java Application 1 y | diff -Zu --color - ./1yReplace1a.txt

(echo -e "1a\n" & sleep .1 ; echo -e "q\n") | java Application 2 y | diff -Zu --color - ./2yReplace1a.txt

(echo -e "2a\n" & sleep .1 ; echo -e "q\n") | java Application 2 y | diff -Zu --color - ./2yReplace2a.txt

(echo -e "1x\n" & sleep .1 ; echo -e "2y\n" & sleep .1 ; echo -e "q\n") | java Application 2 z | diff -Zu --color - ./startZZendXY.txt

(echo -e "1x\n" & sleep .1 ; echo -e "2y\n" & sleep .1 ; echo -e "3a\n" & sleep .1 ; echo -e "q\n") | java Application 5 z | diff -Zu --color - ./startZZZZZendXYAZZ.txt

(echo -e "1x\n" & sleep .1 ; echo -e "2y\n" & sleep .1 ; echo -e "3a\n" & sleep .1 ; echo -e "1x\n" & sleep .1 ; echo -e "2y\n" & sleep .1 ; echo -e "3a\n" & sleep .1 ; echo -e "q\n") | java Application 3 z | diff -Zu --color - ./startZZZendXYAtwice.txt