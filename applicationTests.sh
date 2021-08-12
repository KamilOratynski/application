echo "xxxx" > expected.txt

java Application.java > output.txt

diff -b --color expected.txt output.txt && rm expected.txt output.txt
