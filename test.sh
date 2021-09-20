set -e

./release.sh

java Application | diff -u --color - ./withoutParameter.txt

java Application 5 | diff -u --color - ./fiveChars.txt