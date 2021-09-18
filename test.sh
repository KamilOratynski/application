./release.sh

java Application | diff -u --color - ./expected.txt