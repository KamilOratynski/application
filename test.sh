set -eo pipefail

javac -cp junit-platform-console-standalone-1.8.1.jar Application.java

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner --details=none -cp . -c Application

java Application | grep '^Usage: .\+' > /dev/null

echo q | java Application 0 | diff -Zu --color - <(cat <<<'')

echo q | java Application 1 | diff -Zu --color - <(cat <<<'x')

echo q | java Application 2 | diff -Zu --color - <(cat <<<'xx')

echo q | java Application 0 z | diff -Zu --color - <(cat <<<'')

echo q | java Application 1 z | diff -Zu --color - <(cat <<<'z')

echo q | java Application 2 z | diff -Zu --color - <(cat <<<'zz')

echo 1a q | java Application 1 y | diff -Zu --color - <(cat <<<'y
a')

echo 1a q | java Application 2 y | diff -Zu --color - <(cat <<<'yy
ay')

echo 2a q | java Application 2 y | diff -Zu --color - <(cat <<<'yy
ya')

echo 1x 2y q | java Application 2 z | diff -Zu --color - <(cat <<<'zz
xz
xy')

echo 1x 2y 3a q | java Application 5 z | diff -Zu --color - <(cat <<<'zzzzz
xzzzz
xyzzz
xyazz')

echo 1x 2y 3a 1q 2w 3e q | java Application 3 z | diff -Zu --color - <(cat <<<'zzz
xzz
xyz
xya
qya
qwa
qwe')

echo 10a q | java Application 10 y | diff -Zu --color - <(cat <<<'yyyyyyyyyy
yyyyyyyyya')

echo 10a 1q 2w 6e q | java Application 10 y | diff -Zu --color - <(cat <<<'yyyyyyyyyy
yyyyyyyyya
qyyyyyyyya
qwyyyyyyya
qwyyyeyyya')

echo OK