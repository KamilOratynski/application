set -exo pipefail

javac -cp junit-platform-console-standalone-1.8.1.jar Application.java

java -jar ./junit-platform-console-standalone-1.8.1.jar --disable-banner --details=none -cp . -c Application

java Application | grep '^Usage: .\+' >/dev/null

echo 2w q | java Application 1 | diff -Zu --color - <(cat <<<'x
Position of char to be replaced is too high.')

echo q | java Application 0 | diff -Zu --color - <(printf "")

echo q | java Application 1 | diff -Zu --color - <(cat <<<'x')

echo q | java Application 2 | diff -Zu --color - <(cat <<<'xx
xx')

echo q | java Application 0 z | diff -Zu --color - <(printf "")

echo q | java Application 1 z | diff -Zu --color - <(cat <<<'z')

echo q | java Application 2 z | diff -Zu --color - <(cat <<<'zz
zz')

echo 1a q | java Application 1 y | diff -Zu --color - <(cat <<<'y
a')

echo 1a q | java Application 2 y | diff -Zu --color - <(cat <<<'yy
yy
ay
yy')

echo 2a q | java Application 2 y | diff -Zu --color - <(cat <<<'yy
yy
ya
yy')

echo 1x 2y q | java Application 2 z | diff -Zu --color - <(cat <<<'zz
zz
xz
zz
xy
zz')

echo 3x 4y q | java Application 2 z | diff -Zu --color - <(cat <<<'zz
zz
zz
xz
zz
xy')

echo 1x 2y 3a q | java Application 3 z | diff -Zu --color - <(cat <<<'zzz
zzz
zzz
xzz
zzz
zzz
xyz
zzz
zzz
xya
zzz
zzz')

echo 1x 2y 3a 1q 6w 9e q | java Application 3 z | diff -Zu --color - <(cat <<<'zzz
zzz
zzz
xzz
zzz
zzz
xyz
zzz
zzz
xya
zzz
zzz
qya
zzz
zzz
qya
zzw
zzz
qya
zzw
zze')

echo 9x 8y 7a q | java Application 3 z | diff -Zu --color - <(cat <<<'zzz
zzz
zzz
zzz
zzz
zzx
zzz
zzz
zyx
zzz
zzz
ayx')

echo 16a q | java Application 4 y | diff -Zu --color - <(cat <<<'yyyy
yyyy
yyyy
yyyy
yyyy
yyyy
yyyy
yyya')

echo OK
