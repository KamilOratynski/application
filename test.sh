set -e

javac -cp junit-platform-console-standalone-1.8.1.jar Application.java

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner --details=none -cp . -c Application

java Application | diff -Zu --color - ./default.txt

java Application 0 | diff -Zu --color - ./0.txt

java Application 1 | diff -Zu --color - ./1.txt

java Application 2 | diff -Zu --color - ./2.txt

java Application 0 z | diff -Zu --color - ./0.txt

java Application 1 z | diff -Zu --color - ./1z.txt

java Application 2 z | diff -Zu --color - ./2z.txt

echo 1a | java Application 2 y | diff -Zu --color - ./2yReplace1a.txt