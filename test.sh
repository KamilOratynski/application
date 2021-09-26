set -e

./release.sh
./unittests.sh

java Application | diff -u --color - ./default.txt

java Application 0 | diff -u --color - ./0.txt

java Application 1 | diff -u --color - ./1.txt

java Application 2 | diff -u --color - ./2.txt
