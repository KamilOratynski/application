set -e

./release.sh

java Application | diff -u --color - ./default.txt

java Application 5 | diff -u --color - ./5.txt