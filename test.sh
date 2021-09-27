set -e

javac -cp junit-platform-console-standalone-1.8.1.jar Application.java

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner --details=none -cp . -c Application

java Application | diff -Zu --color - ./default.txt

java Application 0 | diff -Zu --color - ./0.txt

java Application 1 | diff -Zu --color - ./1.txt

java Application 2 | diff -Zu --color - ./2.txt
