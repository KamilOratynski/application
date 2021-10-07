set -e

javac -cp junit-platform-console-standalone-1.8.1.jar Application.java

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner --details=none -cp . -c Application

echo 2z | java Application | diff -Zu --color - ./missingParam.txt

echo 2z | java Application 0 | diff -Zu --color - ./missingParam.txt

echo 1z | java Application 1 | diff -Zu --color - ./1.txt

echo 2z | java Application 2 | diff -Zu --color - ./2.txt

echo 2z | java Application 0 z | diff -Zu --color - ./missingParam.txt

echo 1x | java Application 1 z | diff -Zu --color - ./1z.txt

echo 2x | java Application 2 z | diff -Zu --color - ./2z.txt
